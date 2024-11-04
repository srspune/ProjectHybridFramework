package pageObject;
                                                                                                                                  // Class No 1 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage
{
	public WebDriver driver;
	
	public BasePage  (WebDriver driver)
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}

}

// This base page is extended in every class 
// this base clas is parent class of every class
// becouse driver in initialize here
// every time we create contruter so one class is created