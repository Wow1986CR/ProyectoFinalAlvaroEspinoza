package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private static final String ERROR_MESSAGE_NO_RESULTS_DISPLAYED = "There is no product that matches the search criteria.";

    //elementos
    private By resultsSelector = By.cssSelector(".product-thumb");
    private By itemName = By.xpath("//div[@class='product-thumb']//h4/a");
    private By noResultsSelector = By.id("content");
    private By itemPrice = By.xpath("//p[@class='price']");


    public SearchResultsPage(WebDriver driver){
        super(driver);
    }
    public int getResultsCount(){
        return driver.findElements(resultsSelector).size();
    }
    public boolean isNoResultsVisible(){
        return driver.findElement(noResultsSelector).getAttribute("innerHTML").contains(ERROR_MESSAGE_NO_RESULTS_DISPLAYED);
    }

    public void ClickOnProductLink(){
        this.driver.findElement(itemName).click();
    }

    public String getItemPriceAmount(){
        return driver.findElement(itemPrice).getText();
    }


}
