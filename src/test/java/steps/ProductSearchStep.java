package steps;

import hook.HookDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductSearchPage;

public class ProductSearchStep extends HookDriver {


    protected LoginPage loginPage = new LoginPage();
    protected ProductSearchPage PS = new ProductSearchPage();
    public String searchInput = "Spanduk Indoor";

    @Test (priority = 0)
    public void searchProductValid() throws InterruptedException {
        PS
                .fillSearch(searchInput)
                .verifySearchProduct(searchInput);
    }

    @Test
    public void searchProductInvalid() throws InterruptedException {
        PS
                .fillSearch("!@#$%")
                .verifyNotFoundProduct();
    }

}
