package stepDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import utilities.DataReader;

public class LoginTdd {

    WebDriver driver;
    HomePage hp;
    LoginPage lp;
    SearchPage sp;
    ShoppingCartPage sc;
    MyAccountPage macc;
    List<HashMap<String, String>> datamap; // Data driven

    public LoginTdd() {
        this.driver = Hooks.driver;     // ✅ driver Hooks se aa raha hai
        this.hp = new HomePage(driver);
        this.sp = new SearchPage(driver);
        this.sc = new ShoppingCartPage(driver);
    }

    // ---------------- GHERKIN STEPS -------------------

    @Given("the user is on the nopCommerce login page")
    public void the_user_is_on_the_nop_commerce_login_page() {
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        lp = new LoginPage(driver);
    }

    @When("the user enters credentials from excel row {string}")
    public void the_user_enters_credentials_from_excel_row(String rows) {
        try {
        	datamap = DataReader.data(
        		    System.getProperty("user.dir") + "/src/test/resources/TestData/Opencart_LoginData.xlsx", 
        		    "Sheet1"
        		);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = Integer.parseInt(rows) - 1;
        String email = datamap.get(index).get("username");
        String pwd = datamap.get(index).get("password");

        lp.setEmail(email);
        lp.setPassword(pwd);
    }

    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) {
        int index = Integer.parseInt(rows) - 1;
        String exp_res = datamap.get(index).get("res");

        lp.clickLogin();
        macc = new MyAccountPage(BaseClass.getDriver());

        try {
            boolean targetpage = macc.isMyAccountPageExists();
            System.out.println("target page: " + targetpage);

            if (exp_res.equalsIgnoreCase("Valid")) {
                if (targetpage) {
                    macc.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp_res.equalsIgnoreCase("Invalid")) {
                if (targetpage) {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}
