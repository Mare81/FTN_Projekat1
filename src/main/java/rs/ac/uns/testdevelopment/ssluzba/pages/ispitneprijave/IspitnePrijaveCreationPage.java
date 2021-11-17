package rs.ac.uns.testdevelopment.ssluzba.pages.ispitneprijave;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

/**
 * IspitnePrijaveCreationPage klasa predstavlja POM stranice za kreiranje
 * ispitnih prijave. Stranica za dodavanje je u aplikaciji predstavljena
 * modalnim dijalogom.
 * 
 * @author mkondic
 *
 */
public class IspitnePrijaveCreationPage {
	private WebDriver driver;

	public IspitnePrijaveCreationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getModalDialog() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 10);
	}

	public WebElement getModalTitle() {
		return Utils.waitForElementPresence(driver, By.id("myIspitnePrijaveLabel"), 10);
	}

	public WebElement getTeorija() {
		return Utils.waitForElementPresence(driver, By.id("field_teorija"), 10);
	}

	public void setTeorija(String value) {
		WebElement teorija = this.getTeorija();
		teorija.clear();
		teorija.sendKeys(value);
	}

	public WebElement getZadaci() {
		return Utils.waitForElementPresence(driver, By.id("field_zadaci"), 10);
	}

	public void setZadaci(String value) {
		WebElement zadaci = this.getZadaci();
		zadaci.clear();
		zadaci.sendKeys(value);
	}

	public Select getIspitniRok() {
		return new Select(Utils.waitForElementPresence(driver, By.id("field_ispitniRok"), 10));
	}

	public void setIspitniRok(String value) {
		this.getIspitniRok().selectByVisibleText(value);
	}

	public Select getStudent() {
		return new Select(Utils.waitForElementPresence(driver, By.id("field_student"), 10));
	}

	public void setStudent(String value) {
		this.getStudent().selectByVisibleText(value);
	}

	public Select getPredmet() {
		return new Select(Utils.waitForElementPresence(driver, By.id("field_predmet"), 10));
	}

	public void setPredmet(String value) {
		this.getPredmet().selectByVisibleText(value);
	}

	public WebElement getCancelBtn() {
		return Utils.waitToBeClickable(driver, By.className("btn-default"), 10);
	}

	public WebElement getSaveBtn() {
		return getModalDialog().findElement(By.className("btn-primary"));
	}

	public void createIspitnaPrijava(String teorija, String zadaci, String ispitniRok, String student, String predmet) {
		setTeorija(teorija);
		setZadaci(zadaci);
		setIspitniRok(ispitniRok);
		setStudent(student);
		setPredmet(predmet);
	}

}
