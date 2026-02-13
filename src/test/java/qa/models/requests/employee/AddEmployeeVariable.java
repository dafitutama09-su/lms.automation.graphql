package qa.models.requests.employee;

import java.util.HashMap;
import java.util.Map;

public class AddEmployeeVariable {
  public static Map<String, Object> variables(
      String name,
      String employeeId,
      String email,
      String phoneNumber,
      String divisionId,
      String employeeRole
  ) {
    Map<String, Object> inputData = new HashMap<>();
    inputData.put("name", name);
    inputData.put("employeeId", employeeId);
    inputData.put("email", email);
    inputData.put("phoneNumber", phoneNumber);
    inputData.put("divisionId", divisionId);
    inputData.put("employeeRole", employeeRole);


    // Wrap it in the variables map
    Map<String, Object> inputVariables = new HashMap<>();
    inputVariables.put("input", inputData);

    return inputVariables;
  }
}
