package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;

public class Checkout {

	
	 WebDriver driver;
	 HomePage hp;
     LoginPage lp;
     SearchPage sp;
     ShoppingCartPage sc;
     MyAccountPage macc;
     public Checkout() {
    	 this.driver = Hooks.driver;     // ✅ driver Hooks se aa raha hai
         this.hp = new HomePage(driver);
         this.sp = new SearchPage(driver);
         this.sc=new ShoppingCartPage(driver);
         
     }


@Given("search a product {string}")
public void search_a_product(String productName) {
		hp.enterProductName(productName);
	   hp.clickSearch();
	   hp.clickSearch();
	}


	@When("the user selects a product")
	public void the_user_selects_a_product() {
	   sp.addToCart();
	}
	
	@When("click add to cart")
	public void click_add_to_cart() {
		sp.clickaddtocart();
	}

	@When("adds the product to the cart")
	public void adds_the_product_to_the_cart() throws InterruptedException {
		Thread.sleep(2000);
	   sp.checkConfMsg();
	}

	@When("clicks on the Shopping Cart button")
	public void clicks_on_the_shopping_cart_button() throws InterruptedException {
		Thread.sleep(2000);
	    sc.clickViewCart();
	}
	@When("validate Shopping Cart text is visible")
	public void validate_shopping_cart_text_is_visible() {
		sc.validatesopingtext();
	}
	
	

	@When("fetch the total amount")
	public void fetch_the_total_amount() {
	    String price = sc.getTotalAmount();
	    System.out.println("Total Amount: " + price);
	}

	@When("clicks on checkout")
	public void clicks_on_checkout() {
	    sc.clickOnCheckout();
	}

	


	@Then("validate checkout text is visible")
	public void validate_checkout_text_is_visible() throws InterruptedException {
	    sc.validatecheckouttext();
	}
	@Then("click Guest Checkout")
	public void click_guest_checkout() {
	    sc.clickasguiest();
	    sc.clickaccountcontinuebutton();
	}

	@Then("fill Billing Details")
	public void fill_billing_details() {
	   sc.Enterfirstname("test");
	   sc.enterlastname("qa");
	   sc.enteremail("testqa@gmail.com");
	   sc.enterphonenumber("24423434");
	   sc.enteradrees("A35 NOIDA SECTOR 2");
	   sc.entercity("NOIDA");
	   sc.enterpincode("23525");
	   sc.selectcountry();
	   sc.selectcity();
	   sc.clickguiestcountinue();
	  
	}
}
