package qa.models.requests.employee;

import java.util.HashMap;
import java.util.Map;

public class UpdateEmployeeVariable {

    public static Map<String, Object> variables(
            String id,
            String name,
            String employeeId,
            String email,
            String phoneNumber,
            String divisionId,
            String employeeRole
    ) {

        // ===== INPUT DATA =====
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("name", name);
        inputData.put("employeeId", employeeId);
        inputData.put("email", email);
        inputData.put("phoneNumber", phoneNumber);
        inputData.put("divisionId", divisionId);
        inputData.put("employeeRole", employeeRole);


        // ===== VARIABLES =====
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", id);
        variables.put("input", inputData);

        return variables;
    }
}