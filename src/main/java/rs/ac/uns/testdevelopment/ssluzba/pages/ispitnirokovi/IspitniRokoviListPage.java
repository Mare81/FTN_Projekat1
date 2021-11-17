package rs.ac.uns.testdevelopment.ssluzba.pages.ispitnirokovi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

/**
 * IspitniRokoviListPage klasa predstavlja POM stanice za prikaz liste ispitnih
 * rokova.
 * 
 * @author mkondic
 *
 */
public class IspitniRokoviListPage {
	private WebDriver driver;

	public IspitniRokoviListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCreateBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button [@ui-sref=\"ispitniRokovi.new\"]"), 10);
	}

	public WebElement getIspitniRokoviTable() {
		return Utils.waitForElementPresence(driver, By.className("jh-table"), 10);
	}

	public List<WebElement> getTableRows() {
		return this.getIspitniRokoviTable().findElements(By.tagName("tr"));
	}

	public WebElement getIspitniRokByName(String index) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + index + "\")]/../.."), 15);
	}

	public void deleteIspitniRokByName(String index) {
		getIspitniRokByName(index).findElement(By.className("btn-danger")).click();
	}

	public void editIspitniRokByName(String index) {
		getIspitniRokByName(index).findElement(By.className("btn-primary")).click();
	}

	public void viewIspitniRokByName(String index) {
		getIspitniRokByName(index).findElement(By.className("btn-info")).click();
	}

}
