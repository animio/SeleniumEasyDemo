package sEasyDemo.SE;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CheckBoxDemoPage;
import pageObjects.landingPage;

public class CheckBoxDemoTest extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		driver.get(url);

	}
	
	
	@Test
	public void clickCheckboxes() throws Exception {

		landingPage LP = new landingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(LP.popupX()));
		try {
		LP.popupX().click();
		}
		catch(Exception e){
		}
		LP.inputFormsLink().click();
		LP.inputFormsCD().click();
		CheckBoxDemoPage CBDP = new CheckBoxDemoPage(driver);
		WebElement singleCheckbox = CBDP.SCD_checkbox();
		singleCheckbox.click();
		Assert.assertTrue(singleCheckbox.isSelected());
		log.info("Single checkbox is selected");
		try {
		WebElement textInfo = CBDP.SCD_textinfo();
		wait.until(ExpectedConditions.visibilityOf(textInfo));
		Assert.assertTrue(textInfo.isDisplayed());
		log.info("Message is displayed");
		Assert.assertEquals(textInfo.getText(), "Success - Check box is checkedl");
		}
		catch(Exception e) {
			log.info("Message is not shown");
		}
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	

	
}
