package pageTests;

import base.BaseClass;
import pageObjects.LinkedListPage;
import pageObjects.LoginPage;
import pageObjects.TryEditorPage;
import pageObjects.HomePage;
import pageObjects.LinkedListIntroPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import driver.DriverFactory;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

	public class LinkedListTest extends BaseClass {
		LinkedListPage linkedListPage;
		ConfigReader configReader = new ConfigReader();
		HomePage homePage;
		LoginPage loginPage;
		TryEditorPage tryEditor;
		LinkedListIntroPage linkedListIntroPage;
	
	@BeforeClass
	public void getStartedToHomePage() throws IOException {
		linkedListPage = new LinkedListPage();
		homePage = new HomePage();
		tryEditor = new TryEditorPage();
		loginPage = new LoginPage();
		linkedListIntroPage = new LinkedListIntroPage();
		loginToPortal();	
	}
	
	// Clicking on Get started under Linked list on Home page
	@BeforeMethod 
	public void linkedListPageNav() {
		LoggerLoad.info("Getting started Linked List");
		homePage.getStartedhome("Linked List");
		linkedListPage.navigateToLinkedListPage(driver);
	}
		
	
	@Test
	public void theUserIsAbleToViewTheErrorMsgWithoutEnteringCodeInTryEditorPage() {
			linkedListPage.clickOnIntro();
			linkedListIntroPage.navigateToLinkedListIntroPage(driver);
			linkedListIntroPage.tryHere();
			tryEditor.navigateToTryEditorPage(driver);
			tryEditor.clickOnRunBtn();
			String resultMsg = tryEditor.getMsg();
			LoggerLoad.info("Result Message: " + resultMsg);
			assertEquals(resultMsg, "Please enter the text");
		}
	
	@Test(dataProvider = "Valid Python Code", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToExecuteValidPythonCode(String code, String expectedOutput) {
		linkedListPage.clickOnIntro();
		linkedListIntroPage.navigateToLinkedListIntroPage(driver);
		linkedListIntroPage.tryHere();
		tryEditor.navigateToTryEditorPage(driver);
		tryEditor.executeCode(code);
		tryEditor.clickOnRunBtn();
		String resultMsg = tryEditor.outputConsole();
		LoggerLoad.info("Result Message:  " + resultMsg);
		assertEquals(resultMsg, expectedOutput);
	}
	
	@Test (dataProvider = "Invalid Python Code", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToExecuteInvalidPythonCode (String code, String expectedOutput) {
		linkedListPage.clickOnIntro();
		linkedListIntroPage.navigateToLinkedListIntroPage(driver);
		linkedListIntroPage.tryHere();
		tryEditor.navigateToTryEditorPage(driver);
		tryEditor.executeCode(code);
		tryEditor.clickOnRunBtn();
		String resultMsg = tryEditor.getErrorMsg();
		LoggerLoad.info("Result Message:  " + resultMsg);
		assertEquals(resultMsg, expectedOutput);
		
	}
	
	@Test (dataProvider = "Open Sub Pages", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToViewSubPage(String subPage, String expectedUrl) {
		linkedListPage.openSubPage(subPage);
		String actualUrl = driver.getCurrentUrl();
		LoggerLoad.info("Actual URL is :" + actualUrl);
		assertEquals(actualUrl, expectedUrl);
	}
	
	@Test (dataProvider = "Open Try Editor From Sub Pages", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToViewTryEditorPageFromEverySubPage(String subPage, String expectedUrl) {
		linkedListPage.openSubPage(subPage);
		linkedListPage.tryHereOnSubPage();
		String actualUrl = driver.getCurrentUrl();
		LoggerLoad.info("Actual URL is : " + actualUrl);
		assertEquals(actualUrl,expectedUrl);
	}
	
	@Test 
	public void theUserIsAbleToViewPracticeQnsPage() {
		linkedListPage.clickOnIntro();
		linkedListIntroPage.navigateToLinkedListIntroPage(driver);
		linkedListIntroPage.practiceQns();
		String actualContent = linkedListIntroPage.getPracticeQnsContent();
		LoggerLoad.info("The Practice Questions Page Contents are: " + actualContent);
		assertNotEquals(actualContent, "");
	}
	@AfterMethod
	public void retunToHomePageToStart() {
		driver.get(ConfigReader.getlUrl("applicationUrl"));
		loginPage.clickOnGetstarted();
		LoggerLoad.info("Returned to home page");
	}

	}
