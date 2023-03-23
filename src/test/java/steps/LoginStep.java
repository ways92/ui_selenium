package steps;
import hook.HookDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginStep extends HookDriver {

    protected LoginPage loginPage = new LoginPage();

    @Test
//            (priority = 1000, enabled = false)
    public void loginValid() throws InterruptedException {
        loginPage
                .goLoginPage()
                .enterEmail(emailValid)
                .enterPassword(passValid)
                .clickLogin()
                .verifyLogin();
        Thread.sleep(3000);
    }

    @Test
//            (priority = 2, enabled = false)
    public void invalidEmail() throws InterruptedException {
        loginPage
                .goLoginPage()
                .enterEmail("qwerty")
                .enterPassword(passValid)
                .clickLogin()
                .verifyInvalidEMail();
        Thread.sleep(3000);
    }

    @Test
//            (priority = 3, enabled = false)
    public void invalidPass() throws InterruptedException {
        loginPage
                .goLoginPage()
                .enterEmail(emailValid)
                .enterPassword("qwerty")
                .clickLogin()
                .verifyErrorLogin();
        Thread.sleep(3000);
    }

    @Test
//            (priority = 4, enabled = false)
    public void emptyEmail() throws InterruptedException {
        loginPage
                .goLoginPage()
                .enterEmail("")
                .enterPassword(passValid)
                .clickLogin()
                .verifyEmptyEmail();
        Thread.sleep(3000);
    }

    @Test
//            (priority = 5)
    public void emptyPass() throws InterruptedException {
        loginPage
                .goLoginPage()
                .enterEmail(emailValid)
                .enterPassword("")
                .clickLogin()
                .verifyEmptyPass();
        Thread.sleep(3000);
    }
}
