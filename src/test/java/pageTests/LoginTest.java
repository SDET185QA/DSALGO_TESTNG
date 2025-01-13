package pageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import pageObjects.LoginPage;
import base.BaseClass;

import utilities.LoggerLoad;


public class LoginTest extends BaseClass {

	LoginPage  sign;
	ConfigReader reader = new ConfigReader();
 
	
	@BeforeClass
	public void signin () throws IOException {
		LoggerLoad.info("Sigin module Beforeclass");
		LoginPage sign = new LoginPage();
		loginToPortal();  
		
		
	}

	@Test(priority = 1,dataProvider = "ValidLoginData", dataProviderClass = DataProviderClass.class)
	public void verify_validLogin(String username, String password, String expectedMessage) {
		
		LoginPage sign = new LoginPage();
		LoggerLoad.info("Testing Verify Valid Login");
		sign.clickonLogout();
		sign.clickOnSignin();
		LoggerLoad.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ password + "\" ");
		String actualMessage = null;
		if (username != null || password != null) {
			sign.enter_user_name(username);
			sign.enter_user_password(password);
			sign.clickonLogin();
			actualMessage = sign.getlogoutAlert(expectedMessage);

	} 
		LoggerLoad.info("The validate login actual message is "+actualMessage +"and the expected message is"+expectedMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
		LoggerLoad.info("Completed Testing Verify Valid Login");
	
	}
	@Test(priority=2)
	public void signOut() {
		LoginPage sign = new LoginPage();
		LoggerLoad.info("Testing Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Logout");
	}
	
	
	@Test(priority = 3, dataProvider = "InValidLoginData", dataProviderClass = DataProviderClass.class)
	public void verify_inValidLogin(String username, String password, String expectedMessage) {
		
		
		
		LoginPage sign = new LoginPage();
		LoggerLoad.info("Testing Verify Invalid Login");
	
		sign.clickOnSignin();

		LoggerLoad.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ password + "\" ");
		if (username != null || password != null) {

			sign.enter_user_name(username);
			sign.enter_user_password(password);
			sign.clickonLogin();

		}

		
		String userNameValidationMessage = sign.validate_login_with_blank_credentials(expectedMessage,"username");
		String passwordValidationMessage = sign.validate_login_with_blank_credentials(expectedMessage,"password");

		if (username.isEmpty() && password.isEmpty()) {
			
			Assert.assertEquals(userNameValidationMessage, expectedMessage);
			LoggerLoad.info("The username validation  alert : " +userNameValidationMessage +"is equal to the expected message" + expectedMessage);
		} 
			else if (username.isEmpty() && !password.isEmpty()) {
				
			Assert.assertEquals(userNameValidationMessage, expectedMessage);
			LoggerLoad.info("The username validation  alert : " +userNameValidationMessage +"is equal to the expected message" + expectedMessage);
		} else if (!username.isEmpty() && password.isEmpty()) {
			
			Assert.assertEquals(passwordValidationMessage, expectedMessage);
			LoggerLoad.info("The password validation  alert : " +passwordValidationMessage +"is equal to the expected message" + expectedMessage);
		} else if (!username.isEmpty() && !password.isEmpty()) {
			
			String invalidgetMessage = sign.getlogoutAlert(expectedMessage);
			Assert.assertEquals(invalidgetMessage, expectedMessage);
			LoggerLoad.info("The username and password validation  alert : " +invalidgetMessage +" is  equal to the expected message" + expectedMessage);

		}
		LoggerLoad.info("Completed Testing Verify Invalid Login");
	}
	@Test(priority=4)
	public void DataStructuresSignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Datastructure Page  Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedDataStructures();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Datastructure page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Datastructure Page Logout");
	}
	@Test(priority=5)
	public void ArraySignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Array Page Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedArray();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Array page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Array Page Logout");
	}
	@Test(priority=6)
	public void LinkedListSignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Linked List  Page Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedLinkedList();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Linked List page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Linked List  Page Logout");
	}
	
	@Test(priority=7)
	public void StackSignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Stack  Page Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedStack();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Stack page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Stack  Page Logout");
	}
	@Test(priority=8)
	public void QueueSignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Queue  Page Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedQueue();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Queue page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Queue  Page Logout");
	}
	
	@Test(priority=9)
	public void TreeSignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Tree  Page Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedTree();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Tree page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Tree  Page Logout");
	}
	@Test(priority=10)
	public void GraphSignOut() throws IOException {
		LoginPage sign = new LoginPage();
		loginToPortal();
		LoggerLoad.info("Testing Graph  Page Logout");
		String expectedLogoutMessage = "Logged out successfully";
		sign.clickOnGetstartedGraph();
		sign.clickonLogout();
		String logoutMessage = sign.getlogoutAlert(expectedLogoutMessage);
		LoggerLoad.info("The validate Graph page sign out actual message is "+logoutMessage +"and the expected message is"+expectedLogoutMessage);
        Assert.assertEquals(expectedLogoutMessage, logoutMessage);
        LoggerLoad.info("Completed Testing Graph  Page Logout");
	}
	

}