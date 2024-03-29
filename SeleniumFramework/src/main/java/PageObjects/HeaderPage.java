package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By yourStoreButtonLocator = By.linkText("Your Store");
    private By currencyOptions = By.xpath("//div[@class='pull-left']//button");
    private By currencyEuro = By.name("EUR");
    private By currencyPound = By.name("GBP");
    private By currencyDollar = By.name("USD");


    public HeaderPage(WebDriver _driver){
        super(_driver);
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }
    public void clickOnYourStoreButton() {driver.findElement(yourStoreButtonLocator).click();}

    public void ClickOnCurrencyOptions(){
        this.driver.findElement(currencyOptions).click();
    }

    public void ClickOnUSDCurrencyOption(){
        this.driver.findElement(currencyDollar).click();
    }

    public void ClickOnEURCurrencyOption(){
        this.driver.findElement(currencyEuro).click();
    }

    public void ClickOnGBPCurrencyOption(){
        this.driver.findElement(currencyPound).click();
    }
}
