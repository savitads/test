package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Lib implements IAutoConstant {
	public static Workbook wb;
	public static String getPropertyValue(String key)
	{
		String propertyValue= "";
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(CONFIGFILE_PATH));
		    propertyValue = prop.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} 
		System.out.println("Property value is "+propertyValue);
		return propertyValue;
	}
	
	public static String getCellValue(String sheetName, int rowNum, int colNum )
	{
		String cellValue = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} 
		//System.out.println("cell value is "+cellValue);
		return cellValue;
	}
	
	public static int getRowCount(String sheetName)
	{
		int rowCount = 0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			 rowCount = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} 
		System.out.println("Active row count is "+rowCount);
		return rowCount;
	}
	
	public static void captureScreenshot(WebDriver driver, String methodName)
	{
		//Need to add test method name
		try {
		Date date = new Date();
		String currentDate = date.toString().replaceAll(":", "_");
		//System.out.println(currentDate +" current Date");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcSnapshot = ts.getScreenshotAs(OutputType.FILE);
		File desSnapshot = new File(SCREENSHOT_PATH + methodName+"_"+currentDate +"_"+".png");
			FileUtils.copyFile(srcSnapshot, desSnapshot);
			System.out.println("Screen Shot captured");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

}
















