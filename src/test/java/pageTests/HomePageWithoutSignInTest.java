package pageTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import utilities.LoggerLoad;

public class HomePageWithoutSignInTest extends BaseClass {
	 HomePage Home;
	 String alertmsg = "You are not logged in";

		
		@BeforeClass
		public void Login() throws IOException {
			LoggerLoad.info("Home Page Before class");
			 Home=new HomePage();

		     Home.dsalgoportal();
		     Home.getstarted_btn();
		}
		
		@Test(priority=1)
		public void ClickDSGetStared() {
			LoggerLoad.info("Clicking on Data Structures Get Started");
			Home.getStartedDSintroclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
				
		}
		
		@Test(priority=2)
		public void ClickgetStartedarray() {
			LoggerLoad.info("Clicking on Array Get Started");
			driver.navigate().back();
			Home.getStartedarrayclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
			
		}
		
		@Test(priority=3)
		public void ClickgetStartedlinkedlist() {
			LoggerLoad.info("Clicking on LinkedList Get Started");
			driver.navigate().back();
			Home.getStartedlinkedlistclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
			
		}
		
		@Test(priority=4)
		public void ClickgetStartedstack() {
			LoggerLoad.info("Clicking on Stack Get Started");
			driver.navigate().back();
			Home.getStartedstackclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
		}
		
		@Test(priority=5)
		public void ClickgetStartedQueue() {
			LoggerLoad.info("Clicking on Queue Get Started");
			driver.navigate().back();
			Home.getStartedqueueclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
			
		}
		
		@Test(priority=6)
		public void ClickgetStartedGraph() {
			LoggerLoad.info("Clicking on Graph Get Started");
			driver.navigate().back();
			Home.getStartedgraphclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
			
		}
		
		@Test(priority=7)
		public void ClickgetStartedTree() {
			LoggerLoad.info("Clicking on Tree Get Started");
			driver.navigate().back();
			Home.getStartedtreeclick();
			String alert =Home.getAlert();
			assertEquals(alert,alertmsg);
			
		}
		
			
	}
