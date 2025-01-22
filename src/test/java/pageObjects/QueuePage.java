package pageObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.LoggerLoad;
import utilities.Utility_Methods;

public class QueuePage {
	WebDriver driver = DriverFactory.getDriver();
	 Utility_Methods util=new Utility_Methods();
	
	
public QueuePage() {
	// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);
}


		@FindBy(xpath="//a[@href='queue']")
		public WebElement getStarted;
		
		@FindBy(xpath = "//div[@id='navbarCollapse']//a[contains(text(), 'Data Structures')]")
	    private WebElement dropdownoption;
		
		@FindBy(xpath = "//a[@class='dropdown-item'][@href='/queue']")
	    private WebElement queuedropdown;
		
	    @FindBy(xpath="//a[text()='Implementation of Queue in Python']")//Implementation of Queue Page
	    private WebElement Implementation_of_queue;
		
		@FindBy(xpath="//a[text()='Try here>>>']")
	    private WebElement Try;
						
	    @FindBy (xpath="//form/div/div/div/textarea")
		private WebElement editorInput;
				
		@FindBy (id="answer_form")
		private WebElement answerform;
				
		@FindBy(xpath="//button[text()='Run']")
	    private WebElement  Run_btn_Queue;
				
		@FindBy (xpath="//pre[@id='output']") 
		private WebElement output;
			
		@FindBy(xpath="//a[text()='Implementation using collections.deque']")//Implementation Using collections dequeue
	    private WebElement Implementation_Using_Collections_deque;
				
		@FindBy(xpath="//a[text()='Implementation using array']")//Implementation Using Array
	    private WebElement Implementation_Using_Array;

		@FindBy(xpath="//a[text()='Queue Operations']")//Queue Operations
	    private WebElement Queue_Operations;
		
	    @FindBy(xpath="//a[text()='Try here>>>']")
       private WebElement Try_QueueOperations;
	    
	    @FindBy (xpath = "//div[@class = 'CodeMirror-scroll']")
		private WebElement CodeEditor;
	    
	    @FindBy (id = "output")
		private WebElement Codeoutput;
		
		@FindBy(xpath="//a[text()='Practice Questions']")//Practice Questions
	    private WebElement Practice_Questions;
		
		@FindBy(xpath="//a[text()='Try here>>>']")
	    private WebElement Try_PracticeQuestions;
		
		@FindBy (xpath = "//a[text()='Sign out']")
		private WebElement signOutbtn;

	//Action methods to perform on the elements	
		public void getStarted_Q() 
		{
		getStarted.click();
		}
		public void dropDownClick() {
			LoggerLoad.info("Clicking on dropdown option");
			dropdownoption.click();
			
		}
		
		public void queueDropClick() {
			LoggerLoad.info("Clicking on Queue dropdown option");
			queuedropdown.click();
		}
		
		
		public String getpageTitle() {
			String actualPageTitle = driver.getTitle();
			LoggerLoad.info("The tile of Queue page is "+ actualPageTitle);
			return actualPageTitle;
		}

		public void ImplementationofQueueinPythonLink() {
			Implementation_of_queue.click();
	}
		public void clickTry() {
			Try.click();
		}
		public void Run_btn_Queue() {
			Run_btn_Queue.click();
		}
		
		
		public void ImplementationUsingCollectiondeQueueLink() {
			Implementation_Using_Collections_deque.click();
		}
		
		public void ImplementationUsingArray() {
			Implementation_Using_Array.click();
		}
		
		public void QueueOperations() {
		Queue_Operations.click();
	    }
	    public void TryQueueOperations() {
			Try_QueueOperations.click();
	    }
		public void clickPracticeQuestions() {
			Practice_Questions.click();
		}
		public void clickTryPracticeQuestions() {
			Try_PracticeQuestions.click();
		}
		public void enterCode(String inputCode) {
	        new Actions(driver).sendKeys(CodeEditor, inputCode).perform();
		}
		
		public String getEditorOutput() {
			return Codeoutput.getText();
		}
		
 		public void fetchPythonCode(String PythonCode) {
 	        System.out.println("Editor Input: "+editorInput);
 	        util.waitForElement(answerform);
 	        answerform.click();
 	        editorInput.sendKeys(PythonCode);
 	        
 	    }
 		public String fetchOutput()
 	    {
 	        util.waitForElement(output);
 	        LoggerLoad.info("Click on the OK button for the error pop up ");
 	        String Result = output.getText();
 	        return Result;
 	        
 	    }
 		
 		public String fetchErrorMessage()
 	    {
 			LoggerLoad.info("Get the error message pop up for the invalid python code ");
 	        String errorMessage=driver.switchTo().alert().getText();
 	        LoggerLoad.info("Click on the OK button for the error pop up ");
 	        driver.switchTo().alert().accept();
 	        return errorMessage;
 	    }
 		
 		public void backToQueue() {
 			dropDownClick();
 			queueDropClick();
 	
 				
 		}
 		
 		public void navigateBack() {
 			driver.navigate().back();
 		}

 		public void signout() {
			signOutbtn.click();

		}
			
		
}



