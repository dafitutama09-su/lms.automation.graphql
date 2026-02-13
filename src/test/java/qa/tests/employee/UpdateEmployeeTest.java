package qa.tests.employee;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.models.responses.employee.UpdateEmployeeResponse;
import qa.services.employee.UpdateEmployeeService;
import qa.tests.BaseAuthenticatedTest;
import qa.utils.ApiResponse;

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
                        null,
                        "d0f0bc45-26ac-44f8-b2ac-826281750cbf",
                        "student"
                );

        Assert.assertNotNull(
                response.getRawResponse().jsonPath().get("errors"),
                "Error harus muncul ketika phone number kosong"
        );
    }
}