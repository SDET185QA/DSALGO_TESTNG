package pageTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import base.BaseClass;
import pageObjects.HomePage;
import utilities.LoggerLoad;

public class HomePageTest extends BaseClass {
	
	 HomePage Home;

		
		@BeforeClass
		public void Login() throws IOException {
			LoggerLoad.info("Home Page Before class");
			 Home=new HomePage();
			loginToPortal();
		}
		
		@Test(priority=1)
		public void ClickDSGetStared() {
			LoggerLoad.info("Clicking on Data Structures Get Started");
			Home.getStartedDSintroclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Data Structures-Introduction");
		
		}
		
		@Test(priority=2)
		public void ClickgetStartedarray() {
			LoggerLoad.info("Clicking on Array Get Started");
			driver.navigate().back();
			Home.getStartedarrayclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Array");
			
		}
		
		@Test(priority=3)
		public void ClickgetStartedlinkedlist() {
			LoggerLoad.info("Clicking on LinkedList Get Started");
			driver.navigate().back();
			Home.getStartedlinkedlistclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Linked List");
			
		}
		
		@Test(priority=4)
		public void ClickgetStartedstack() {
			LoggerLoad.info("Clicking on Stack Get Started");
			driver.navigate().back();
			Home.getStartedstackclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Stack");
		}
		
		@Test(priority=5)
		public void ClickgetStartedQueue() {
			LoggerLoad.info("Clicking on Queue Get Started");
			driver.navigate().back();
			Home.getStartedqueueclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Queue");
			
		}
		
		@Test(priority=6)
		public void ClickgetStartedGraph() {
			LoggerLoad.info("Clicking on Graph Get Started");
			driver.navigate().back();
			Home.getStartedgraphclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Graph");
			
		}
		
		@Test(priority=7)
		public void ClickgetStartedTree() {
			LoggerLoad.info("Clicking on Tree Get Started");
			driver.navigate().back();
			Home.getStartedtreeclick();
			String title =Home.getTitleofPage();
			assertEquals(title,"Tree");
			
		}
		
		
		
		@AfterClass
		public void Logout() {
			LoggerLoad.info("HomePage module AfterClass");
			Home.signout();
			
		}
}
