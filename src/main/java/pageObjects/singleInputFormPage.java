package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class singleInputFormPage {

	
	public WebDriver driver;
	
	By SIFenterMessageBox = By.xpath("//input[@id='user-message']");
	By SIFshowMessageBtn = By.xpath("//button[@type='button' and contains(text(), 'Show Message')]");
	By SIFyourMessageText = By.xpath("//span[@id='display']");
	By TIFenterValueA = By.xpath("//input[@id='sum1']");
	By TIFenterValueB = By.xpath("//input[@id='sum2']");
	By TIFgetTotalBtn = By.xpath("//button[@type='button' and contains(text(), 'Get Total')]");
	By TIFtotalAB = By.xpath("//span[@id='displayvalue']");
	
	public singleInputFormPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement SIFenterMessageBox() {
		return driver.findElement(SIFenterMessageBox);		
	}
	
	public WebElement SIFshowMessageBtn() {
		return driver.findElement(SIFshowMessageBtn);		
	}
	
	public WebElement SIFyourMessageText() {
		return driver.findElement(SIFyourMessageText);		
	}
	
	public WebElement TIFenterValueA() {
		return driver.findElement(TIFenterValueA);		
	}
	
	public WebElement TIFenterValueB() {
		return driver.findElement(TIFenterValueB);		
	}
	
	public WebElement TIFgetTotalBtn() {
		return driver.findElement(TIFgetTotalBtn);		
	}
	
	public WebElement TIFtotalAB() {
		return driver.findElement(TIFtotalAB);		
	}

}
