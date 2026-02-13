package qa.models.responses.employee;

import qa.models.common.GraphQLError;
import java.util.List;

public class AddEmployeeResponse {

    public Data data;
    public List<GraphQLError> errors;

    public static class Data {
        public CreateEmployee createEmployee;
    }

    public static class CreateEmployee {
        public String id;
    }
}
