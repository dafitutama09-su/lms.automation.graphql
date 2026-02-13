package qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.client.GraphQlClient;

public class ApiTestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("LISTENER ACTIVE");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("\n===== TEST FAILED =====");
        System.out.println("Test Name : " + result.getName());

        System.out.println("\n--- GraphQL QUERY ---");
        System.out.println(GraphQlClient.getLastQuery());

        System.out.println("\n--- VARIABLES ---");
        System.out.println(GraphQlClient.getLastVariables());

        System.out.println("\n--- RESPONSE ---");
        System.out.println(GraphQlClient.getLastResponse());

        System.out.println("=====================\n");
    }
}