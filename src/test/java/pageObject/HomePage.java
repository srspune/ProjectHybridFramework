package pageObject;
                                                                                                         // Class No 2
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	// 1 -------------------------------------        declare webdriver and constructer       
	
	
	
	public HomePage (WebDriver driver)
	{
		super(driver);
	}
	
	
	//2 ------------------------------------         @ FindBy locate elemnt and store in variable
	
	@FindBy (xpath = "//span[@class=\"caret\"]")        WebElement LnkMyaccount ; 
	
	@FindBy (xpath = "//a[text()='Register']")                  WebElement lnkRegister ; 
	
	@FindBy (xpath = "//a[text()='Login']")                  WebElement lnkLogin ; 
	
	
	/// 3--------------------- Create seperate method and perform action
	
	public void clickMyAccount()
	{
		LnkMyaccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	

}
