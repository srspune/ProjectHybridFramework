package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage 
{
	// 1 -------------------------------------        declare webdriver and constructer  
	
	
	
	public RegisterPage (WebDriver driver)
	{
		super(driver);
	}
	
	//2 ------------------------------------         @ FindBy locate elemnt and store in variable
	
	@FindBy (xpath = "//input[@name=\"firstname\"]")         WebElement firstName;
	@FindBy (xpath = "//input[@name=\"lastname\"]")          WebElement lastName;
	@FindBy (xpath = "//input[@name=\"email\"]")                 WebElement email ; 
	@FindBy (xpath = "//input[@name=\"telephone\"]")         WebElement telephone ; 
	@FindBy (xpath = "//input[@name=\"password\"]")          WebElement password;
	@FindBy (xpath = "//input[@name=\"confirm\"]")              WebElement confirmPassword ; 
	@FindBy (xpath = "(//input[@name=\"newsletter\"])[1]")  WebElement subscribeYes; 
	@FindBy (xpath = "//input[@name=\"agree\"]")                  WebElement continueYes ; 
	@FindBy (xpath = "//input[@value=\"Continue\"]")             WebElement Lcontinue;
	@FindBy (xpath = "//h1[text()=\"Your Account Has Been Created!\"]") WebElement successMsg ; 
	
	/// 3--------------------- Create seperate method and perform action
	
	public void setfirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	public void  setlastName (String lName)
	{
	   lastName.sendKeys(lName);	
	}
	public void setEmail( String lemail)
	{
		email.sendKeys(lemail);
	}
	public void setTelephone(String MyTel)
	{
		telephone.sendKeys(MyTel);
	}
	public void setPassword(String MyPass)
	{
		password.sendKeys(MyPass);
	}
	public void setConfPass(String MyPass)
	{
	    confirmPassword.sendKeys(MyPass);	
	}
	public void setSub ()
	{
		subscribeYes.click();
	}
	public void setCont()
	{
		continueYes.click();
	}
	public void Cont()
	{
		Lcontinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (successMsg.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 }
