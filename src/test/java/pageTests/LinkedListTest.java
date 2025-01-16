package pageTests;

import base.BaseClass;
import pageObjects.LinkedListPage;
import pageObjects.HomePage;
import utilities.ConfigReader;
import org.testng.annotations.Test;

import java.io.IOException;
import driver.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


	public class LinkedListTest extends BaseClass {
		LinkedListPage linkedList;
		ConfigReader configReader = new ConfigReader();
		HomePage homePage;
	
	@BeforeClass
	public void getStartedToHomePage() throws IOException {
		linkedList = new LinkedListPage();
		homePage = new HomePage();
		loginToPortal();	
	}
	
	// Clicking on Get started under Linked list on Home page
	@BeforeMethod 
	public void linkedListPageNav() {
		homePage.getStartedhome("Linked List");
	}
		
	@Test(priority=1)
	public void linkedListHomePage() {
		
	}
		
	
}
