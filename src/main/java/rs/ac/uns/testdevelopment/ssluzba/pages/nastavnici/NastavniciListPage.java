package rs.ac.uns.testdevelopment.ssluzba.pages.nastavnici;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class NastavniciListPage {
	private WebDriver driver;

	public NastavniciListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCreateBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button [@ui-sref=\"nastavnici.new\"]"), 15);
	}

	public WebElement getNastavniciTable() {
		return Utils.waitForElementPresence(driver, By.className("jh-table"), 10);
	}

	public List<WebElement> getTableRows() {
		return this.getNastavniciTable().findElements(By.tagName("tr"));
	}

	public boolean isNastavnikInTable(String name) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + name + "\")]/../.."));
	}

	/**
	 * 
	 * Selekcija reda na osnovu broja indeksa. Prvo se selektuje <a> tag koji
	 * ima tekst kao ime, a zatim se pokupi njegov roditelj
	 * <td>(/../), a zatim roditelj od
	 * <td>sto predstavlja
	 * <tr>
	 * (/../)
	 * 
	 * @param name
	 *            ime
	 * 
	 * @return student row
	 * 
	 */
	public WebElement getNastavnikByName(String name) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + name + "\")]/../.."), 10);
	}

	public void deleteNastavnikByName(String name) {
		getNastavnikByName(name).findElement(By.className("btn-danger")).click();
	}

	public void editeNastavnikByName(String name) {
		getNastavnikByName(name).findElement(By.className("btn-primary")).click();
	}

	public void viewNastavnikByName(String name) {
		getNastavnikByName(name).findElement(By.className("btn-info")).click();
	}

}
