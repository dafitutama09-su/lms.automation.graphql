package qa.tests;

import org.testng.annotations.BeforeMethod;
import qa.services.AuthService;
import qa.client.AuthSession;

public abstract class BaseAuthenticatedTest {

    @BeforeMethod(alwaysRun = true)
    public void authenticate() {
        if (!AuthSession.isSessionActive()) {
            AuthService.postLogin();
        }
    }
}
