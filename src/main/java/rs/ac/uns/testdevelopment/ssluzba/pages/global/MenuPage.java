package rs.ac.uns.testdevelopment.ssluzba.pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class MenuPage {
	private WebDriver driver;

	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getAccountMenu() {
		return Utils.waitForElementPresence(driver, By.id("account-menu"), 10);
	}

	public WebElement getSignUp() {
		return Utils.waitForElementPresence(driver, By.xpath("//a [@ui-sref=\"login\"]"), 10);
	}

	public WebElement getEntities() {
		return Utils.waitToBeClickable(driver, By.linkText("Entities"), 10);
	}

	public WebElement getStudentsLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@ui-sref=\"studenti\"]"), 10);
	}

	public WebElement getIspitniRokoviLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@ui-sref=\"ispitniRokovi\"]"), 10);
	}

	public WebElement getNastavniciLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@ui-sref=\"nastavnici\"]"), 10);
	}

	public WebElement getPredmetiLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@ui-sref=\"predmeti\"]"), 10);
	}

	public WebElement getIspitnePrijaveLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a [@ui-sref=\"ispitnePrijave\"]"), 10);
	}

	public WebElement getLogOut() {
		return Utils.waitToBeClickable(driver, By.id("logout"), 10);
	}

}
