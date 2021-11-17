package rs.ac.uns.testdevelopment.ssluzba.pages.ispitnirokovi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class IspitniRokoviCreationPage {
	private WebDriver driver;

	public IspitniRokoviCreationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getModalDialog() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 10);
	}

	public WebElement getModalTitle() {
		return Utils.waitForElementPresence(driver, By.id("myIspitniRokoviLabel"), 10);
	}

	public WebElement getNaziv() {
		return Utils.waitForElementPresence(driver, By.name("naziv"), 10);
	}

	public void setNaziv(String value) {
		WebElement el = this.getNaziv();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getPocetak() {
		return Utils.waitForElementPresence(driver, By.id("field_pocetak"), 10);
	}

	public void setPocetak(String value) {
		WebElement el = this.getPocetak();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getKraj() {
		return Utils.waitForElementPresence(driver, By.id("field_kraj"), 10);
	}

	public void setKraj(String value) {
		WebElement el = this.getKraj();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getCancelBtn() {
		return Utils.waitToBeClickable(driver, By.className("btn-default"), 10);
	}

	public WebElement getSaveBtn() {
		return getModalDialog().findElement(By.className("btn-primary"));
	}

	/**
	 * Helper metoda za kreiranje ispitnog roka
	 * 
	 * @param naziv
	 * @param pocetak
	 * @param kraj
	 */
	public void createIspitniRok(String naziv, String pocetak, String kraj) {
		setNaziv(naziv);
		setPocetak(pocetak);
		setKraj(kraj);
		getSaveBtn().click();
	}
}
