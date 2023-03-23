package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductSearchPage extends BaseClass {

    private By searchField = By.xpath("//input[@data-cy='SearchInput-search']");
    private By produckAppear = By.xpath("//h1[@class='med-24 text-n-90 mb-3']");
    private By produckNotFound = By.xpath("//p[@data-cy='SearchInput-productNotFound']");

    public ProductSearchPage fillSearch(String fillText) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        WebElement inputSearch = driver.findElement(searchField);
        inputSearch.clear();
        inputSearch.sendKeys(fillText);
        Thread.sleep(3000);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public ProductSearchPage verifySearchProduct(String expectAppear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(produckAppear));
        String testSearch = driver.findElement(produckAppear).getText();
        Assert.assertEquals(testSearch, expectAppear);
        return this;
    }

    public ProductSearchPage verifyNotFoundProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(produckNotFound));
        String testSearch = driver.findElement(produckNotFound).getText();
        System.out.println(testSearch);
//        Assert.assertEquals(testSearch, expectAppear);
        return this;
    }
}
