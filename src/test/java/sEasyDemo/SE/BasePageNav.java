package sEasyDemo.SE;

import java.io.IOException;

import org.testng.annotations.Test;



public class BasePageNav extends Base{
	
	@Test
	public void getPage() throws IOException {
		driver = initializeDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	}
	
	

}
