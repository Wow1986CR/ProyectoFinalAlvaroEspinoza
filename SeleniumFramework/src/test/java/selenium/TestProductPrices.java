package selenium;

import PageObjects.BaseClass;
import PageObjects.Utils;
import dataProviders.ProductsProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;

public class TestProductPrices extends BaseClass {


    //Proyecto Alvaro Espinoza TESTCASE 04
    @Test(dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsProvider.class)
    public void Test_Prices_Different_Currencies(Products testProductPrices){
        //SETUP
        double expectedDollarPrice = testProductPrices.getDolarsPrice();
        double expectedPoundPrice = testProductPrices.getPoundsPrice();
        double expectedEuroPrice = testProductPrices.getEuroPrice();

        //RUN
        //homePage().GoTo();
        homePage().EnterProduct(testProductPrices.getProductName());
        searchResultsPage().ClickOnCurrencyOptions();
        searchResultsPage().ClickOnUSDCurrencyOption();
        double actualDollarPrice = Utils.extraePrecios(searchResultsPage().getItemPriceAmount());
        Assert.assertEquals(actualDollarPrice, expectedDollarPrice);
        searchResultsPage().ClickOnEURCurrencyOption();
        double actualEuroPrice = Utils.extraePrecios(searchResultsPage().getItemPriceAmount());
        Assert.assertEquals(actualEuroPrice, expectedEuroPrice);
        searchResultsPage().ClickOnGBPCurrencyOption();
        double actualPoundPrice = Utils.extraePrecios(searchResultsPage().getItemPriceAmount());
        Assert.assertEquals(actualPoundPrice, expectedPoundPrice);

    }
}
