package sEasyDemo.SE;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.singleInputFormPage;



public class singleInputFieldPageTest extends Base {
	
	
	@Test(dataProvider="data")
	public void getPage(String text) throws Exception {
		LP = new landingPage(driver);
		LP.inputFormsLink().click();
		LP.inputFormsSFD().click();
		singleInputFormPage SIFP = new singleInputFormPage(driver);
		SIFP.SIFenterMessageBox().sendKeys(text);
		SIFP.SIFshowMessageBtn().click();
		Assert.assertEquals(SIFP.SIFyourMessageText().getText(), text);
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

}
