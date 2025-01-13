package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import driver.DriverFactory;

import utilities.LoggerLoad;
import utilities.Utility_Methods;



public class ArrayPage {
	
	WebDriver driver = DriverFactory.getDriver();
	Utility_Methods util=new Utility_Methods();
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement getStarted;
	
	@FindBy(xpath = "//div[@id='navbarCollapse']//a[contains(text(), 'Data Structures')]")
    private WebElement dropdownoption;
	@FindBy(xpath = "//a[@class='dropdown-item'][@href='/array']")
    private WebElement arraydropdown;
	
	
	@FindBy(xpath = "//a[@href='array']")
    private WebElement arrayGetStarted;
	@FindBy(xpath="//a[@href='arrays-in-python']")
    private WebElement arraysInPython;
	
	
	@FindBy(xpath="//a[@href='/tryEditor']")
    private WebElement tryHereLink;

	
	@FindBy(xpath="//a[@href='/array/practice']")
    private WebElement PraciceQuestionsButton;
	
	
	@FindBy(xpath="//a[@href='/question/1']")
    private WebElement searchTheArrayButton;
	
	@FindBy(xpath="//a[@href='/question/2']")
    private WebElement maxConsecutiveOnesButton;
	
	@FindBy(xpath="//a[@href='/question/3']")
    private WebElement findNumbersWithEvenDigit;
	
	@FindBy(xpath="//a[@href='/question/4']")
    private WebElement sqauresOfSortedArray;
	
	@FindBy(xpath="//a[@href='arrays-using-list']")
    private WebElement arraysUsingList;
	
	@FindBy(xpath="//a[@href='basic-operations-in-lists']")
    private WebElement basicOperationList;
	
	@FindBy (xpath="//form/div/div/div/textarea")
	private WebElement editorInput;
	
	@FindBy (id="answer_form")
	private WebElement answerform;
	
	@FindBy (xpath="//button[text()='Run']") 
	private WebElement runButton;
	
	@FindBy (xpath="//pre[@id='output']") 
	private WebElement output;
	
	
	@FindBy (xpath="//input[@value='Submit']") 
	private WebElement submitButton;
	
	
	@FindBy (xpath="//a[text()='Find Numbers with Even Number of Digits']") 
	private WebElement findNumbersWithEvenNumberOfDigitsLink;
	
	@FindBy (xpath="//a[text()='Squares of  a Sorted Array']") 
	private WebElement squaresOfASortedArrayLink;
	
	@FindBy (xpath ="//a[@href ='applications-of-array']") 
	private WebElement applicationsOfArray;
	
	@FindBy (id = "output")
	private WebElement Codeoutput;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']")
	private WebElement CodeEditor;
	
	@FindBy (xpath = "//textarea[@tabindex='0']")
	private WebElement Question_Input;
	
	
	@FindBy (xpath = "//a[text()='Sign out']")
	private WebElement signOutbtn;

	
	public ArrayPage() {
		
		// Use the PageFactory.initElements method to initialize the elements on the array page
		PageFactory.initElements(driver, this);
	
	}
	
	
	public void clickOnGetstarted() {
		LoggerLoad.info("Clicking on getstarted");
	    getStarted.click();
		
	}
	public void dropDownClick() {
		LoggerLoad.info("Clicking on dropdown option");
		dropdownoption.click();
		
	}
	
	public void arrayDropClick() {
		LoggerLoad.info("Clicking on array dropdown option");
		arraydropdown.click();
	}
	public String getpageTitle() {
		String actualPageTitle = driver.getTitle();
		LoggerLoad.info("The tile of array page is "+ actualPageTitle);
		
		return actualPageTitle;
		
		}
	public void clickOnarraysInPython() {
		LoggerLoad.info("click " + arraysInPython.getText() + " On array page");
		arraysInPython.click();
		}
	
	public void clickOnarrayGetStarted() {
		LoggerLoad.info("click " + arrayGetStarted.getText() + " On array page");
		
		arrayGetStarted.click();
		}
	
