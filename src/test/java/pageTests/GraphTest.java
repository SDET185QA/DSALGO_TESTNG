package pageTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.GraphPage;
import utilities.LoggerLoad;

public class GraphTest extends BaseClass{
	
	WebDriver driver;
	GraphPage Graph;
	
  @BeforeClass
  public void login() throws IOException {
	  LoggerLoad.info("Graph page Before class");
	  Graph= new GraphPage();
	  loginToPortal();
  }
  
  @BeforeMethod
  public void GraphPage() {
	  LoggerLoad.info("Clicking on Graph dropdown");
	  Graph.Dropdown();
	  Graph.GraphDropdown();
  }
 
  @Test(priority=1)
  public void GraphHome() {
	  LoggerLoad.info("Clicking on the Graph Home link");
	  Graph.GraphHomeLink();
  }
  
  @Test(priority=2)
  public void Graph() {
	  LoggerLoad.info("Clicking on the Graph link");
	  Graph.GraphLink();
  }
  @Test(priority=3)
  public void GraphRepresentation() {
	  LoggerLoad.info("Clicking on the Graph Representation");
	  Graph.GraphRepresentationLink();
	 
  }
  @Test(priority=4)
  public void PracticeQuestion() {
	  LoggerLoad.info("Clicking on the Practice Question");
	  Graph.GraphRepresentationLink();
	  Graph.clickPracticeQuestions();
  }
  @Test(dataProvider = "Graph Valid Input", dataProviderClass = DataProviderClass.class,priority=5)
  public void ValidInput(String InputCode, String expectedResult) {
	  LoggerLoad.info("Enter a valid input");
	  Graph.GraphRepresentationLink();
	  Graph.clickTry();
	  Graph.enterCode(InputCode);
	  Graph.Runbtn();
      String actualResult = Graph.getEditorOutput();
	  Graph.navigateBack();
	  LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
	  Assert.assertEquals(expectedResult,actualResult );
	  LoggerLoad.info("Completed Testing  Try editor with Valid python code ");
	   }
  @Test(dataProvider = "Graph Invalid Input", dataProviderClass = DataProviderClass.class,priority=6)
  public void InValidInput(String InputCode, String expectedError) {
	  LoggerLoad.info("Enter a Invalid input");
	  Graph.GraphLink();
	  Graph.clickTry();
	  Graph.enterCode(InputCode);
	  Graph.Runbtn();
	  String actualerror1 = Graph.fetchErrorMessage();
	  Graph.navigateBack();
	  LoggerLoad.info("The expected result is"+expectedError+"the actual result is"+ actualerror1);
	  Assert.assertEquals(expectedError,actualerror1 );
	  LoggerLoad.info("Completed Testing  Try editor with InValid python code ");
	   }
  @AfterMethod()
	public void backtoGraph(){
		LoggerLoad.info("Graph module AfterMethod");
		Graph.backToGraph();
		
	}
	@AfterClass
	public void Logout() {
		LoggerLoad.info("Queue module AfterClass");
		Graph.signout();
		
	}
	

}
