package domaci;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;
import rs.ac.uns.testdevelopment.ssluzba.pages.global.LoginPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.global.MenuPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.nastavnici.NastavniciCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.nastavnici.NastavniciListPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.predmeti.PredmetiCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.predmeti.PredmetiListPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.studenti.StudentsCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.studenti.StudentsListPage;

@Test
public class Zadatak2 {
	private WebDriver driver;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private StudentsListPage studentsListPage;
	private StudentsCreationPage studentsCreationPage;
	private NastavniciListPage nastavniciListPage;
	private NastavniciCreationPage nastavniniCreationPage;
	private PredmetiListPage predmetiListPage;
	private PredmetiCreationPage predmetiCreationPage;
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
		studentsListPage = new StudentsListPage(driver);
		studentsCreationPage = new StudentsCreationPage(driver);
		nastavniciListPage = new NastavniciListPage(driver);
		nastavniniCreationPage = new NastavniciCreationPage(driver);
		predmetiCreationPage = new PredmetiCreationPage(driver);
		predmetiListPage = new PredmetiListPage(driver);
	}

	// sve provere su ubacene u jedan test
	// TODO za vezbu razdvojiti ovaj test u manje celine
	public void zadatak2() throws InterruptedException {
		menuPage.getAccountMenu().click();
		AssertJUnit.assertEquals(true, menuPage.getSignUp().isDisplayed());
		menuPage.getSignUp().click();
		loginPage.login("admin", "admin");

		// menu manipulation
		menuPage.getEntities().click();
		assertTrue(menuPage.getNastavniciLink().isDisplayed());
		menuPage.getNastavniciLink().click();

		Utils.waitForTitle(driver, "Nastavnicis", 10);
		nastavniciListPage.getCreateBtn().click();
		nastavniniCreationPage.createNastavnik("Milan", "Markovic", "Profesor");
		assertTrue(nastavniciListPage.getNastavniciTable().isDisplayed());
		assertTrue(nastavniciListPage.isNastavnikInTable("Milan"));

		// menu manipulation
		menuPage.getEntities().click();
		assertTrue(menuPage.getStudentsLink().isDisplayed());
		menuPage.getStudentsLink().click();

		// verify students list page
		Utils.waitForTitle(driver, "Studentis", 10);
		assertTrue(studentsListPage.getStudentsTable().isDisplayed());
		WebElement createBtn = studentsListPage.getCreateBtn();
		assertTrue(createBtn.isDisplayed());
		createBtn.click();

		// verify is modal present
		assertTrue(studentsCreationPage.getModalDialog().isDisplayed());
		assertEquals("Create or edit a Studenti", studentsCreationPage.getModalTitle().getText());

		studentsCreationPage.createStudent("E1234", "Marko", "Markovic", "Novi Sad");
		// add new student via helper function
		createBtn = studentsListPage.getCreateBtn();
		assertTrue(createBtn.isDisplayed());
		createBtn.click();

		// check row data
		assertTrue(studentsListPage.getStudentsTable().isDisplayed());
		assertTrue(studentsListPage.isStudentInTable("E1234"));
		WebElement studentRow = studentsListPage.getStudentRowByIndex("E1234");
		String rowData = studentRow.getText();
		assertTrue(rowData.contains("E1234 Marko Markovic Novi Sad"));

		// create a new student and check table content
		studentsCreationPage.createStudent("E5652", "Nikola", "Nikolic", "Beograda");
		assertTrue(studentsListPage.isStudentInTable("E5652"));
		studentRow = studentsListPage.getStudentRowByIndex("E5652");
		rowData = studentRow.getText();
		assertTrue(rowData.contains("E5652 Nikola Nikolic Beograda"));

		// menu manipulation
		menuPage.getEntities().click();
		assertTrue(menuPage.getPredmetiLink().isDisplayed());
		menuPage.getPredmetiLink().click();

		Utils.waitForTitle(driver, "Predmetis", 10);
		predmetiListPage.getCreateBtn().click();
		ArrayList<String> studenti = new ArrayList<String>();
		studenti.add("Marko Markovic");

		ArrayList<String> nastavnici = new ArrayList<String>();
		nastavnici.add("Milan Markovic");
		predmetiCreationPage.createPredmet("Matematika", studenti, nastavnici);
	}

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		driver.quit();
	}

}
