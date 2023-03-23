package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAddPage extends BaseClass {

    private By templateButton = By.id("pdp-cta");
    private By templateAndDesignButton = By.xpath("//div[contains(text(),'Love Karaage')]");
    private By  personalisasiDesainButton = By.xpath("//button[contains(text(),'Personalisasi Desain')]");
    private By skipButton = By.xpath("//button[@data-action='skip']");

    public ProductAddPage clickTemplateButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(templateButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipButton));
        WebElement skipField = driver.findElement(skipButton);
        if (skipField.isDisplayed())skipField.click();
        driver.findElement(templateButton).click();
        return this;
    }

    public ProductAddPage selectTemplateAndDesign(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(templateAndDesignButton));
        driver.findElement(templateAndDesignButton).click();
        return this;
    }

    public ProductAddPage clickPersonalisaiDesain(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalisasiDesainButton));
        driver.findElement(personalisasiDesainButton).click();
        return this;
    }
}
