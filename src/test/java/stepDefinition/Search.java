package stepDefinition;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Search {
WebDriver driver;
	

	@Given("the user is on the nopCommerce  page")
	public void the_user_is_on_the_nop_commerce_page() {
		driver=new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	}
	@When("the user enters valid product name in the serch box   {string}")
	public void the_user_enters_valid_product_name_in_the_serch_box(String Mobile) {
		WebElement Searchbox = driver.findElement(By.name("q"));
		Searchbox.sendKeys(Mobile);
	}
	@When("the user clicks on the serch button")
	public void the_user_clicks_on_the_serch_button() {
		  driver.findElement(By.xpath("//button[text()='Search']")).click();
	}
	@Then("the user get same product")
	public void the_user_get_same_product() {
		 WebElement iphonetext = driver.findElement(By.xpath("//a[text()='Apple iPhone 16 128GB']"));
		 Assert.assertTrue(iphonetext.isDisplayed());
		 System.out.println(iphonetext.getText());
	}
	@Then("the user click add to cart")
	public void the_user_click_add_to_cart() throws InterruptedException {
		Thread.sleep(20000);
		 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	}
	@Then("verify message to cart added")
	public void verify_message_to_cart_added() {
		String expectedMessage = "The product has been added to your shopping cart";
		WebElement successMessageElement = driver.findElement(By.xpath("//p[text()='The product has been added to your ']"));
		String actualMessage = successMessageElement.getText();

		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Expected: " + expectedMessage + " | Found: " + actualMessage);

		System.out.println("✅ Cart add confirmation message verified successfully.");
		
		driver.quit();
	}
}
