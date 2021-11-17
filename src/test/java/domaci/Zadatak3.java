package domaci;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rs.ac.uns.testdevelopment.ssluzba.pages.global.LoginPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.global.MenuPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.ispitneprijave.IspitnePrijaveCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.ispitneprijave.IspitnePrijaveListPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.ispitnirokovi.IspitniRokoviCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.ispitnirokovi.IspitniRokoviListPage;

@Test
public class Zadatak3 {
	private WebDriver driver;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private IspitniRokoviListPage ispitniRokoviPage;
	private IspitniRokoviCreationPage ispitniRokoviCreationPage;
	private IspitnePrijaveListPage ispitnePrijaveListPage;
	private IspitnePrijaveCreationPage ispitnePrijaveCreationPage;
	private String baseUrl;

	@BeforeMethod
	public void setupSelenium() {
		baseUrl = "localhost:8080/#/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.navigate().to(baseUrl);

		// init pages
		loginPage = new LoginPage(driver);
		menuPage = new MenuPage(driver);
		ispitniRokoviPage = new IspitniRokoviListPage(driver);
		ispitniRokoviCreationPage = new IspitniRokoviCreationPage(driver);
		ispitnePrijaveListPage = new IspitnePrijaveListPage(driver);
		ispitnePrijaveCreationPage = new IspitnePrijaveCreationPage(driver);
	}

	// sve provere su ubacene u jedan test
	// TODO za vezbu razdvojiti ovaj test u manje celine
	public void zadatak3() throws InterruptedException {
		menuPage.getAccountMenu().click();
		AssertJUnit.assertEquals(true, menuPage.getSignUp().isDisplayed());
		menuPage.getSignUp().click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleIs("Sign in"));
		loginPage.login("admin", "admin");

		menuPage.getEntities().click();
		assertTrue(menuPage.getIspitniRokoviLink().isDisplayed());
		menuPage.getIspitniRokoviLink().click();

		ispitniRokoviPage.getCreateBtn().click();
		ispitniRokoviCreationPage.createIspitniRok("Aprilski", "2016-04-15", "2016-04-22");

		menuPage.getEntities().click();
		assertTrue(menuPage.getIspitnePrijaveLink().isDisplayed());
		menuPage.getIspitnePrijaveLink().click();

		ispitnePrijaveListPage.getCreateBtn().click();
		ispitnePrijaveCreationPage.createIspitnaPrijava("30", "55", "Aprilski", "E1234 Marko Markovic", "Matematika");

	}

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		driver.quit();
	}

}
