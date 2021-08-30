package selenium;

import PageObjects.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBuyItem extends BaseClass {

    //Proyecto Alvaro Espinoza TESTCASE 03
    @Test(description = "Test Basic Functionality Buying Item")
    public void Test_BuyingItem_Basic(){
        int quantity = 3;
        String expectedMessage = "Products marked with *** are not available in the desired quantity or not in stock!";
        String productName = "MacBook Air";
        homePage().EnterProduct(productName);
        searchResultsPage().ClickOnProductLink();
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());

        headerPage().clickOnCartButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        shoppingCartPage().ClickOnCheckoutButton();

        Assert.assertTrue(shoppingCartPage().GetErrorBuyingMessage().contains(expectedMessage));

    }

}
