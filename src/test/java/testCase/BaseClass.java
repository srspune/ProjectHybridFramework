package testCase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


 
public class BaseClass                                                     // Parent of all methods 
{
public static WebDriver driver;
public Logger  logger;                                                                  // Log4j2      code 
public Properties p;
	
	@BeforeClass (groups = {"Sanity","Regression","Master","DataDriven"})
	@Parameters ({"os", "browser"})              //    ---- ParallelTesting-- refer xml file
	public void setup(String os, String br) throws InterruptedException, IOException
	{
		// loading config.properties file
		
		FileReader file = new FileReader (".//src/test/resources//config.properties");
		p = new Properties();
		p.load(file);
		
		  logger = LogManager.getLogger(this.getClass());                   // log4j2 code
		
		switch (br.toLowerCase())                                                             // parallel-cross browser testing
		{
		case "chrome" : driver = new ChromeDriver();  break;
		case "edge"      :  driver = new EdgeDriver();  break;
		case "firefox"      :  driver = new FirefoxDriver();  break;
		default : System.out.println(" Invalid Browser -   ");      return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));                                                     // Read url from property file
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@AfterClass  (groups = {"Sanity","Regression","Master","DataDriven"})
	public void tearDown()
	{
		driver.quit();
	}
	

	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return generatedString ; 
	}
	
	public String randomNumber()
	{
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
		
	}
	
	public String randomMail()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNum = RandomStringUtils.randomNumeric(5);
		return (generatedString + "@gmail.com" ); 
	}

	
	
	// Scrrenshot  in repoets
	
    /*public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver ; 
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        
		String targetFilePath = "C:\\Users\\LENOVO\\eclipse-workspace\\ProjectHybridFramework\\screenshots\\" 
                + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);
	/*    sourceFile.renameTo(targetFile);
	    return targetFilePath ;  
		
		try {
	        FileUtils.copyFile(sourceFile, targetFile); // Use FileUtils to copy the file
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return targetFilePath;
	}                                                    */
    
        public String captureScreen(String tname) {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver; 
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    // Correct path concatenation
	    String targetFilePath = "C:\\Users\\LENOVO\\eclipse-workspace\\ProjectHybridFramework\\screenshots\\" 
	                            + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    try {
	        FileUtils.copyFile(sourceFile, targetFile); // Use FileUtils to copy the file
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return targetFilePath;
	} 
	

}
