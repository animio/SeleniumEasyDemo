package pageObjects;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDropdownListPage {
	
	public WebDriver driver;

	By SLDddownBar = By.xpath("//select[@id='select-demo']");
	By SLDdaySelected = By.xpath("//p[@class='selected-value']");
	By SLDallSelectOptions = By.xpath("//select[@class='form-control']//option");
	
	
	public SelectDropdownListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement SLDddownBar() {
		return driver.findElement(SLDddownBar);
	}
	
	public WebElement SLDdaySelected() {
		return driver.findElement(SLDdaySelected);
	}
	
	public ArrayList<WebElement> SLDallSelectOptions() {
		return  (ArrayList<WebElement>) driver.findElements(SLDallSelectOptions);
	}
}
