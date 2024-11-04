package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	
	// Data provider 1
	
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException
	{
		String path = "C:\\Users\\LENOVO\\eclipse-workspace\\ProjectHybridFramework\\testData\\LoginData.xlsx";                      // Taking xcel from testdata
		
		ExcelUtility xlutil = new ExcelUtility(path);                 // create object of exutility
		
		int totalrows = xlutil.getRowCount("Sheet1");   
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String logindata [][] = new String [totalrows][totalcols];    // 2d array to store row and col
		
		for(int i=1; i<=totalrows;i++)          //1                      //  Read data in excel 2d array
		{
			for(int j=0;j<totalcols; j++)  //0         i is row and j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);   // 1,0
			}
		}
		
		return logindata ;      // returning 2d array
	}

}
