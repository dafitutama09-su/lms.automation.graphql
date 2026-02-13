package qa.tests;

import org.testng.annotations.BeforeSuite;
import qa.services.AuthService;
import qa.client.AuthSession;

public abstract class BaseAuthenticatedTest {

    @BeforeSuite(alwaysRun = true)
    public void authenticate() {
        if (!AuthSession.isSessionActive()) {
            AuthService.postLogin();
        }
    }
}
