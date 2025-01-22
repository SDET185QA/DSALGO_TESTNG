package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ConfigReader;
import utilities.LoggerLoad;
import utilities.Utility_Methods;
import driver.DriverFactory;

public class GraphPage {
	WebDriver driver = DriverFactory.getDriver();
     Utility_Methods util=new Utility_Methods();

	
	//Constructor
	public GraphPage(){
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	//Locators
	
	    @FindBy(xpath="//a[@href ='graph']")
	    public WebElement getStarted_btn;
	    
	    @FindBy(xpath = "//div[@id='navbarCollapse']//a[contains(text(), 'Data Structures')]")
	    private WebElement dropdownoption;
	    
	    @FindBy(xpath = "//a[@class='dropdown-item'][@href='/graph']")
	    private WebElement graphdropdown;
	
        @FindBy(xpath="//a[@href='graph']")//Graph Page
        private WebElement Graph_home_link;
	
        @FindBy(xpath="//a[@href='graph']")
        private WebElement Graph_link;
    
	    @FindBy(xpath="//a[text()='Try here>>>']")
        private WebElement Try;
	    
	    @FindBy (xpath = "//div[@class = 'CodeMirror-scroll']")
		private WebElement CodeEditor;
		
		@FindBy (xpath="//form/div/div/div/textarea")
		private WebElement editorInput;
		
		@FindBy (id="answer_form")
		private WebElement answerform;
		
		@FindBy(xpath="//button[text()='Run']")
	    private WebElement  Run_btn;
		
		@FindBy (xpath="//pre[@id='output']") 
		private WebElement output;
		
		@FindBy (id = "output")
	    private WebElement Codeoutput;
		
	
	    @FindBy(xpath="//a[text()='Graph Representations']")//Graph Representation
        private WebElement Graph_Representation_link;
	
        @FindBy(xpath="//a[text()='Practice Questions']")//Practice Questions
        private WebElement Practice_Questions;
        
        @FindBy (xpath = "//a[text()='Sign out']")
		private WebElement signOutbtn;
	
    
  //Actions	
  		public void getStarted() 
  		{
  		getStarted_btn.click();
  		}
  		
  		public void Dropdown() {
  			LoggerLoad.info("Clicking on dropdown option");
  			dropdownoption.click();
  		}
  		public void GraphDropdown() {
  			LoggerLoad.info("Clicking on graphdropdown option");
  			graphdropdown.click();
  		}
  		
  		public String getpageTitle() {
			String actualPageTitle = driver.getTitle();
			LoggerLoad.info("The tile of Queue page is "+ actualPageTitle);
			return actualPageTitle;
		}


  		public void GraphHomeLink() {
  		LoggerLoad.info("Clicking on graph home link");
  		Graph_home_link.click();
  	    }
  		public void GraphLink() {
  			LoggerLoad.info("Clicking on graph link");
  	  		Graph_link.click();
  	  	    }
  		public void clickTry() {
  			LoggerLoad.info("Clicking on Tryhere");
  			Try.click();
  		}
  		public void Runbtn() {
  			LoggerLoad.info("Clicking on Run button");
  			Run_btn.click();
  		}
  		
  		public void GraphRepresentationLink() {
  			LoggerLoad.info("Clicking on graph representation link");
  			Graph_Representation_link.click();
  		}
  		public void clickPracticeQuestions() {
  			LoggerLoad.info("Clicking on practice Question");
			Practice_Questions.click();
			
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
  	        util.waitForElement(Codeoutput);
  	        LoggerLoad.info("Click on the OK button for the error pop up ");
  	        String Result = Codeoutput.getText();
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
  		public void backToGraph() {
 			Dropdown();
 			GraphDropdown();
 	
 				
 		}
 		
 		public void navigateBack() {
 			driver.navigate().back();
 		}

		public void signout() {
			signOutbtn.click();

		}

  		

		

}
