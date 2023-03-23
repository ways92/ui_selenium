package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    protected static WebDriver driver;
    public String browserName;
    public String baseUrl;
    public String emailValid;
    public String passValid;
    public Properties properties = new Properties();
    protected FileInputStream fis = null;
    protected static WebDriverWait wait;

    public void setWaitTime(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loadBrowser() {
        try {
            fis = new FileInputStream("src/test/java/config/config.properties");
            properties.load(fis);
            browserName = properties.getProperty("browser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadBaseUrl() {
        try {
            fis = new FileInputStream("src/test/java/config/config.properties");
            properties.load(fis);
            baseUrl = properties.getProperty("baseUrl");
            emailValid = properties.getProperty("EMAIL");
            passValid = properties.getProperty("PASS");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openBrowser() {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public void goToSite() {
        try {
            loadBaseUrl();
            driver.get(baseUrl);
        } catch (Exception e) {
            System.out.println("Unable to navigate to the page");
            e.printStackTrace();
        }
    }

    public void closeBrowser() {
        driver.close();
    }

}