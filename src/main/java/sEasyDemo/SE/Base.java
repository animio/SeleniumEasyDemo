package sEasyDemo.SE;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public WebDriver driver;
	Properties prop;
	
	
	
	public WebDriver initializeDriver() throws IOException{
		
		prop = new Properties();
		String directory = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(directory + "/src/main/java/sEasyDemo/SE/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Anita Miovska/Selenium/Drivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:/Users/Anita Miovska/Selenium/Drivers/edgedriver_win64/msedgedriver.exe");
			driver = new EdgeDriver();
		}	
		
		return driver;
		
	}

	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}




}
