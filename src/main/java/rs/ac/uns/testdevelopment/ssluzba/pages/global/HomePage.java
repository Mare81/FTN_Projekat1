package rs.ac.uns.testdevelopment.ssluzba.pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// poruka o uspesnom logovanju
	public String getLoginConfirmationText() {
		return Utils.waitForElementPresence(driver, By.xpath("//div [@translate=\"main.logged.message\"]"), 10)
				.getText();
	}

}
