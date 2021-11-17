package rs.ac.uns.testdevelopment.ssluzba;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	private WebDriver browser;
	
	@BeforeMethod
	public void setupSelenium() {
		//instanciranje browsera
		browser = new FirefoxDriver();
		//implicitno vreme cekanja za pronalazenje elemenata
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximizuje prozor
		browser.manage().window().maximize();
		//navigacija na zeljenu stranicu
		browser.navigate().to("localhost:9000/#/");
	}
	
	@Test
	public void login() throws InterruptedException {
		//click to account menu 
		WebElement accountMenu = browser.findElement(By.id("account-menu"));
		accountMenu.click();
		WebElement signIn = accountMenu.findElement(By.xpath("//a [@ui-sref=\"login\"]"));
		assertEquals(true, signIn.isDisplayed());
		
		signIn.click(); //go to login page
		assertEquals("http://localhost:9000/#/login", browser.getCurrentUrl());
		WebElement username = browser.findElement(By.id("username"));
		WebElement password = browser.findElement(By.id("password"));
		WebElement btnSignIn = browser.findElement(By.xpath("//button[@translate='login.form.button']"));
		
		//check elements visibility
		assertEquals(username.isDisplayed(), true);
		assertEquals(password.isDisplayed(), true);
		assertEquals(btnSignIn.isDisplayed(), true);
		
		//set username value
		username.clear(); //delete current value
		username.sendKeys("admin"); //send new value
		
		//set password value
		password.clear();
		password.sendKeys("admin");
		
		//click signin button
		btnSignIn.click();
		
		//get login message
		String message = browser.findElement(By.xpath("//div [@translate=\"main.logged.message\"]")).getText();	
		String expectedMessage = "You are logged in as user \"admin\".";
		//check login message
		assertEquals(expectedMessage, message);
		
	}
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		browser.quit();
	}
	
	
}
