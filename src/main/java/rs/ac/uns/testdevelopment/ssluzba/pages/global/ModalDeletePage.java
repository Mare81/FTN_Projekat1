package rs.ac.uns.testdevelopment.ssluzba.pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class ModalDeletePage {
	private WebDriver driver;

	public ModalDeletePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getModal() {
		return Utils.waitForElementPresence(driver, By.className("modal-dialog"), 15);
	}

	public void confirmDelete() {
		getModal().findElement(By.className("btn-danger")).click();
	}

	public void cancelDelete() {
		getModal().findElement(By.className("btn-default")).click();
	}
}
