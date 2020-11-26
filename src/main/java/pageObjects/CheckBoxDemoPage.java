package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxDemoPage {
	
	public WebDriver driver;
	By SCD_checkbox = By.xpath("//input[@id='isAgeSelected']");
	By SCD_textinfo = By.xpath("//div[@id='txtAge']");
	By MCD_option1 = By.xpath("//div[@class='checkbox']/label[text()='Option 1']");
	By MCD_option2 = By.xpath("//div[@class='checkbox']/label[text()='Option 2']");
	By MCD_option3 = By.xpath("//div[@class='checkbox']/label[text()='Option 3']");
	By MCD_option4 = By.xpath("//div[@class='checkbox']/label[text()='Option 4']");
	By MCD_checkAllBtn = By.xpath("//input[@id='check1']");
	


	public CheckBoxDemoPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement SCD_checkbox() {
		return driver.findElement(SCD_checkbox);
	}
	
	public WebElement SCD_textinfo() {
		return driver.findElement(SCD_textinfo);
	}
	
	public WebElement MCD_option1() {
		return driver.findElement(MCD_option1);
	}
	
	public WebElement MCD_option2() {
		return driver.findElement(MCD_option2);
	}
	
	public WebElement MCD_option3() {
		return driver.findElement(MCD_option3);
	}
	
	public WebElement MCD_option4() {
		return driver.findElement(MCD_option4);
	}
	
	public WebElement MCD_checkAllBtn() {
		return driver.findElement(MCD_checkAllBtn);
	}

}
