package qa.tests.employee;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.models.responses.employee.AddEmployeeResponse;
import qa.services.employee.AddEmployeeService;
import qa.tests.BaseAuthenticatedTest;
import qa.utils.ApiResponse;
import qa.utils.FakerDataGenerator;

public class AddEmployeeTest extends BaseAuthenticatedTest {

    @Test
    public void addEmployeeSuccessfully() {
        ApiResponse<AddEmployeeResponse> response = AddEmployeeService.addEmployee();

        AddEmployeeResponse responseBody = response.getResponseBody();

        Assert.assertNotNull(responseBody.data.createEmployee.id);
    }

    @Test
    public void addEmployee_field_wajib_dikosongkan() {

        ApiResponse<AddEmployeeResponse> response =
                AddEmployeeService.addEmployee(
                        FakerDataGenerator.validName(),
                        FakerDataGenerator.validEmployeeId(),
                        FakerDataGenerator.validEmail(),
                        FakerDataGenerator.validPhoneNumber(),
                        "28eca519-4fe1-4943-a1c5-6da04cf9371d",
                        null
                );

        AddEmployeeResponse body = response.getResponseBody();

        Assert.assertNull(body.data, "Data harus null");
        Assert.assertNotNull(body.errors, "Errors harus ada");
    }

    @Test
    public void addEmployeeInvalidEmail() {

        ApiResponse<AddEmployeeResponse> response =
                AddEmployeeService.addEmployee(
                        FakerDataGenerator.validName(),
                        FakerDataGenerator.validEmployeeId(),
                        FakerDataGenerator.invalidEmail(),
                        FakerDataGenerator.validPhoneNumber(),
                        "43b462d2-e360-46e2-b6bd-73b3f5fb0721",
                        "Mentor"
                );

        AddEmployeeResponse body = response.getResponseBody();

        Assert.assertNull(
                body.data,
                "Employee tetap dibuat padahal email tidak valid"
        );

        Assert.assertNotNull(
                body.errors,
                "Error seharusnya muncul ketika email invalid"
        );
    }

    @Test
    public void addEmployeeDuplicate() {

        ApiResponse<AddEmployeeResponse> response =
                AddEmployeeService.addEmployee(
                        "Dafit",
                        "012",
                        "dafit78@gmail.com",
                        "081288405512",
                        "28eca519-4fe1-4943-a1c5-6da04cf9371d",
                        "Mentor"
                );

        AddEmployeeResponse body = response.getResponseBody();

        Assert.assertNull(body.data);
        Assert.assertTrue(
                body.errors.get(0).message.contains("already registered")
        );
    }

    @Test
    public void addEmployee_phoneNumberInvalid() {

        ApiResponse<AddEmployeeResponse> response =
                AddEmployeeService.addEmployee(
                        FakerDataGenerator.validName(),
                        FakerDataGenerator.validEmployeeId(),
                        FakerDataGenerator.validEmail(),
                        "abc@#$",
                        "43b462d2-e360-46e2-b6bd-73b3f5fb0721",
                        "Mentor"
                );

        AddEmployeeResponse body = response.getResponseBody();

        Assert.assertNull(body.data);
        Assert.assertNotNull(body.errors);
    }
}
