package domaci;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;
import rs.ac.uns.testdevelopment.ssluzba.pages.global.LoginPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.global.MenuPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.global.ModalDeletePage;
import rs.ac.uns.testdevelopment.ssluzba.pages.studenti.StudentsCreationPage;
import rs.ac.uns.testdevelopment.ssluzba.pages.studenti.StudentsListPage;

@Test
public class Zadatak1 {
	private WebDriver driver;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private StudentsListPage studentsListPage;
	private StudentsCreationPage studentsCreationPage;
	private ModalDeletePage modalDeletePage;
	private String baseUrl;

	@BeforeSuite
	public void setupSelenium() {
		baseUrl = "http://localhost:8080/#/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.navigate().to(baseUrl);

	}

	@BeforeTest
	public void setupPages() {
		// init pages
		loginPage = new LoginPage(driver);
		menuPage = new MenuPage(driver);
		studentsListPage = new StudentsListPage(driver);
		studentsCreationPage = new StudentsCreationPage(driver);
		modalDeletePage = new ModalDeletePage(driver);
	}

	// sve provere su ubacene u jedan test
	// TODO za vezbu razdvojiti ovaj test u manje celine
	public void login() {
		menuPage.getAccountMenu().click();
		assertEquals(true, menuPage.getSignUp().isDisplayed());
		menuPage.getSignUp().click();
		loginPage.login("admin", "admin");
	}

	public void addFirstStudent() {
		// menu manipulation
		menuPage.getEntities().click();
		assertTrue(menuPage.getStudentsLink().isDisplayed());
		menuPage.getStudentsLink().click();

		// verify students list page
		Utils.waitForTitle(driver, "Studentis", 10);
		assertEquals(baseUrl + "studentis", driver.getCurrentUrl());
		assertTrue(studentsListPage.getStudentsTable().isDisplayed());
		WebElement createBtn = studentsListPage.getCreateBtn();
		assertTrue(createBtn.isDisplayed());
		createBtn.click();

		// verify is modal present
		assertEquals(baseUrl + "studentis/new", driver.getCurrentUrl());
		assertTrue(studentsCreationPage.getModalDialog().isDisplayed());
		// check visibility
		assertTrue(studentsCreationPage.getIndex().isDisplayed());
		assertTrue(studentsCreationPage.getIme().isDisplayed());
		assertTrue(studentsCreationPage.getPrezime().isDisplayed());
		assertTrue(studentsCreationPage.getGrad().isDisplayed());
		assertTrue(studentsCreationPage.getCancelBtn().isDisplayed());
		assertTrue(studentsCreationPage.getSaveBtn().isDisplayed());

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
	}

	public void addSecondStudent() {
		// create a new student and check table content
		studentsCreationPage.createStudent("E5652", "Nikola", "Nikolic", "Beograda");
		assertTrue(studentsListPage.isStudentInTable("E5652"));
		WebElement studentRow = studentsListPage.getStudentRowByIndex("E5652");
		String rowData = studentRow.getText();
		assertTrue(rowData.contains("E5652 Nikola Nikolic Beograda"));

		// edit Nikola Nikolic
		studentsListPage.editStudentByIndex("E5652");
		assertTrue(studentsCreationPage.getModalDialog().isDisplayed());
		studentsCreationPage.setGrad("Kraljevo");
		studentsCreationPage.getSaveBtn().click();
		studentRow = studentsListPage.getStudentRowByIndex("E5652");
		rowData = studentRow.getText();
		assertTrue(studentsListPage.isStudentInTable("E5652"));
		assertTrue(rowData.contains("E5652 Nikola Nikolic Kraljevo"));
	}

	public void deleteAllStudents() {

		// delete all added students
		studentsListPage.deleteStudentByIndex("E1234");
		WebElement modalDelete = modalDeletePage.getModal();
		assertTrue(modalDelete.isDisplayed());
		modalDeletePage.confirmDelete();

		//
		assertTrue(studentsListPage.isStudentInTable("E5652"));
		studentsListPage.deleteStudentByIndex("E5652");
		modalDelete = modalDeletePage.getModal();
		assertTrue(modalDelete.isDisplayed());
		modalDeletePage.confirmDelete();

		// check table content
		assertFalse(studentsListPage.isStudentInTable("E1234"));
		assertFalse(studentsListPage.isStudentInTable("E5652"));
	}

	public void logout() {
		// Shutdown the browser
		menuPage.getAccountMenu().click();
		menuPage.getLogOut().click();
		
	}
	@AfterSuite
	public void closeSelenium() {
		driver.quit();
	}

}
