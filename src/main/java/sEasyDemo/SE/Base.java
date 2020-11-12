package sEasyDemo.SE;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException{
		
		Properties prop = new Properties();
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
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		driver.get(url);
		
		
		
		return driver;
		
	}
	

}
