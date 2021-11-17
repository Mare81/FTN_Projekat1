package rs.ac.uns.testdevelopment.ssluzba.pages.predmeti;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class PredmetiListPage {
	private WebDriver driver;

	public PredmetiListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCreateBtn(){
		return Utils.waitToBeClickable(driver, By.xpath("//button [@ui-sref=\"predmeti.new\"]"), 15);
	}

	public WebElement getPredmetiTable() {
		return Utils.waitForElementPresence(driver, By.className("jh-table"), 10);
	}

	public List<WebElement> getTableRows() {
		return this.getPredmetiTable().findElements(By.tagName("tr"));
	}
	
	public boolean isPredmetInTable(String name){
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + name + "\")]/../.."));
	}
	/**
	 * 
	 * Selekcija reda na osnovu broja indeksa. Prvo se selektuje <a> tag koji ima tekst kao ime,
	 * a zatim se pokupi njegov roditelj <td> (/../), a zatim roditelj od <td> sto predstavlja <tr> (/../)
	 * 
	 * @param  name ime
	 * 
	 * @return student row
	 * 
	 */
	public WebElement getPredmetByName(String name) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + name + "\")]/../.."), 10);
	}

	public void deletePredmetByName(String name) {
		getPredmetByName(name).findElement(By.className("btn-danger")).click();
	}

	public void editePredmetByName(String name) {
		getPredmetByName(name).findElement(By.className("btn-primary")).click();
	}

	public void viewPredmetByName(String name) {
		getPredmetByName(name).findElement(By.className("btn-info")).click();
	}

}
