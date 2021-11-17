package rs.ac.uns.testdevelopment.ssluzba.pages.studenti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class StudentsCreationPage {
	private WebDriver driver;

	public StudentsCreationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getModalDialog() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 10);
	}

	public WebElement getModalTitle() {
		return Utils.waitForElementPresence(driver, By.id("myStudentiLabel"), 10);
	}

	public WebElement getIndex() {
		return Utils.waitForElementPresence(driver, By.name("indeks"), 10);
	}

	public void setIndex(String value) {
		WebElement el = this.getIndex();
		el.clear();
		el.sendKeys(value);
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

	public WebElement getGrad() {
		return Utils.waitForElementPresence(driver, By.name("grad"), 10);
	}

	public void setGrad(String value) {
		WebElement el = this.getGrad();
		el.clear();
		el.sendKeys(value);
	}

	public WebElement getCancelBtn() {
		return getModalDialog().findElement(By.className("btn-default"));
	}

	public WebElement getSaveBtn() {
		return getModalDialog().findElement(By.className("btn-primary"));
	}

	public void createStudent(String index, String ime, String prezime, String grad) {
		setIndex(index);
		setIme(ime);
		setPrezime(prezime);
		setGrad(grad);
		getSaveBtn().click();
	}

}
