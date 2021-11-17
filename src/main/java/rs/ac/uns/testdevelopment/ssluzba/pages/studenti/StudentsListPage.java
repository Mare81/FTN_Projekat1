package rs.ac.uns.testdevelopment.ssluzba.pages.studenti;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class StudentsListPage {
	private WebDriver driver;

	public StudentsListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCreateBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ui-sref=\"studenti.new\"]"), 10);
	}

	public WebElement getStudentsTable() {
		return Utils.waitForElementPresence(driver, By.className("jh-table"), 10);
	}

	public List<WebElement> getTableRows() {
		return this.getStudentsTable().findElements(By.tagName("tr"));
	}

	public boolean isStudentInTable(String index) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + index + "\")]/../.."));
	}

	/**
	 * 
	 * Selekcija reda na osnovu broja indeksa. Prvo se selektuje <a> tag koji
	 * ima tekst kao indeks, a zatim se pokupi njegov roditelj
	 * <td>(/../), a zatim roditelj od
	 * <td>sto predstavlja
	 * <tr>
	 * (/../)
	 * 
	 * @param index
	 *            - broj indeksa
	 * 
	 * @return student row
	 * 
	 */
	public WebElement getStudentRowByIndex(String index) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + index + "\")]/../.."), 10);
	}

	public void deleteStudentByIndex(String index) {
		getStudentRowByIndex(index).findElement(By.className("btn-danger")).click();
	}

	public void editStudentByIndex(String index) {
		getStudentRowByIndex(index).findElement(By.className("btn-primary")).click();
	}

	public void viewStudentByIndex(String index) {
		getStudentRowByIndex(index).findElement(By.className("btn-info")).click();
	}

}
