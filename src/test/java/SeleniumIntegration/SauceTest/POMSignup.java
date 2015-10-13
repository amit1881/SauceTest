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

//Non-TestNG Project

public class POMSignup{
	
	
	private static WebDriver driver = null;
	private static String sessionId=null;
	
	public static void main(String[] args) throws MalformedURLException  {
		
		DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "41");
        caps.setCapability("name", "Web Driver demo Test");
        caps.setCapability("tags", "Tag1");
        caps.setCapability("build", "v1.0");
        WebDriver driver = new RemoteWebDriver(
                new URL("http://abhinav1881:0a0848e0-5d68-46bd-a9e2-8b23ad5baa57@ondemand.saucelabs.com:80/wd/hub"),
                caps);
       
        sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
        System.out.println("Session Id="+ sessionId);
	     
	      driver = new FirefoxDriver();
	      
	      
	      
	      //implicit wait
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://socialsofttesthb.com/sign-up");
	      driver.manage().window().maximize();
	      
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
	      driver.close();
	      
	 
	      
	      
	     
	      
	      
	}
	
}

