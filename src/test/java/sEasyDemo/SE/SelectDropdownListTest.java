package sEasyDemo.SE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.SelectDropdownListPage;
import pageObjects.landingPage;

public class SelectDropdownListTest extends Base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	@Test
	public void selectListDemo() {
		
		landingPage LP = new landingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.visibilityOf(LP.popupX()));
		LP.popupX().click();
		}
		catch(NoSuchElementException e) {
		}
		LP.inputFormsLink().click();
		LP.inputFormsSDL().click();
		SelectDropdownListPage SDL = new SelectDropdownListPage(driver);
		
		//Code for first part Select List Demo
		

		ArrayList <WebElement> ddownitems = SDL.SLDallSelectOptions();
		ddownitems.remove(0);
		for(WebElement item : ddownitems) {
			item.click();
			try {
			Assert.assertTrue(SDL.SLDdaySelected().getText().contains(item.getText()));
			}
			catch(Exception e) {
				log.info("The right day is not selected");
			}
		}
		Select ddown = new Select(SDL.SLDddownBar());
		ddown.selectByIndex(2);
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
