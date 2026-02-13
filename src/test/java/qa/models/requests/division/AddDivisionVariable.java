package qa.models.requests.division;

import java.util.HashMap;
import java.util.Map;

public class AddDivisionVariable {

    public static Map<String, Object> variables(
            String name,
            String description
    ) {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("name", name);
        inputData.put("description", description);

        Map<String, Object> inputVariables = new HashMap<>();
        inputVariables.put("input", inputData);

        return inputVariables;
    }
}