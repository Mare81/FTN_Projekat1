package rs.ac.uns.testdevelopment.ssluzba.pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return Utils.waitForElementPresence(driver, By.id("username"), 10);
	}

	public void setUsername(String username) {
		WebElement usernameInput = getUsername();
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	public WebElement getPassword() {
		return Utils.waitForElementPresence(driver, By.id("password"), 10);
	}

	public WebElement getSignInBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@translate='login.form.button']"), 10);
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
