package qa.tests.employee;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.models.responses.employee.GetEmployeeResponse;
import qa.services.employee.GetEmployeeService;
import qa.tests.BaseAuthenticatedTest;
import qa.utils.ApiResponse;
import qa.utils.Utils;

public class GetEmployeeTest extends BaseAuthenticatedTest {

  @Test
  public void getManage_Employee_List() {
    ApiResponse<GetEmployeeResponse> response = GetEmployeeService.getMe();
    GetEmployeeResponse responseBody = response.getResponseBody();

    Assert.assertNotNull(responseBody.data.me.id);
    Assert.assertNotNull(responseBody.data.me.name);
    Utils.assertValidEmail(responseBody.data.me.email);
    Assert.assertNotNull(responseBody.data.me.phoneNumber);
    Assert.assertNotNull(responseBody.data.me.role);
  }
}
