package pageTests;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.ArrayPage;
import utilities.ConfigReader;
import utilities.LoggerLoad;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ArrayTest extends BaseClass{
	ArrayPage array;
	ConfigReader configReader = new ConfigReader();
	
	@BeforeClass
	public void loginIn() throws IOException {
		LoggerLoad.info("Array module Beforeclass");
		array = new ArrayPage();
		loginToPortal();
	}
	
	@BeforeMethod()
	public void arrayPage(){	
		LoggerLoad.info("Array module BeforeMethod");
		array.dropDownClick();	
		array.arrayDropClick();	
	}
	@Test(priority = 1)
	public void testHomePage() {
		LoggerLoad.info("Testing Array Home Page");
		Assert.assertTrue(driver.getTitle().contains("Array"));
		LoggerLoad.info("Completed Testing Array Home Page");
	}
	@Test(dataProvider = "Array Topics", dataProviderClass = DataProviderClass.class,priority = 2)
	public void testArrayTopics(int arrayTopicIndex,String pageTitle,String tryEditorPageTitle) {
		
		LoggerLoad.info("Testing Array Topics Page");
		array.arrayTopics(arrayTopicIndex);
		String actualPageTitle = array.getpageTitle();
		String expectedPageTitle = pageTitle;
		LoggerLoad.info("Test Array Topics actual page title is "+actualPageTitle +"and the expected page title is"+expectedPageTitle);
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		LoggerLoad.info("Completed Testing Array Topics Page");
		
	}
	@Test(dataProvider = "Array Topics", dataProviderClass = DataProviderClass.class,priority = 3)
	public void testArrayTopicsTryEditor(int arrayTopicIncex,String pageTitle,String tryEditorPageTitle) {
		LoggerLoad.info("Testing Array Topics Try editor with run and submit button ");
		array.arrayTopics(arrayTopicIncex);
		array.clickOnTryHere();
		String actualPageTitle = array.getpageTitle();
		array.navigateBack();
		String expectedPageTitle = tryEditorPageTitle;
		LoggerLoad.info("Test Array Topics Try editor actual page title is "+actualPageTitle +"and the expected page title is"+expectedPageTitle);
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		LoggerLoad.info("Completed Testing Array Topics Try editor with run and submit button ");
		
	}
	
	@Test(dataProvider = "arrayexcel-reader", dataProviderClass = DataProviderClass.class, priority = 4)
	public void testTryEditorWithValidCode(String inputCode, String expectedResult, int arrayTopicIncex) throws InvalidFormatException, IOException {
		LoggerLoad.info("Testing Array Topics Try editor with Valid python code ");
		array.arrayTopics(arrayTopicIncex);
		array.clickOnTryHere();
		array.enterCode(inputCode);
		array.clickRunButton();
		String actualResult = array.getEditorOutput();
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult,actualResult );
		LoggerLoad.info("Completed Testing Array Topics Try editor with Valid python code ");
	}
	
	@Test(dataProvider = "arrayexcel-reader", dataProviderClass = DataProviderClass.class, priority = 5)
	public void testTryEditorWithInvalidCode(String inputCode, String output, int arrayTopicIndex) throws InvalidFormatException, IOException {
		LoggerLoad.info("Testing Array Topics Try editor with Invalid Valid python code ");
		array.arrayTopics(arrayTopicIndex);
		array.clickOnTryHere();
		array.enterCode(inputCode);
		array.clickRunButton();
		String actualerror = array.fetchErrorMessage();
		String expectederror = array.getQtnOutPut("ArrayCode", 1);
		array.navigateBack();
		LoggerLoad.info("The expected error is"+expectederror+"the actual error is"+ actualerror);
		Assert.assertEquals(expectederror, actualerror);
		LoggerLoad.info("Completed Testing Array Topics Try editor with Invalid Valid python code ");
		
	}
	@Test(dataProvider = "Array Topics", dataProviderClass = DataProviderClass.class, priority = 6)
	public void testArrayTryEditorRunEmpty(int arrayTopicIncex,String pageTitle,String tryEditorPageTitle) {
	String  expectedResult = "Please enter code";
	LoggerLoad.info("Testing Array Topics Try editor with no code and clicking on run button ");
	array.arrayTopics(arrayTopicIncex);
	array.clickOnTryHere();
	array.clickRunButton();
	String actualResult = (array.getEditorOutput());
	array.navigateBack();
	LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
	Assert.assertEquals(actualResult,expectedResult);
	LoggerLoad.info("Completed Testing Array Topics Try editor with no code and clicking on run button ");	
	}
	
	@Test(priority = 7)
	public void testSearchTheArrayWithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search The Array with Valid Python Code and click on run");
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnsearchTheArrays();
		array.enterPythonCodePractice("ArrayCode", 2);
		array.clickRunButton();
		System.out.println("print output from excel");
		System.out.println(array.getQtnOutPut("ArrayCode", 2));
		String expectedOutput = array.getQtnOutPut("ArrayCode", 2);
		String actualOutput = array.getActualResult();
		LoggerLoad.info("The expected output is"+expectedOutput+"the actual output is"+ actualOutput);
		Assert.assertEquals(expectedOutput, actualOutput);
		array.navigateBack();
		LoggerLoad.info("Completed Testing Search The Array with Valid Python Code");
					
	}
	
	@Test(priority = 8)
	public void testSearchTheArrayWithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search The Array with Valid Python Code and click on submit");
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnsearchTheArrays();
		array.enterPythonCodePractice("ArrayCode", 3);
		array.clickSubmitButton();
		String actualResult = array.getActualResult();
		array.navigateBack();
		String expectedOutput = array.getQtnOutPut("ArrayCode", 3);
		LoggerLoad.info("The expected output is"+expectedOutput+"the actual output is"+ actualResult);
		Assert.assertEquals(expectedOutput, actualResult);
		LoggerLoad.info("Completed Testing Search The Array with Valid Python Code and click on submit");
	}
	
	@Test(priority = 9)
	public void testSearchTheArrayWithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search The Array with InValid Python Code"); 
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnsearchTheArrays();
		array.enterPythonCodePractice("ArrayCode", 1);
		array.clickRunButton();
		String actualerror = array.fetchErrorMessage();
		String expectederror = array.getQtnOutPut("ArrayCode", 1);
		array.navigateBack();
		LoggerLoad.info("The expected error is"+expectederror+"the actual error is"+ actualerror);
		Assert.assertEquals(expectederror, actualerror);
		LoggerLoad.info("Completed Testing Search The Array with InValid Python Code"); 
		
	}
	
	
	@Test(priority = 10)
	public void testMaxConsectiveOnesWithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search The Maximun Consecutive Ones with Valid Python Code and click on run"); 	
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnmaxConsecutiveOnesButtons();
		array.enterPythonCodePractice("ArrayCode", 4);
		array.clickRunButton();
		String expectedResult = array.getQtnOutPut("ArrayCode", 4);
		String actualResult = array.getActualResult();
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult, actualResult);	
		LoggerLoad.info("Completed Testing Search The Maximun Consecutive Ones with Valid Python Code and click on run"); 
	}
	
	
	@Test(priority = 11)
	public void testMaxConsectiveOnesWithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
			
		LoggerLoad.info("Testing Search The Maximun Consecutive Ones with Valid Python Code and click on submit"); 
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnmaxConsecutiveOnesButtons();
		array.enterPythonCodePractice("ArrayCode", 5);
		array.clickSubmitButton();
		String expectedResult = array.getQtnOutPut("ArrayCode", 5);
		String actualResult = array.getActualResult();
		System.out.println("expected");
		System.out.println(expectedResult);
		System.out.println("actual");
		System.out.println(actualResult);
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult, actualResult);
		LoggerLoad.info("Testing Search The Maximun Consecutive Ones with Valid Python Code and click on submit"); 
	}
	
	
	@Test(priority = 12)
	public void testMaxConsectiveOnesWithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search The Maximun Consecutive Ones with InValid Python Code ");
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnmaxConsecutiveOnesButtons();
		array.enterPythonCodePractice("ArrayCode", 1);
		array.clickRunButton();
		String actualerror = array.fetchErrorMessage();
		String expectederror = array.getQtnOutPut("ArrayCode", 1);
		array.navigateBack();
		LoggerLoad.info("The expected error is"+expectederror+"the actual error is"+ actualerror);
		Assert.assertEquals(expectederror, actualerror);
		LoggerLoad.info("Completed Testing Search The Maximun Consecutive Ones with InValid Python Code ");
			
	}
	
	@Test(priority = 13)
	public void testFindNumWithEvenDigitsWithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search TFind Numbers with Even Number of Digits with Valid Python Code and click on run ");
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnfindNumbersWithEvenDigitsButtons();
		array.enterPythonCodePractice("ArrayCode", 6);
		array.clickRunButton();
		String expectedResult = array.getQtnOutPut("ArrayCode", 6);
		String actualResult = array.getActualResult();
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult,actualResult );	
		LoggerLoad.info("Completed Testing Search TFind Numbers with Even Number of Digits with Valid Python Code and click on run ");
	}
	@Test(priority = 14)
	public void testFindNumWithEvenDigitsWithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search Find Numbers with Even Number of Digits with Valid Python Code and click on Submit ");	
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnfindNumbersWithEvenDigitsButtons();
		array.enterPythonCodePractice("ArrayCode", 7);
		array.clickSubmitButton();
		String expectedResult = array.getQtnOutPut("ArrayCode", 7);
		String actualResult = array.getActualResult();
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult,actualResult);
		LoggerLoad.info("Completed Testing Search Find Numbers with Even Number of Digits with Valid Python Code and click on Submit ");	
	}
	
	@Test(priority = 15)
	public void testFindNumWithEvenDigitsWithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Search Find Numbers with Even Number of Digits with InValid Python Code ");	    
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnfindNumbersWithEvenDigitsButtons();
		array.enterPythonCodePractice("ArrayCode", 1);
		array.clickRunButton();
		String actualerror = array.fetchErrorMessage();
		String expectederror = array.getQtnOutPut("ArrayCode", 1);
		array.navigateBack();
		LoggerLoad.info("The expected error is"+expectederror+"the actual error is"+ actualerror);
		Assert.assertEquals(expectederror, actualerror);
		LoggerLoad.info("Completed Testing Search Find Numbers with Even Number of Digits with InValid Python Code ");
			
	}
	
	@Test(priority = 16)
	public void testSquaresOfSortedArrayWithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Squares of Sorted Array with Valid Python Code and click run ");   
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnSquaresOfSortedArrayButtons();
		array.enterPythonCodePractice("ArrayCode", 8);
		array.clickRunButton();
		String expectedResult = array.getQtnOutPut("ArrayCode", 8);
		String actualResult = array.getActualResult();
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult, actualResult);	
		LoggerLoad.info("Completed Testing Squares of Sorted Array with Valid Python Code and click run ");   
	}
	
	@Test(priority = 17)
	public void testSquaresOfSortedArrayWithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Squares of Sorted Array with Valid Python Code and click submit ");   
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnSquaresOfSortedArrayButtons();
		array.enterPythonCodePractice("ArrayCode", 9);
		array.clickSubmitButton();
		String expectedResult = array.getQtnOutPut("ArrayCode", 9);
		String actualResult = array.getActualResult();
		array.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult, actualResult);	
		LoggerLoad.info("Completed Testing Squares of Sorted Array with Valid Python Code and click submit "); 
	}
	
	@Test(priority = 18)
	public void testSquaresOfSortedArrayWithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Testing Squares of Sorted Array with InValid Python Code ");   	
		array.clickOnarraysInPython();
		array.clickOnPraciceQuestions();
		array.clickOnSquaresOfSortedArrayButtons();
		array.enterPythonCodePractice("ArrayCode", 1);
		array.clickRunButton();
		String actualerror = array.fetchErrorMessage();
		String expectederror = array.getQtnOutPut("ArrayCode", 1);
		array.navigateBack();
		LoggerLoad.info("The expected error is"+expectederror+"the actual error is"+ actualerror);
		Assert.assertEquals(expectederror, actualerror);
		LoggerLoad.info("Completed Testing Squares of Sorted Array with InValid Python Code ");  
			
	}
	@AfterMethod()
	public void backtoArray(){
		LoggerLoad.info("Array module AfterMethod");
		array.backToArray();
		
	}
	@AfterClass
	public void Logout() {
		LoggerLoad.info("Array module AfterClass");
		array.signout();
		
	}
	

}
