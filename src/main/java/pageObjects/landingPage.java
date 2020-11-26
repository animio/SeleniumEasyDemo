package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	
	By inputFormsLink = By.xpath("//li[@class='tree-branch'][i]/a[contains(text(), 'Input Forms')]");
	By inputFormsSFD = By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(), 'Simple Form Demo')]");
	By popupX = By.xpath("//a[@id='at-cv-lightbox-close']");
	By inputFormsCD = By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(), 'Checkbox Demo')]");
	


	public landingPage(WebDriver driver) {
		this.driver=driver;
	}




	public WebElement popupX() {
		return driver.findElement(popupX);
	}

	
	public WebElement inputFormsLink() {
		
		return driver.findElement(inputFormsLink);
	}
	
	public WebElement inputFormsSFD() {
		
		return driver.findElement(inputFormsSFD);
	}
	
	public WebElement inputFormsCD() {
		
		return driver.findElement(inputFormsCD);
	}
	

}
