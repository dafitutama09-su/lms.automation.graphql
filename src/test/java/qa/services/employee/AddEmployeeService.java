package qa.services.employee;

import io.restassured.response.Response;
import qa.client.GraphQlClient;
import qa.models.requests.employee.AddEmployeeVariable;
import qa.models.responses.employee.AddEmployeeResponse;
import qa.utils.ApiResponse;
import qa.utils.FakerDataGenerator;
import qa.utils.TestDataLoader;

import java.util.Map;

public class AddEmployeeService {

    public static ApiResponse<AddEmployeeResponse> addEmployee() {
        return addEmployee(
                FakerDataGenerator.validName(),
                FakerDataGenerator.validEmployeeId(),
                FakerDataGenerator.validEmail(),
                FakerDataGenerator.validPhoneNumber(),
                "28eca519-4fe1-4943-a1c5-6da04cf9371d",
                "Mentor"
        );
    }

    public static ApiResponse<AddEmployeeResponse> addEmployee(
            String name,
            String employeeId,
            String email,
            String phone,
            String divisionId,
            String role
    ) {

        String query =
                TestDataLoader.load("graphql/mutations/AddEmployee.graphql");

        Map<String, Object> variables =
                AddEmployeeVariable.variables(
                        name,
                        employeeId,
                        email,
                        phone,
                        divisionId,
                        role
                );

        System.out.println("Query: " + query);
        System.out.println("Variables: " + variables);

        Response response =
                GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(AddEmployeeResponse.class)
        );
    }
}