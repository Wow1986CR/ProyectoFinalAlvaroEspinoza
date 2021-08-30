package selenium;

import PageObjects.BaseClass;
import PageObjects.Utils;
import dataProviders.ProductsProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;

import java.util.concurrent.TimeUnit;

public class TestProductPrices extends BaseClass {


    //Proyecto Alvaro Espinoza TESTCASE 04
    @Test(dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsProvider.class)
    public void Test_Prices_Different_Currencies(Products testProductPrices){
        //SETUP
        homePage().EnterProduct(testProductPrices.getProductName());
        double expectedDollarPrice = testProductPrices.getDolarsPrice();
        double expectedPoundPrice = testProductPrices.getPoundsPrice();
        double expectedEuroPrice = testProductPrices.getEuroPrice();

        //RUN

        headerPage().ClickOnCurrencyOptions();
        headerPage().ClickOnUSDCurrencyOption();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        double actualDollarPrice = Utils.extraePrecios(searchResultsPage().getItemPriceAmount());
        Assert.assertEquals(actualDollarPrice, expectedDollarPrice);

        headerPage().ClickOnCurrencyOptions();
        headerPage().ClickOnEURCurrencyOption();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        double actualEuroPrice = Utils.extraePrecios(searchResultsPage().getItemPriceAmount());
        Assert.assertEquals(actualEuroPrice, expectedEuroPrice);

        headerPage().ClickOnCurrencyOptions();
        headerPage().ClickOnGBPCurrencyOption();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        double actualPoundPrice = Utils.extraePrecios(searchResultsPage().getItemPriceAmount());
        Assert.assertEquals(actualPoundPrice, expectedPoundPrice);

    }
}
