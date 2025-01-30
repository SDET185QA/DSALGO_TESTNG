package pageTests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.DataStructures;
import utilities.LoggerLoad;

public class DataStructuresTest extends BaseClass {
	
	DataStructures DataStructures;
	
	@BeforeClass
	public void Login() throws IOException {
		LoggerLoad.info("Data Structure Page Before class");
		 DataStructures=new DataStructures();
		 loginToPortal();
	}
	
	@Test(priority=1)
	public void DSPage(){
		
		LoggerLoad.info("Clicking on DataStructure");
		DataStructures.getStarted_DS();	
		
		
	}
	@Test(priority=2)
	public void TimeComplexity(){
		
		LoggerLoad.info("Clicking on Timecomplexity");
		DataStructures.clickOnTimeComplexitylink();	
		
		
	}
	
		@Test( dataProvider = "Valid Input",dataProviderClass = DataProviderClass.class,priority=3)
		public void ValidInput(String inputCode, String expectedResult) {
			LoggerLoad.info("Enter a valid input");
			DataStructures.clickOnTryHere();
			DataStructures.enterCode(inputCode);
			DataStructures.clickonRunButton();
			String actualResult = DataStructures.getEditorOutput();
			DataStructures.navigateBack();
			LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
			Assert.assertEquals(expectedResult,actualResult );
			LoggerLoad.info("Completed Testing  Try editor with Valid python code ");
		}		
			

		@Test(dataProvider = "Invalid Input", dataProviderClass = DataProviderClass.class,priority=4)
		public void InvalidInput(String input,String expectedError) throws InvalidFormatException, IOException {
			LoggerLoad.info("Enter a valid input");
			DataStructures.clickOnTryHere();
			DataStructures.enterCode(input);
			DataStructures.clickonRunButton();
			String actualerror = DataStructures.fetchErrorMessage();
			DataStructures.navigateBack();
			LoggerLoad.info("The expected result is"+expectedError+"the actual error is"+ actualerror);
			Assert.assertEquals(expectedError, actualerror);
			LoggerLoad.info("Completed Testing Try editor with Invalid Valid python code ");
			
		}	
		
		@Test(priority=5)
		public void PractiseQuestion(){
			
			LoggerLoad.info("Clicking on Practise Questions");
			DataStructures.navigateBack();
			DataStructures.clickOnTimeComplexitylink();	
			DataStructures.clickOnPracticeQuestion();
			
		}
	
	@AfterClass
	public void Logout() {
		LoggerLoad.info("DataStructures module AfterClass");
		DataStructures.signout();
		
	}

}
