package testCase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.HomePage;
import pageObject.RegisterPage;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	
	@Test (groups = {"Regression", "Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("**********Starting Verify account ************");
		
		try
		{
		HomePage hm = new HomePage(driver);                           // HomePage
		hm.clickMyAccount();
		logger.info("**********Click on MyAccount************");
		Thread.sleep(2000);
		hm.clickRegister();
		logger.info("**********Click on Register************");
		Thread.sleep(2000);
		
		RegisterPage rp = new RegisterPage(driver);              //  Register Page
		
		logger.info("**********providing details************");
		rp.setfirstName(randomString());
		Thread.sleep(2000);
		rp.setlastName(randomString());
		Thread.sleep(2000);
		rp.setEmail ( randomMail());
		Thread.sleep(2000);
		rp.setTelephone(randomNumber());
		Thread.sleep(2000);
		rp.setPassword("858585@858585");
		Thread.sleep(2000);
		rp.setConfPass("858585@858585");
		Thread.sleep(2000);
		rp.setSub();
		Thread.sleep(2000);
		rp.setCont();
		Thread.sleep(2000);
		rp.Cont();
		Thread.sleep(2000);
		
		logger.info("**********Validating message************");
		String congMsg =   rp.getConfirmationMsg();                      // Validation
		
		Assert.assertEquals(congMsg, "Your Account Has Been Created!");
		Thread.sleep(2000);
		}
		
		
		catch (Exception e)                                                    //Log4j2 code                              
		{
			logger.error("Test Failed");
		//	logger.debug("Debug logs------");
			Assert.fail();
		}
		
		logger.info("----------------------Test Finished--------------------");
	}

	
	
	

}
