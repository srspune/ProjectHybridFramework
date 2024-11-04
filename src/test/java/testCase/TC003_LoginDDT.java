package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;




public class TC003_LoginDDT extends BaseClass
{                                              // dataProvider class imported from diff class
	
	@Test (dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")  
	public void verify_LoginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		
		logger.info("************** Starting TC003 - LOGIN DDT--****************");
		
		try {
		// HomePage
			
			HomePage hp = new HomePage(driver);
			Thread.sleep(2000);
			hp.clickMyAccount();
			Thread.sleep(2000);
			hp.clickLogin();
			Thread.sleep(2000);
				// LoginPage
				LoginPage lp = new LoginPage(driver);
				lp.setEmail(email);
				Thread.sleep(2000);
				lp.setPassword(pwd);
				Thread.sleep(2000);
				lp.clickLogin();
				Thread.sleep(2000);
				
				// MyAccountPage
				
				MyAccountPage mp = new MyAccountPage (driver);
				boolean targetPage = mp.isMyAccountPageExists();
				
				// Validation
				
				// DATA VALID- login successful -- TC pass---logout
				// DATA VALID- Login unscuuessful - test fail

				
				if    (exp.equalsIgnoreCase("Valid"))
				{
					if(targetPage==true)
					{
						Assert.assertTrue(true);
						mp.clickLogout();
					}
					
					else
					{
						Assert.assertTrue(false);
					}
					
				}
				
				// INVALID DATA  -  login successful -- TC fail---logout
				//INVALID DATA     Login unscuuessful     TC Pass
				
				if (exp.equalsIgnoreCase("Invalid"))
				{
					if (targetPage==true)
					{
						mp.clickLogout();
						Assert.assertTrue(false);
					}
					
					else
					{
						Assert.assertTrue(true);
					}
				}
		}
		catch (Exception e)
		{
			Assert.fail();
		}
				logger.info("************** Finished TC003 - LOGIN DDT--****************");
				
						
	}

}
