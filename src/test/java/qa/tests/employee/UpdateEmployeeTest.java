package qa.tests.employee;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.models.responses.employee.UpdateEmployeeResponse;
import qa.services.employee.UpdateEmployeeService;
import qa.tests.BaseAuthenticatedTest;
import qa.utils.ApiResponse;
import qa.utils.FakerDataGenerator;

public class UpdateEmployeeTest extends BaseAuthenticatedTest {

    @Test
    public void updateEmployeeSuccessfully() {

        ApiResponse<UpdateEmployeeResponse> response =
                UpdateEmployeeService.updateEmployee();

        UpdateEmployeeResponse responseBody =
                response.getResponseBody();

        Assert.assertNotNull(
                responseBody.data.updateEmployee.id
        );
    }

    @Test
    public void updateEmployee_PhoneNumber_Kosong() {

        ApiResponse<UpdateEmployeeResponse> response =
                UpdateEmployeeService.updateEmployee(
                        "62b0eea6-4375-442c-8688-4a361725ca20",
                        "",
                        "",
                        "",
                        "null",
                        "43b462d2-e360-46e2-b6bd-73b3f5fb0721",
                        "student"
                );

        UpdateEmployeeResponse body = response.getResponseBody();

        Assert.assertNull(
                body.data,
                "BUG: phoneNumber null masih bisa update"
        );
    }
}