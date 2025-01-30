package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import utilities.Utility_Methods;

public class TreePage {
    WebDriver driver =DriverFactory.getDriver();
    Utility_Methods util=new Utility_Methods();
	
    ConfigReader cr = new ConfigReader();
    @FindBy(xpath = "//div[@id='navbarCollapse']//a[contains(text(), 'Data Structures')]")
    private WebElement dropdownoption;
	@FindBy(xpath = "//a[@class='dropdown-item'][@href='/tree']")
    private WebElement Treedropdown;
    @FindBy(xpath="//div[@class=\"col\"][6]//a") 
    private  WebElement TreeGetStart;
    @FindBy(linkText="Overview of Trees") WebElement OverOfTree;
    @FindBy(linkText="Terminologies") WebElement Terminologies;
    @FindBy(linkText="Types of Trees") WebElement TypesOfTree;
    @FindBy(linkText="Tree Traversals") WebElement TreeTrave;
    @FindBy(linkText="Traversals-Illustration") WebElement TraveIllustrate;
    @FindBy(linkText="Binary Trees") WebElement BinaryTree;
    @FindBy(linkText="Types of Binary Trees") WebElement TypesOfBinary;
    @FindBy(linkText="Implementation in Python") WebElement ImplementPython;
    @FindBy(linkText="Binary Tree Traversals") WebElement BTTraverse;
    @FindBy(linkText="Implementation of Binary Trees") WebElement ImplementBT;
    @FindBy(linkText="Applications of Binary trees") WebElement AppsOfBT;
    @FindBy(linkText="Binary Search Trees") WebElement BST;
    @FindBy(linkText="Implementation Of BST") WebElement ImplementBST;
    @FindBy(xpath="//a[@href='/tryEditor']") WebElement TryhereLink;
    @FindBy (xpath ="//form/div/div/div/textarea") WebElement textEditor;
    @FindBy(xpath ="//button[text()='Run']") WebElement runBtn;
    @FindBy(id="output") WebElement runOutput;
    @FindBy(linkText="Practice Questions") WebElement PQues;
	@FindBy (xpath="//pre[@id='output']") 
	private WebElement output;
	@FindBy (id="answer_form")
	private WebElement answerform;
	@FindBy (xpath="//a[text()='Sign out']")
	private WebElement signout;

    public TreePage() {
        PageFactory.initElements(driver, this);
    }
	public void dropDownClick() {
		
		dropdownoption.click();
		
	}
	
    public void TreeDropClick() {
		
		Treedropdown.click();
	}
    
//    public void  navigateTo(String pagename)
//    {
//        
//		 String treeUrlName= ConfigReader.geturl(pagename);
//	        driver.get(treeUrlName);
//    }
	public String fetchErrorMessage()
    {
		LoggerLoad.info("Get the error message pop up for the invalid python code ");
        String errorMessage=driver.switchTo().alert().getText();
        LoggerLoad.info("Click on the OK button for the error pop up ");
        driver.switchTo().alert().accept();
        return errorMessage;
    }
    
    public void ClickTreeGS() {
        LoggerLoad.info("User Click the tree Get Started Button");
        TreeGetStart.click();
    
    }
	public String getpageTitle() {
		String actualPageTitle = driver.getTitle();
		LoggerLoad.info("The tile of array page is "+ actualPageTitle);
		return actualPageTitle;
		
		}
    public void ClickOverview() {
        LoggerLoad.info("User Clicks on Overview of Tree link");
        OverOfTree.click();
    }
    public void ClickTerminology() {
        LoggerLoad.info("User Clicks on Terminologies link");
        Terminologies.click();
    }
    public void ClickTypesOFTree() {
        LoggerLoad.info("User Clicks on Types of tree link");
        TypesOfTree.click();
    }
    public void ClickTreeTraversal() {
        LoggerLoad.info("User Clicks on  tree traversal link");
        TreeTrave.click();
    }
    public void ClickTraveIllustrate() {
        LoggerLoad.info("User Clicks on  traversal Illustration  link");
        TraveIllustrate.click();
    }
    public void ClickBinaryTree() {
        LoggerLoad.info("User Clicks on  Binary Tree link");
        BinaryTree.click();
    }
    public void ClickTypesOfBinary() {
        LoggerLoad.info("User Clicks on types of Binary tree link");
        TypesOfBinary.click();
    }
    public void ClickImplementPython() {
        LoggerLoad.info("User Clicks on Implementation of Python link");
        ImplementPython.click();
    }
    public void ClickBTTraverse() {
        LoggerLoad.info("User Clicks on Binary tree traversal link");
        BTTraverse.click();
    }
    public void ClickImplementBT() {
        LoggerLoad.info("User Clicks on Implementation of Binary Trees link");
        ImplementBT.click();
    }
    public void ClickAppsOfBT() {
        LoggerLoad.info("User Clicks on Applications of Binary Trees link");
        AppsOfBT.click();
    }
    public void ClickBinarySearchTree() {
        LoggerLoad.info("User Clicks on  Binary Search Trees link");
        BST.click();
    }
    public void ClickImplementBST() {
        LoggerLoad.info("User Clicks on Implementation of Binary Search Trees link");
        ImplementBST.click();
    }
    public void ClickTryhereLink() {
        LoggerLoad.info("User Clicks on Try Here button");
        TryhereLink.click();
    }

    public void enterCode(String pythonCode) throws InterruptedException {
        LoggerLoad.info("User enter the valid print statement");
        textEditor.sendKeys(pythonCode);
    }

    public void clickRunBtn() throws InterruptedException {
        LoggerLoad.info("User Clicked Run button");
       // Thread.sleep(1000);
        runBtn.click();
    }
    public String getOutput() {
        LoggerLoad.info("Output after Run Statement:" +runOutput.getText());
        String Result = runOutput.getText();
        return Result ;
    }
    public String getErrormsg() {
        String errormsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return errormsg;
    }
    public void ClickPractQuesLink() {
        LoggerLoad.info("User Clicks the Practice Questions link");
        PQues.click();
    }
	
//	public void  navigateTo(String pagename)
//    {
//        
//		 String treeUrlName= ConfigReader.geturl(pagename);
//	        LoggerLoad.info(treeUrlName);
//	        LoggerLoad.info("INSIDE POF TREEURL");
//	        //util.driver.get(treeUrlName);  ///commeted to overcome the maven error
//	        driver.get(treeUrlName);
//    }
	public String fetchOutput()
    {
        util.waitForElement(output);
        LoggerLoad.info("Click on the OK button for the error pop up ");
        String Result = output.getText();
        return Result;
        
    }
	public void fetchPythonCode(String PythonCode) {
        System.out.println("Editor Input: "+textEditor);
        util.waitForElement(answerform);
        answerform.click();
        textEditor.sendKeys(PythonCode);
    }
	public void Backtotree() {
		dropdownoption.click();
		Treedropdown.click();
		
	}
	
	public void navigateBack() {
			driver.navigate().back();
		}
	public void signout() {
		LoggerLoad.info("Signing out from the portal");
		signout.click();
		
	}
}