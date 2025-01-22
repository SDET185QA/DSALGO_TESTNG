package pageTests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.QueuePage;
import utilities.LoggerLoad;

public class QueueTest extends BaseClass{
     QueuePage Queue;

	
	@BeforeClass
	public void Login() throws IOException {
		LoggerLoad.info("Queue Page Before class");
		 Queue=new QueuePage();
		loginToPortal();
	}
	
	@BeforeMethod()
	public void queuePage(){
		
		LoggerLoad.info("Clicking on Queue Dropdown");
		Queue.dropDownClick();	
		Queue.queueDropClick();
		
	}
	@Test(priority=1)
	public void Implementation_Of_Queue() {
		LoggerLoad.info("Clicking on Implemention of Queue page");
		Queue.ImplementationofQueueinPythonLink();
		
	}
	@Test(priority=2)
	public void Tryhere() {
		LoggerLoad.info("Clicking on try here");
		Queue.ImplementationofQueueinPythonLink();
		Queue.clickTry();
		driver.navigate().back();
	}

		
	@Test(priority=3)
	public void Implementation_Using_Collections_deque() {
		LoggerLoad.info("Clicking on Implemention Using collections dequeue");
		Queue.ImplementationUsingCollectiondeQueueLink();
			
		}
	@Test(priority=4)
	public void Implementation_Using_Array() {
		LoggerLoad.info("Clicking on Implemention using Array");
		Queue.ImplementationUsingArray();
			
		}
	@Test(priority=5)
	public void Queue_Operations() {
		LoggerLoad.info("Clicking on Queue operations");
		Queue.QueueOperations();
			
		}
	@Test(priority=6)
	public void Practice_Questions() {
		LoggerLoad.info("Clicking on Practice Questions");
	    Queue.QueueOperations();
		Queue.clickPracticeQuestions();
			
		}
	
	@Test( dataProvider = "Valid Input",dataProviderClass = DataProviderClass.class,priority=7)
	public void ValidInput(String inputCode, String expectedResult) {
		LoggerLoad.info("Enter a valid input");
		Queue.ImplementationUsingArray();
		Queue.clickTry();
		Queue.enterCode(inputCode);
		Queue.Run_btn_Queue();
		String actualResult = Queue.getEditorOutput();
		Queue.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult,actualResult );
		LoggerLoad.info("Completed Testing  Try editor with Valid python code ");
	}		
		

	@Test(dataProvider = "Invalid Input", dataProviderClass = DataProviderClass.class,priority=8)
	public void InvalidInput(String input,String expectedError) throws InvalidFormatException, IOException {
		LoggerLoad.info("Enter a Invalid input");
		Queue.ImplementationofQueueinPythonLink();
		Queue.clickTry();
		Queue.enterCode(input);
		Queue.Run_btn_Queue();
		String actualerror = Queue.fetchErrorMessage();
		Queue.navigateBack();
		LoggerLoad.info("The expected result is"+expectedError+"the actual error is"+ actualerror);
		Assert.assertEquals(expectedError, actualerror);
		LoggerLoad.info("Completed Testing Try editor with Invalid Valid python code ");
		
	}
	@AfterMethod()
	public void backtoQueue(){
		LoggerLoad.info("Queue module AfterMethod");
		Queue.backToQueue();
		
	}
	@AfterClass
	public void Logout() {
		LoggerLoad.info("Queue module AfterClass");
		Queue.signout();
		
	}

}
