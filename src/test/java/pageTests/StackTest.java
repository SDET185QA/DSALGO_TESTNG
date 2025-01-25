package pageTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LinkedListIntroPage;
import pageObjects.LinkedListPage;
import pageObjects.LoginPage;
import pageObjects.StackPage;
import pageObjects.TryEditorPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class StackTest extends BaseClass{
	StackPage stackPage;
	ConfigReader configReader = new ConfigReader();
	HomePage homePage;
	LoginPage loginPage;
	TryEditorPage tryEditor;
	
	@BeforeClass
	public void getStartedToHomePage() throws IOException {
		stackPage = new StackPage();
		homePage = new HomePage();
		tryEditor = new TryEditorPage();
		loginPage = new LoginPage();
		loginToPortal();	
	}
//Clicking on Get started under Stack on Home page
	
	@BeforeMethod
	public void stackPageNav() {
	homePage.getStartedhome("Stack");
	stackPage.navigateToStackPage(driver);
	LoggerLoad.info("Getting started Stack");
}

	
	@Test
	public void theUserIsAbleToViewTheErrorMsgWithoutEnteringCodeInTryEditorPage() {
		stackPage.clickOnOperationsInStack();
		stackPage.clickOnTryHereOnSubPage();
		tryEditor.navigateToTryEditorPage(driver);
		tryEditor.clickOnRunBtn();
		String resultMsg = tryEditor.getMsg();
		assertEquals(resultMsg,"Please enter the text");
		LoggerLoad.info("The result Msg is:" + resultMsg);
	}
	
	@Test (dataProvider = "Valid Python Code", dataProviderClass =  DataProviderClass.class)
	public void theUserIsAbleToExecuteValidPythonCode(String code, String expectedOutput) {
		stackPage.clickOnOperationsInStack();
		stackPage.clickOnTryHereOnSubPage();
		tryEditor.navigateToTryEditorPage(driver);
		tryEditor.executeCode(code);
		tryEditor.clickOnRunBtn();
		String resultMsg = tryEditor.outputConsole();
		assertEquals(resultMsg,expectedOutput);
		LoggerLoad.info("The result message is :" + resultMsg +  "Valid python code is executing");
	}
	
	@Test (dataProvider = "Invalid Python Code", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToExecuteInvalidPythonCode (String code, String expectedOutput) {
		stackPage.clickOnOperationsInStack();
		stackPage.clickOnTryHereOnSubPage();
		tryEditor.navigateToTryEditorPage(driver);
		tryEditor.executeCode(code);
		tryEditor.clickOnRunBtn();
		String resultMsg = tryEditor.getErrorMsg();
		assertEquals(resultMsg,expectedOutput);
		LoggerLoad.info("The result message is :" + resultMsg);
	}
	
	@Test (dataProvider = "Open Stack Sub Pages", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToViewSubPage (String subPage, String expectedUrl) {
		stackPage.openSubPage(subPage);
		String actualUrl = driver.getCurrentUrl();
		assertEquals(actualUrl,expectedUrl);
		LoggerLoad.info("The actual Url is : " + actualUrl);
	}
	
	@Test (dataProvider = "Open Try Editor from Stack Sub pages", dataProviderClass = DataProviderClass.class)
	public void theUserIsAbleToViewTryEditorPageFromEverySubPage (String subPage, String expectedUrl) {
		stackPage.openSubPage(subPage);
		stackPage.clickOnTryHereOnSubPage();
		tryEditor.navigateToTryEditorPage(driver);
		String actualUrl = driver.getCurrentUrl();
		assertEquals(actualUrl,expectedUrl);
		LoggerLoad.info("The actual url is :" + actualUrl);
	}
	
	@Test
	public void theUserIsAbleToViewPracticeQnsPage() {
		stackPage.clickOnOperationsInStack();
		stackPage.ClickOnPracticeQns();
		String actualContent = stackPage.getPracticeQnsContent();
		LoggerLoad.info("The actual contents are :" + actualContent);
		assertNotEquals(actualContent, "");
	}
	
	@AfterMethod
	public void retunToHomePageToStart() {
		driver.get(ConfigReader.getlUrl("applicationUrl"));
		loginPage.clickOnGetstarted();
		LoggerLoad.info("Returned to home page");
	}
	
}
