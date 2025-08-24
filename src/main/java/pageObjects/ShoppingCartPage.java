package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage
	{
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//button[@aria-expanded='false']")
	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
	WebElement lblTotalPrice;  //$246.40
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement spoingcarttext;
	
	// xpath for the second <td> containing price
	@FindBy(xpath = "//td[strong[text()='Total:']]/following-sibling::td")
	WebElement totalAmount;
	
	@FindBy(xpath="//h1[text()='Checkout']")
	WebElement checkouttext;
	
	@FindBy(xpath="//input[@value='guest']")
	WebElement checkboxguest;
	
	@FindBy(id="button-account")
	WebElement accountcontinuebutton;
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="telephone")
	WebElement	telephone;
	
	@FindBy(name="address_1")
	WebElement adrres;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="postcode")
	WebElement 	pincode;
	
	@FindBy(name="country_id")
	WebElement zonecountry;
	
	@FindBy(name="zone_id")
	WebElement 	zonecity;
	
	
	@FindBy(id="button-guest")
	WebElement continueguiestbutton;
	
	
	public void clickasguiest() {
		checkboxguest.click();
	}
	public void clickaccountcontinuebutton() {
		accountcontinuebutton.click();
	}
	public void Enterfirstname(String Fname) {
		firstname.sendKeys(Fname);
	}
	public void enterlastname(String Lname) {
		lastname.sendKeys(Lname);
	}
	
	public void enteremail(String Email) {
		email.sendKeys(Email);
	}
 public void enterphonenumber(String phonenumber) {
	 telephone.sendKeys(phonenumber);
 }
 
 public void enteradrees(String Adress) {
	 adrres.sendKeys(Adress);
 }
 public void entercity(String Cityname) {
	 city.sendKeys(Cityname);
 }
 
 public void enterpincode(String pincodenum) {
	 pincode.sendKeys(pincodenum);
 }
 
 public void selectcountry() {
	 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	// Wait until dropdown is enabled
	    wait.until(ExpectedConditions.elementToBeClickable(zonecountry));

	    Select country = new Select(zonecountry);
	    country.selectByVisibleText("India");
	 
 }
 
 public void selectcity() {
	 Select dropdown = new Select(zonecity);
	 dropdown.selectByVisibleText("Bihar");
	 
	 
 }
 public void clickguiestcountinue() {
	 continueguiestbutton.click();
 }
	public String getTotalAmount() {
	    return totalAmount.getText();   // returns "$134.00"
	}

	public boolean validatesopingtext() {
		spoingcarttext.isDisplayed();
		System.out.println(spoingcarttext.getText());
		return true;
		
	}
	public String validatecheckouttext() throws InterruptedException {
		Thread.sleep(2000);
		String sucessmessage = checkouttext.getText();
		System.out.println("checkouttext.getText()");
		return sucessmessage;
		
		
	}
	public void clickItemsToNavigateToCart()
	{
		btnItems.click();
	}
	
	public void clickViewCart()
	{
		lnkViewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public void clickOnCheckout()
	{
		btnCheckout.click();
	}
}
