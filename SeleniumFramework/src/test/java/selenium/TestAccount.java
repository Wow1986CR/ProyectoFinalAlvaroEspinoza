package selenium;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.Utils;
import dataProviders.ExistingUsersProvider;
import dataProviders.SearchProvider;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pojo.ExistingUserAccount;
import pojo.UserAccount;

public class TestAccount extends BaseClass {
    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: no match for e-mail address and/or password.";

    //elements
    public By logOutButtonLocator = By.linkText("Logout");
    public By alertMessageLocator = By.xpath("//div[contains(@class, 'alert-danger')]");

    @Description("Validate test login was successful")
    @Test(description = "Test Login Success")
    public void Test_Login_Successful(){
        String username = "alvaro01@correo.com";
        String password = "a147";

        //Go To Login Page
        headerPage().clickOnMyAccount();
        headerPage().clickOnLoginButton();

        /*
        EJEMPLO DE LISTAS Y WEBELEMENTS SOLOS
        WebElement WishList = driver.findElement(By.linkText("Wish List"));
        ArrayList<> WishListList = driver.findElements(By.linkText("Wish List"));
        */

        //Llenar formulario
        loginPage().EnterEmail(username);
        loginPage().EnterPassword(password);
        loginPage().ClickSubmitButton();

        WebElement logOutButton = driver.findElement(logOutButtonLocator);
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Description("Validate that the login is working with non valid credentials")
    @Test(description = "Test Login Not Success")
    public void Test_Login_Unsuccessful(){
        String username = "alvaro01@correo.com";
        String password = "asdfasdf";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage().GoTo();
        loginPage().login(username, password);

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
    }

    @Test (dataProvider = "getUsersData", dataProviderClass = UsersProvider.class)
    public void Test_Login_With_Data(UserAccount testUser){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.GoTo();
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        if(testUser.isValidAccount())
            Assert.assertTrue(driver.findElement(logOutButtonLocator).isDisplayed());
        else
            Assert.assertEquals(ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE.toLowerCase(), driver.findElement(alertMessageLocator).getText().toLowerCase().trim());
    }

    //Proyecto Alvaro Espinoza TESTCASE 01
    @Test
    public void Test_Create_New_Account(){
        //SETUP
        String firstName = "Alvaro";
        String lastName = "Espinoza";
        String email = Utils.generateRandomEmail();
        String telephone = "22228888";
        String password = "a147";
        String expectedMessage = "Your Account Has Been Created!";

        //RUN
        registerPage().GoTo();
        registerPage().FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage().GetConfirmationMessage(), expectedMessage);
    }


    //Proyecto Alvaro Espinoza TESTCASE 02
    @Test (dataProvider = "getExistingUsersDataFromJson", dataProviderClass = ExistingUsersProvider.class)
    public void Test_Duplicated_Email(ExistingUserAccount testUser){
        //SETUP
        String firstName = "Alvaro";
        String lastName = "Espinoza";
        String telephone = "123456";
        String password = "claveAAA";
        String expectedMessage = "Warning: E-Mail Address is already registered!";

        //RUN
        registerPage().GoTo();
        registerPage().FillForm(firstName, lastName, testUser.getUserEmail(), telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage().GetRejectionMessage(), expectedMessage);
    }




    /**
     * Open browser
     * Navigate to ...
     * Click to sign in page -> clickOnSignInPageButton()
     * Fill the form  -> fillTheForm(username, password)
     * Click submit -> clickOnSubmitButton()
     * */



}
