package rs.ac.uns.testdevelopment.ssluzba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginConfirmationText(){
		return driver.findElement(By.xpath("//div [@translate=\"main.logged.message\"]")).getText();	
	}
	
}
