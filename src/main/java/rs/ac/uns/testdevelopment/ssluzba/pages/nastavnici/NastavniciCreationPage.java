package rs.ac.uns.testdevelopment.ssluzba.pages.nastavnici;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class NastavniciCreationPage {
	private WebDriver driver;

	public NastavniciCreationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getModalDialog() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 10);
	}

	public WebElement getModalTitle() {
		return Utils.waitForElementPresence(driver, By.id("myNastavniciLabel"), 10);
	}

	public WebElement getIme() {
		return Utils.waitForElementPresence(driver, By.name("ime"), 10);
	}

	public void setIme(String value) {
		WebElement el = this.getIme();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getPrezime() {
		return Utils.waitForElementPresence(driver, By.name("prezime"), 10);
	}

	public void setPrezime(String value) {
		WebElement el = this.getPrezime();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getZvanje() {
		return Utils.waitForElementPresence(driver, By.name("zvanje"), 10);
	}

	public void setZvanje(String value) {
		WebElement el = this.getZvanje();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getCancelBtn() {
		return getModalDialog().findElement(By.className("btn-default"));
	}

	public WebElement getSaveBtn() {
		return getModalDialog().findElement(By.className("btn-primary"));
	}

	public void createNastavnik(String ime, String prezime, String zvanje) {
		setIme(ime);
		setPrezime(prezime);
		setZvanje(zvanje);
		getSaveBtn().click();
	}

}
