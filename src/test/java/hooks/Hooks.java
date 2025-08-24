package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    public static  WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    			
	}
		
    
    @After
    public void tearDown() {
        		
       driver.quit();
       
    }
    

    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	
        	byte[] screenshotfaild=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshotfaild, "image/png",scenario.getName());
        }
        	else {

        		byte[] screenshotpass=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshotpass, "image/png",scenario.getName());
        	}
      
    }
   
}
