package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    private By enterLogin =  By.xpath( "//div[@class='med-14 text-br-40']");
    private By emailField =  By.name( "email");
    private By passwordField =  By.name("password");
    private By loginButton =  By.xpath("//button[@data-cy='LoginPage-submit']");
    private By notifField =  By.xpath("//div[@class='Toastify']");
    private By errorLoginField =  By.xpath("//li[@data-cy='LoginPage-alert']");
    private By emptyEmail =  By.xpath("//small[contains(text(),'Email tidak boleh kosong')]");
    private By invalidEmail =  By.xpath("//small[contains(text(),'email must be a valid email')]");
    private By alertPass =  By.xpath("//small[contains(text(),'Password tidak boleh kosong')]");


    public LoginPage goLoginPage() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.findElement(enterLogin).click();
        return this;
    }

    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String pass){
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage verifyLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(notifField));
        WebElement element = driver.findElement(notifField);
        Assert.assertTrue(element.isDisplayed());
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        return this;

    }

    public LoginPage verifyErrorLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorLoginField));
        WebElement element = driver.findElement(errorLoginField);
        Assert.assertTrue(element.isDisplayed());
        return this;

    }

    public LoginPage verifyInvalidEMail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmail));
        WebElement element = driver.findElement(invalidEmail);
        Assert.assertTrue(element.isDisplayed());
        return this;

    }

    public LoginPage verifyEmptyEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyEmail));
        WebElement element = driver.findElement(emptyEmail);
        Assert.assertTrue(element.isDisplayed());
        return this;

    }

    public LoginPage verifyEmptyPass() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertPass));
        WebElement element = driver.findElement(alertPass);
        Assert.assertTrue(element.isDisplayed());
        return this;

    }


}
