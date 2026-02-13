package qa.services.employee;

import io.restassured.response.Response;
import qa.client.GraphQlClient;
import qa.models.requests.employee.UpdateEmployeeVariable;
import qa.models.responses.employee.UpdateEmployeeResponse;
import qa.utils.ApiResponse;
import qa.utils.FakerDataGenerator;
import qa.utils.TestDataLoader;

import java.util.Map;

public class UpdateEmployeeService {

    public static ApiResponse<UpdateEmployeeResponse> updateEmployee() {
        return updateEmployee(
                "62b0eea6-4375-442c-8688-4a361725ca20",
                "",
                "",
                FakerDataGenerator.validEmail(),
                FakerDataGenerator.validPhoneNumber(),
                "43b462d2-e360-46e2-b6bd-73b3f5fb0721",
                "student"

        );
    }

    public static ApiResponse<UpdateEmployeeResponse> updateEmployee(
            String id,
            String name,
            String employeeId,
            String email,
            String phoneNumber,
            String divisionId,
            String employeeRole
    ) {

        String query =
                TestDataLoader.load("graphql/mutations/UpdateEmployee.graphql");

        Map<String, Object> variables =
                UpdateEmployeeVariable.variables(
                        id,
                        name,
                        employeeId,
                        email,
                        phoneNumber,
                        divisionId,
                        employeeRole
                );

        System.out.println("Query: " + query);
        System.out.println("Variables: " + variables);

        Response response =
                GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(UpdateEmployeeResponse.class),
                response
        );
    }
}
