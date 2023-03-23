package hook;
import base.BaseClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class HookDriver extends BaseClass {

    @BeforeTest
    public void openBrow() {
        loadBrowser();
        openBrowser();
        setWaitTime();
    }

    @BeforeMethod
    public void goToPage(){
        goToSite();
    }


    @AfterTest
    public void closeBrow() {
        closeBrowser();
    }
}
