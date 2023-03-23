package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductCheckoutPage extends BaseClass {

    private By iconCart = By.xpath("//button[@class='position-relative pb-n2 btn btn-outline-link']");
    private By addressButton = By.xpath("//button[@data-cy='Address']");
    private By closeIcon = By.xpath("//button[@class='close']");
    private By verifyLabelAddress = By.xpath("//div[@data-cy='CartPage-AddressLabel']");
    private By myAddressField = By.xpath("//div[@class='med-14 mb-2'][contains(text(),'Rumah Saya')]");

    private By paymentButton = By.xpath("//button[@data-cy='Summary-selectPayment']");
    private By verifyPaymentPage = By.xpath("//h2[contains(text(),'Metode Pembayaran')]");

    public ProductCheckoutPage navigateCartPage() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(iconCart).click();
        return this;
    }

    public ProductCheckoutPage selectAddress() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(addressButton));
        WebElement labelAddress =  driver.findElement(verifyLabelAddress);
        Thread.sleep(3000);
        driver.findElement(addressButton).click();
        Thread.sleep(3000);
        WebElement myAddress =  driver.findElement(myAddressField);
        if (labelAddress.getText() == "Rumah Saya")myAddress.click();
        WebElement closeModal = driver.findElement(closeIcon);
        if (closeModal.isDisplayed()) closeModal.click();
        return this;
    }

    public ProductCheckoutPage fillAddress() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(paymentButton));
        driver.findElement(paymentButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(verifyPaymentPage));
        WebElement labelPayment = driver.findElement(verifyPaymentPage);
        Assert.assertTrue(labelPayment.isDisplayed());
        return this;
    }
}
