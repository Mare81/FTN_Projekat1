package rs.ac.uns.testdevelopment.ssluzba.pages.predmeti;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class PredmetiCreationPage {
	private WebDriver driver;

	public PredmetiCreationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getModalDialog() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 10);
	}

	public WebElement getModalTitle() {
		return Utils.waitForElementPresence(driver, By.id("myPredmetiLabel"), 10);
	}

	public WebElement getNaziv() {
		return Utils.waitForElementPresence(driver, By.name("naziv"), 10);
	}

	public void setNaziv(String value) {
		WebElement el = this.getNaziv();
		el.clear();
		el.sendKeys(value);
	}

	public Select getStudentiSelect() {
		return new Select(Utils.waitForElementPresence(driver, By.name("studenti"), 10));
	}

	/**
	 * 
	 * @param students
	 *            Lista studenata koja ce biti selektovana "Ime Prezime",
	 *            "Ime Prezime"..
	 */
	public void setStudentsByLabel(ArrayList<String> students) {
		Select studenti = this.getStudentiSelect();
		for (String student : students) {
			studenti.selectByVisibleText(student);
		}
	}

	public Select getNastavniciSelect() {
		return new Select(Utils.waitForElementPresence(driver, By.name("nastavnici"), 10));
	}

	/**
	 * 
	 * @param nastavnici
	 *            Lista nastavnika koja ce biti selektovana "Ime Prezime",
	 *            "Ime Prezime"..
	 */
	public void setNastavniciByLabel(ArrayList<String> nastavnici) {
		Select nastavnikSelect = this.getNastavniciSelect();
		for (String nastavnik : nastavnici) {
			nastavnikSelect.selectByVisibleText(nastavnik);
		}
	}

	public WebElement getCancelBtn() {
		return getModalDialog().findElement(By.className("btn-default"));
	}

	public WebElement getSaveBtn() {
		return getModalDialog().findElement(By.className("btn-primary"));
	}

	public void createPredmet(String naziv, ArrayList studenti, ArrayList nastavnici) {
		setNaziv(naziv);
		setStudentsByLabel(studenti);
		setNastavniciByLabel(nastavnici);
		getSaveBtn().click();
	}

}
