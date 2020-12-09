package sEasyDemo.SE;

import java.io.IOException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.SingleInputFormPage;
import pageObjects.landingPage;



public class singleInputFieldPageTest extends Base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);

		
	}
	
	
	@Test(dataProvider="data")
	public void getPage(String text) throws Exception {
		landingPage LP = new landingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.visibilityOf(LP.popupX()));
		LP.popupX().click();
		}
		catch(Exception e){
		}
		LP.inputFormsLink().click();
		LP.inputFormsSFD().click();
		SingleInputFormPage SIFP = new SingleInputFormPage(driver);
		SIFP.SIFenterMessageBox().sendKeys(text);
		log.info("Text is entered in the text box");
		SIFP.SIFshowMessageBtn().click();
		log.info("Show message button is clicked");
		Assert.assertEquals(SIFP.SIFyourMessageText().getText(), text);
		log.info("Assertion passed, text entered and text displayed are identical");
		int n = num();
		SIFP.TIFenterValueA().sendKeys(Integer.toString(n));
		int n1 = num();
		SIFP.TIFenterValueB().sendKeys(Integer.toString(n1));
		SIFP.TIFgetTotalBtn().click();
		int sumAB = n + n1;
		Assert.assertEquals(SIFP.TIFtotalAB().getText(), Integer.toString(sumAB));
	
	}

	
	private int num() {
		Random number = new Random();
		int n = number.nextInt(50);
		return n;
		
	}


	@DataProvider 
	public Object[][] data() {
		Object[][] data = new Object[1][1];
		data[0][0] = "Hello world!";
		return data;
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	


}
