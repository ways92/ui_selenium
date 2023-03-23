package steps;

import hook.HookDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductAddPage;
import pages.ProductSearchPage;

public class ProductAddStep extends HookDriver {

    protected LoginPage loginPage = new LoginPage();
    protected ProductSearchPage PS = new ProductSearchPage();
    public ProductAddPage PAP = new ProductAddPage();
    private String productAdd = "Label Stiker Kemasan Satuan (Die Cut)";

    public void loginStep(){
        loginPage
                .goLoginPage()
                .enterEmail(emailValid)
                .enterPassword(passValid)
                .clickLogin();
    }

    public void productSearchStep() throws InterruptedException {
        PS.fillSearch(productAdd);
    }

    @Test
    public void ProductAddValid() throws InterruptedException {
        loginStep();
        productSearchStep();
        PAP.clickTemplateButton().selectTemplateAndDesign();
        Thread.sleep(3000);
        PAP.clickPersonalisaiDesain();
    }
}
