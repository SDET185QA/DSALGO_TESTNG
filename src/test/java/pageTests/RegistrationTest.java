package pageTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class RegistrationTest extends BaseClass {
		
		ConfigReader configReader = new ConfigReader();
		HomePage homePage;
		LoginPage loginPage;
		RegistrationPage registrationPage;
		
 @BeforeClass
 public void getStartedToRegistrationPage() throws IOException {
	 	homePage = new HomePage();
	 	loginPage = new LoginPage();
	 	registrationPage = new RegistrationPage();
	 	LoggerLoad.info("Checking sign out button is visible in home page");
	 	homePage.dsalgoportal();
	 	homePage.getstarted_btn();
	 	loginPage.clickOnSignOutIfLoggedIn();
	 		
 }
 
 @BeforeMethod
 public void regPageNav() throws InterruptedException {
	 homePage.registerLink();
	 registrationPage.navigateToRegistrationPage(driver);
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 registrationPage.clickOnRegisterBtn();
	 LoggerLoad.info("Registration Page navigated successfully");
 }
		
 
 @Test 
 public void verifyTheUserReceivesErrorMsgForAllEmptyFields() {
	 registrationPage.clickOnRegisterBtn();
	 String errorMsg = registrationPage.getValidationMsgOnUserName();
	 assertEquals(errorMsg, "Please fill out this field.");
	 LoggerLoad.info("Error message :" + errorMsg);
 
 }
 
 @Test  (dataProvider = "Empty Username Field", dataProviderClass = DataProviderClass.class)
 public void verifyIfTheUserReceivesErrorMsgForEmptyUsernameField(String passwordTxt, String passwordConf, String expectedOutput) {
	 registrationPage.enterPassword(passwordTxt);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getValidationMsgOnUserName();
	 assertEquals( actualResult, expectedOutput);
	 LoggerLoad.info("Error message:" + actualResult);
 }
 
 @Test (dataProvider = "Empty Password Field", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForEmptyPasswordField(String userName, String passwordConf, String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getValidationMsgOnPassword();
	 assertEquals(actualResult, expectedOutput);
	 LoggerLoad.info("The actual error message is :" + actualResult);
 }
 
 @Test (dataProvider = "Empty Password Confirmation Field", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForEmptyPasswordConfField(String userName, String password, String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPassword(password);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getValidationMsgOnPasswordConf();
	 assertEquals(actualResult, expectedOutput);
	 LoggerLoad.info("The actual error message is :" + actualResult);
 }
 
 @Test (dataProvider = "Username With Special Characters", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForInvalidUsername(String userName, String password, String passwordConf, String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPassword(password);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getErrorOnPasswordMsg();
	 assertEquals (actualResult, expectedOutput);
	 LoggerLoad.info("The actual error message is :" + actualResult);
 }
 
 @Test (dataProvider = "Only Numeric Password With Valid UserName", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForInvalidPassword(String userName, String password, String passwordConf, String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPassword(passwordConf);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getErrorOnPasswordMsg();
	 assertEquals (actualResult, expectedOutput);
	 LoggerLoad.info("The actual error message is :" + actualResult);
	 
 }
 
 @Test (dataProvider = "Mismatch Password and Password Confirmation", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForMismatchPwdAndPwdConf(String userName, String password, String passwordConf,String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPassword(password);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getErrorOnPasswordMsg();
	 assertEquals (actualResult, expectedOutput);
	 LoggerLoad.info("The actual error message is :" + actualResult);
	 
 }
 
// @Test (dataProvider = "Valid credentials", dataProviderClass = DataProviderClass.class)
// public void verifyTheUserIsAbleToRegisterWithValidData(String userName, String password, String passwordConf, String expectedOutput) {
//	 registrationPage.enterUserName(userName);
//	 registrationPage.enterPassword(password);
//	 registrationPage.enterPasswordConf(passwordConf);
//	 registrationPage.clickOnRegisterBtn();
//	 String actualResult = driver.getCurrentUrl();
//	 assertEquals(actualResult, expectedOutput);
//	 LoggerLoad.info("New user created:" + actualResult);
// }
 
 @Test (dataProvider = "Username Lessthan 8 Char", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForUsernameLessThanEightChar(String userName, String password, String passwordConf, String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPassword(password);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getErrorOnPasswordMsg();
	 assertEquals(actualResult,expectedOutput);
	 LoggerLoad.info("The actual Error message is :" + actualResult);
 }
 
 @Test(dataProvider = "Password Lessthan 8 Char", dataProviderClass = DataProviderClass.class)
 public void verifyTheUserReceivesErrorMsgForPasswordLessThanEightChar(String userName, String password, String passwordConf, String expectedOutput) {
	 registrationPage.enterUserName(userName);
	 registrationPage.enterPassword(password);
	 registrationPage.enterPasswordConf(passwordConf);
	 registrationPage.clickOnRegisterBtn();
	 String actualResult = registrationPage.getErrorOnPasswordMsg();
	 assertEquals(actualResult, expectedOutput);
	 LoggerLoad.info("The actual Error message is :" + actualResult);
 
 }
}
