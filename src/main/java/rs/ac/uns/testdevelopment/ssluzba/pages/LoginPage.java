package rs.ac.uns.testdevelopment.ssluzba.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage (WebDriver diver) {
		this.driver = driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(By.id("username"));
	}
	
	public void setUsername(String username) {
		WebElement usernameInput = getUsername();
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.id("username"));
	}
	
	public WebElement getSignInBtn() {
		return driver.findElement(By.xpath("//button[@translate='login.form.button']"));
	}
	
	public void setPassword(String password) {
		WebElement passwordInput = getPassword();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		getSignInBtn().click();
	}
	
}
