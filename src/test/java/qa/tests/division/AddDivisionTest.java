package qa.tests.division;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.models.responses.division.AddDivisionResponse;
import qa.services.division.AddDivisionService;
import qa.tests.BaseAuthenticatedTest;
import qa.utils.ApiResponse;

public class AddDivisionTest extends BaseAuthenticatedTest {

    @Test
    public void addDivisionSuccessfully() {

        ApiResponse<AddDivisionResponse> response = AddDivisionService.addDivision();

        AddDivisionResponse responseBodybody = response.getResponseBody();

        Assert.assertNotNull(
                responseBodybody.data.createDivision.id,
                "ID division harus terbuat"
        );

    }
}