package sEasyDemo.SE;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.singleInputFormPage;



public class singleInputFieldPageTest extends Base{
	
	@Test
	public void getPage() throws IOException {
		driver = initializeDriver();
		landingPage LP = new landingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(LP.popupX()));
		try {
		LP.popupX().click();
		}
		catch(Exception e){
		}
		LP.inputFormsLink().click();
		LP.inputFormsSFD().click();
		singleInputFormPage SIFP = new singleInputFormPage(driver);
		SIFP.SIFenterMessageBox().sendKeys("Hello world");
		SIFP.SIFshowMessageBtn().click();
		String textInput = SIFP.SIFyourMessageText().getText();
		Assert.assertEquals(textInput, "Hello world");
		
	}

}
