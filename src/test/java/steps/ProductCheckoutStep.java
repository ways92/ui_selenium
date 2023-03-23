package steps;

import hook.HookDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductCheckoutPage;

public class ProductCheckoutStep extends HookDriver {
    protected LoginPage loginPage = new LoginPage();
    protected ProductCheckoutPage PCP = new ProductCheckoutPage();
    private String myAddressText = "Banyuwangi Regency, East Java, Indonesia";

    public void loginStep(){
        loginPage
                .goLoginPage()
                .enterEmail(emailValid)
                .enterPassword(passValid)
                .clickLogin();
    }
    @Test
    public void checkoutProductValid() throws InterruptedException {
        loginStep();
        PCP.navigateCartPage().selectAddress().fillAddress();
        Thread.sleep(15000);

    }
}
