package qa.client;

import qa.models.responses.employee.GetEmployeeResponse;
import qa.services.employee.GetEmployeeService;
import qa.utils.ApiResponse;

public class AuthSession {

  private static String sessionCookie;

  public static void setSessionCookie(String sid) {
    sessionCookie = sid;
  }

  public static String getSessionCookie() {
    return sessionCookie;
  }

  public static boolean isSessionActive() {
    String sessionCookie = getSessionCookie();

    // Fast fail when cookie is not set
    if (sessionCookie == null || sessionCookie.isEmpty()) {
      return false;
    }

    ApiResponse<GetEmployeeResponse> meResponse = GetEmployeeService.getMe();
    return meResponse.getStatusCode() == 200;
  }

  public static void clearSession() {
      sessionCookie = null;
  }
}