	public void clickOnTryHere() {
		LoggerLoad.info("click on Try here On array in python  page");
		
		tryHereLink.click();
		}
	

	
	public void clickOnPraciceQuestions() {
		LoggerLoad.info("click on Practice Questions On array in python  page");
		
		PraciceQuestionsButton.click();
		}
	
	public void clickOnsearchTheArrays() {
		LoggerLoad.info("click on Search the Array On array in python practice  page");
		
		searchTheArrayButton.click();
		}
	
	public void clickOnmaxConsecutiveOnesButtons() {
		LoggerLoad.info("click on Maximum Consecutive ones  On array in python practice  page");
		
		maxConsecutiveOnesButton.click();
		}
	
	public void clickOnfindNumbersWithEvenDigitsButtons() {
		LoggerLoad.info("click onFind Numbers with Even Number digits On array in python practice  page");
		
		findNumbersWithEvenDigit.click();
		}
	
	public void clickOnSquaresOfSortedArrayButtons() {
		LoggerLoad.info("click on Squares of a sorted array On array in python practice  page");
		
		sqauresOfSortedArray.click();
		}
	
	
	public void clickOnarraysUsingList() {
		LoggerLoad.info("click " + arraysUsingList.getText() + " On array page");
		arraysUsingList.click();
		}
	public void basicOperationList() {
		LoggerLoad.info("click " + basicOperationList.getText() + " On array page");
		basicOperationList.click();
		}
	
	
	public void fetchPythonCode(String PythonCode) {
        System.out.println("Editor Input: "+editorInput);
        util.waitForElement(answerform);
        answerform.click();
        editorInput.sendKeys(PythonCode);
    }
	public void clickRunButton() {
		LoggerLoad.info("Click on the run button");
		runButton.click();
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
	

	
	public String getActualResult()
    {
		
		util.waitForElement(output);
        return output.getText();
    }
	
	public void clickSubmitButton()
    {
		LoggerLoad.info("The Click on submit button");
        submitButton.click();
    }
	
	
	public void clickFindNumbersWithEvenNumberOfDigitsLink()
    {
		LoggerLoad.info("The Click on find number with even numbers of digit link");
        findNumbersWithEvenNumberOfDigitsLink.click();
      
    }
	
	public void clickSquaresOfASortedArrayLink()
    {
		LoggerLoad.info("The Click on Squares of a sorted array link");
        squaresOfASortedArrayLink.click();
    }
	
	public void click_arrayOptions(String arrayOptions) {
		LoggerLoad.info(arrayOptions);
		switch(arrayOptions) {
		case "Arrays in Python":
			arraysInPython.click();break;
		case "Arrays Using List":
			arraysUsingList.click();break;
		case "Basic Operations in Lists":
			basicOperationList.click();break;
		case "Applications of Array":
			applicationsOfArray.click();break;
		case "Practice Questions":
			PraciceQuestionsButton.click();break;
		default:
			break;
			}
		}
	
	public String getEditorOutput() {
		return Codeoutput.getText();
	}
	
	public void enterCode(String code) {
        new Actions(driver).sendKeys(CodeEditor, code).perform();
	}
	
	public void enterPythonCodePractice(String sheetname, int rownumber) throws InvalidFormatException, IOException, InterruptedException {
		String code = util.getCodefromExcel(sheetname, rownumber);
		util.enterPythonCodeForPractice(code, Question_Input);
	}
	
	public String getQtnOutPut(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		String result = util.getResultfromExcel(sheetname, rownumber);
		return result;
	}
	
	public void arrayTopics(int index){
		List<WebElement> Topic =driver.findElements(By.className("list-group-item"));
		Topic.get(index).click();
		String arraytTopic=driver.getTitle();
		System.out.println("We are in "+arraytTopic);
	}
	
	public String ArrayPageURL() {

		return driver.getCurrentUrl();
	}
	
	public void backToArray() {
		dropdownoption.click();
		arraydropdown.click();
			
	}
	
	public void signout() {
		signOutbtn.click();

	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	
	
}
