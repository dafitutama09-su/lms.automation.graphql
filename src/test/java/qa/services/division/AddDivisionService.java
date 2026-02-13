package qa.services.division;

import io.restassured.response.Response;
import qa.client.GraphQlClient;
import qa.models.requests.division.AddDivisionVariable;
import qa.models.responses.division.AddDivisionResponse;
import qa.utils.ApiResponse;
import qa.utils.FakerDataGenerator;
import qa.utils.TestDataLoader;

import java.util.Map;

public class AddDivisionService {


    public static ApiResponse<AddDivisionResponse> addDivision() {
        return addDivision(
                FakerDataGenerator.validDivisionName(),
                FakerDataGenerator.validDescription()
        );
    }


    public static ApiResponse<AddDivisionResponse> addDivision(
            String name,
            String description
    ) {
        String query =
                TestDataLoader.load("graphql/mutations/AddDivision.graphql");

        Map<String, Object> variables =
                AddDivisionVariable.variables(name, description);

        System.out.println("Query: " + query);
        System.out.println("Variables: " + variables);

        Response response =
                GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(AddDivisionResponse.class)
        );
    }
}