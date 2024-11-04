package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002_LoginTest extends BaseClass
{
	@Test (groups = {"Sanity", "Master"})
	public void verify_login() throws InterruptedException
	{
		logger.info("------------------ Starting TC_002_LoginTest--------------------");
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(2000);
		hp.clickLogin();
		
		// LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		Thread.sleep(2000);
		lp.setPassword(p.getProperty("password"));
		Thread.sleep(2000);
		lp.clickLogin();
		Thread.sleep(2000);
		
		// MyAccountPage
		
		MyAccountPage mp = new MyAccountPage (driver);
		boolean targetPage = mp.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		
		
		logger.info("*************Finished*****************");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		

		
		logger.info("***************Finished TC_002_LoginTest*************************");
		
	}

}
