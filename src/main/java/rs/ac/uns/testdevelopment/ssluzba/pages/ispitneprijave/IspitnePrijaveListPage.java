package rs.ac.uns.testdevelopment.ssluzba.pages.ispitneprijave;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class IspitnePrijaveListPage {
	private WebDriver driver;

	public IspitnePrijaveListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCreateBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button [@ui-sref=\"ispitnePrijave.new\"]"), 15);
	}

	public WebElement getIspitnaPrijavaTable() {
		return Utils.waitForElementPresence(driver, By.className("jh-table"), 10);
	}

	public List<WebElement> getTableRows() {
		return this.getIspitnaPrijavaTable().findElements(By.tagName("tr"));
	}
}
