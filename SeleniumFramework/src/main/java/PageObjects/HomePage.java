package PageObjects;

import Selectors.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private By searchBar = By.name("search");


    public HomePage(WebDriver _driver){
        super(_driver);
    }

    public String getFirstProductName(){
        return driver.findElement(HomePageLocators.FirstProductTitleSelector).getText();
    }
    public void selectProductByName(String name){
        driver.findElement(By.xpath(HomePageLocators.FirstH4Locator.replace("<name>", name))).click();
    }
    public String selectFirstProductAndGetName(){
        String name = getFirstProductName();
        selectProductByName(name);
        return name;
    }
    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnYourStoreButton();
    }

    public void EnterProduct(String productName){
        this.driver.findElement(searchBar).sendKeys(productName+Keys.ENTER);
    }
}
