package pageTests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.TreePage;
import utilities.LoggerLoad;

public class TreeTest extends BaseClass{

	TreePage Tree;
	@BeforeClass
	public void login() throws IOException {
		LoggerLoad.info("Tree page Before method");
		Tree= new TreePage();
		loginToPortal();
		
	}
	@BeforeMethod
	public void TreePage() {
		LoggerLoad.info("Clicking on the Tree page");
		Tree.dropDownClick();
		Tree.TreeDropClick();
	}
	@Test
	public void OverofTree() {
		LoggerLoad.info("clicking on the Overview of Tree");
		Tree.ClickOverview();
	}
	@Test
	public void Terminologies() {
		LoggerLoad.info("Clicking on the Terminologies");
		Tree.ClickTerminology();
	}
	@Test
	public void TypesofTrees() {
		LoggerLoad.info("Clicking on the Types of Trees");
		Tree.ClickTypesOFTree();
	}
	@Test
	public void TreeTraversals() {
		LoggerLoad.info("Clicking on the Tree Traversals");
		Tree.ClickBTTraverse();
	}
	@Test
	public void TraverselsIllustrations() {
		LoggerLoad.info("Clicking on the Traversels Illustrations");
		Tree.ClickTraveIllustrate();
	}
	@Test
	public void BinaryTrees() {
		LoggerLoad.info("Clicking on the Binary Trees");
		Tree.ClickBinaryTree();
	}
	@Test
	public void TypesOfBinaryTrees() {
		LoggerLoad.info("Clicking on the Types Of BinaryTrees");
		Tree.ClickTypesOfBinary();
	}
	@Test
	public void ImplementationsOfPython() {
		LoggerLoad.info("Clicking on the Implementations Of Python");
		Tree.ClickImplementPython();
	}
	@Test
	public void BinaryTreeTraversals() {
		LoggerLoad.info("Clicking on the Binary Tree Traversals");
		Tree.ClickBTTraverse();
	}
	@Test
	public void ImplementationOfBinaryTrees() {
		LoggerLoad.info("Clicking on the Implementation Of BinaryTrees");
		Tree.ClickImplementBT();
	}
	@Test
	public void ApplicationOfBinaryTrees() {
		LoggerLoad.info("Clicking on the Application Of BinaryTrees");
		Tree.ClickAppsOfBT();
	}
	@Test
	public void BinarySearchTrees() {
		LoggerLoad.info("Clicking on the Binary Search Trees");
		Tree.ClickBinarySearchTree();
	}
	@Test
	public void ImplementationofBST() {
		LoggerLoad.info("Clicking on the Implementation of BST");
		Tree.ClickImplementBST();
	}
	@Test
	public void PracticeQuestions() {
		LoggerLoad.info("Clicking on the Practice Questions");
		Tree.ClickImplementBST();
		Tree.ClickPractQuesLink();
	}
	
	@Test( dataProvider = "Valid Input",dataProviderClass = DataProviderClass.class,priority=7)
	public void ValidInput(String inputCode, String expectedResult) throws InterruptedException {
		LoggerLoad.info("Enter a valid input");
		Tree.ClickImplementBST();
		Tree.ClickTryhereLink();
		Tree.enterCode(inputCode);
		Tree.clickRunBtn();
		String actualResult = Tree.getOutput();
		Tree.navigateBack();
		LoggerLoad.info("The expected result is"+expectedResult+"the actual result is"+ actualResult);
		Assert.assertEquals(expectedResult,actualResult );
		LoggerLoad.info("Completed Testing  Try editor with Valid python code ");
	}	
	@Test(dataProvider = "Invalid Input", dataProviderClass = DataProviderClass.class,priority=4)
	public void InvalidInput(String input,String expectedError) throws InvalidFormatException, IOException, InterruptedException {
		LoggerLoad.info("Enter a valid input");
		Tree.ClickImplementBST();
		Tree.ClickTryhereLink();
		Tree.enterCode(input);
		Tree.clickRunBtn();
		String actualerror = Tree.fetchErrorMessage();
		Tree.navigateBack();
		LoggerLoad.info("The expected result is"+expectedError+"the actual error is"+ actualerror);
		Assert.assertEquals(expectedError, actualerror);
		LoggerLoad.info("Completed Testing Try editor with Invalid Valid python code ");
		
	}	
	@AfterMethod
	public void BacktoTree() {
		LoggerLoad.info("Back to Tree page");
		Tree.Backtotree();
		
	}
	@AfterClass
	public void logout() {
		LoggerLoad.info("Logging out from the portal");
		Tree.signout();
	}
	
	

}