package SeleniumIntegration.SauceTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class POMSignup {
  
	private static WebDriver driver = null;
	//private static String sessionId=null;
	public String sessionId;
	
	//@Parameters("browser")
	@BeforeTest
	   public void launchapp() throws MalformedURLException
	   {
		//if (browser.equalsIgnoreCase("firefox"))
	      //{
	         System.out.println(" Executing on FireFox");
	       
		POMSignup ob=new POMSignup();
	     ob.printSessionId();
	     //driver = new FirefoxDriver();
	      
	      //implicit wait
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://socialsofttesthb.com/sign-up");
	      driver.manage().window().maximize();
	      
	      //}
	   }
    
	@Test
	public void Signup() throws MalformedURLException{
		/*
		DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "41");
        caps.setCapability("name", "Web Driver demo Test");
        caps.setCapability("tags", "Tag1");
        caps.setCapability("build", "v1.0");
        driver = new RemoteWebDriver(
                new URL("http://amit1881:c33b1e5d-0656-41e9-87f0-5c16dc26e576@ondemand.saucelabs.com:80/wd/hub"),
                caps);
       */
        //sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
        //System.out.println("Session Id="+ sessionId);
	    
	      
	    //Use page Object library now
	      
	    //Enter first name
	      TestHelper.firstName(driver).clear();
	      TestHelper.firstName(driver).sendKeys("amit");
	    //Enter second name
	      TestHelper.lastName(driver).clear();
	      TestHelper.lastName(driver).sendKeys("singh");
	    //Enter email address
	      TestHelper.emailAddress(driver).clear();
	      TestHelper.emailAddress(driver).sendKeys("amit1234567@ravabe.com");
	    //Select Time Zone
	      TestHelper.selectTimeZone(driver);
	    //Enter password
	      TestHelper.password(driver).clear();
	      TestHelper.password(driver).sendKeys("Amit1234");
	    //accept terms and conditions 
	      TestHelper.acceptTerms(driver).click();
	    //Click on signup button
	      TestHelper.signup(driver).click();
	      
	     
	    //Explicit wait
	      WebDriverWait wait=new WebDriverWait(driver,10);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='toast-container']/div/div")));
	      //driver.close();
	      
	 
	      
	      
	     
	      
	      
	}
	
	    private void printSessionId() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "41");
        caps.setCapability("name", "Sauce Demo");
        caps.setCapability("tags", "Tag1");
        caps.setCapability("build", "v1.0");
        driver = new RemoteWebDriver(
                new URL("http://amit1881:c33b1e5d-0656-41e9-87f0-5c16dc26e576@ondemand.saucelabs.com:80/wd/hub"),
                caps);
        sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
	    String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sessionId, "POMSignup");
	    System.out.println(message);
	}
	    @AfterTest
	    public void terminatetest()
	    {
	       driver.close();
	    }

    

}
