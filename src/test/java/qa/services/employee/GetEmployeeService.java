package qa.services.employee;

import io.restassured.response.Response;
import qa.client.GraphQlClient;
import qa.models.responses.employee.GetEmployeeResponse;
import qa.utils.ApiResponse;
import qa.utils.TestDataLoader;

public class GetEmployeeService {

  public static ApiResponse<GetEmployeeResponse> getMe() {
    String query = TestDataLoader.load("graphql/queries/Me.graphql");

    Response response = GraphQlClient.execute(query);

    GetEmployeeResponse meResponse = response.as(GetEmployeeResponse.class);

    return new ApiResponse<>(
        response.getStatusCode(),
        response.getHeaders(),
        meResponse
    );
  }
}
