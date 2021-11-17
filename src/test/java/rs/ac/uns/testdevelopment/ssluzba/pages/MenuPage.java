package rs.ac.uns.testdevelopment.ssluzba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getAccountMenu(){
		return driver.findElement(By.id("account-menu"));
	}
	
	public WebElement getSignUp(){
		return  driver.findElement(By.xpath("//a [@ui-sref=\"login\"]"));
	}
	
	public WebElement getLogOut(){
		return driver.findElement(By.id("logout"));
	}

}
