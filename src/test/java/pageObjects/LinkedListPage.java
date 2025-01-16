package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedListPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//a[@href=\"introduction\"]")
//	@FindBy(xpath="//a[@href=\"/linked-list/introduction/\"]")
	WebElement introLink;  // Click on Intro link
	
	@FindBy (xpath = "//a[@href=\"creating-linked-list\"]")
	WebElement createLinkedListLink;  //Click on create linked list
	
	@FindBy (xpath = "//a[@href=\"types-of-linked-list\"]")
	WebElement typesOfLinkedList;  //Click on types of linked list
	
	@FindBy (xpath = "//a[@href=\"implement-linked-list-in-python\"]")
	WebElement implementLinkedListInPython;	//Click on implement linked list in python
	
	@FindBy (xpath = "//a[@href=\"traversal\"]")
	WebElement traversal;	//Click on traversal
	
	@FindBy (xpath = "//a[@href=\"insertion-in-linked-list\"]")
	WebElement insertionInLinkedList;	//Click on insertion in linked list
	
	@FindBy (xpath = "//a[@href=\"deletion-in-linked-list\"]")
	WebElement deletionInLinkedList;	//Click on deletion in Linked List
	
	@FindBy(xpath = "//a[@href=\"/linked-list/practice\"]")
	WebElement practiceQns;		//Click on practice questions
	
//	@FindBy (xpath = "//form/button")
//	WebElement runBtn; 		// Run button on try editor
	
	@FindBy (xpath = "//div[@class=\"dropdown-menu show\"]")
	WebElement dropDownMneu; 	//Click on drop down menu
	
	@FindBy (xpath = "//div[@class=\"dropdown-menu show\"]/a[@href=\"/linked-list\"]")
	WebElement linkedListDropdownSelect;	//Selecting linked list from drop down menu
	
	
	public void navigateToLinkedListPage(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver,this);
		}
	
	public void clickOnIntro() {
		introLink.click();
	}

	public void clickOnCreatingLinkedList() {
		createLinkedListLink.click();
	}
	
	public void clickOnTypesOfLinkedList() {
		typesOfLinkedList.click();
	}

	public void implementLinkedListInPython() {
		implementLinkedListInPython.click();
	}
	
	public void traversal() {
		traversal.click();
	}
	
	public void insertion() {
		insertionInLinkedList.click();
	}
	
	public void deletion() {
		deletionInLinkedList.click();
	}
	
	public void practiceQns() {
		practiceQns.click();
	}
	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public  void selectLinkedList() {
		dropDownMneu.click();
		linkedListDropdownSelect.click();
	}

	public String getMsg() {
		String msg = driver.switchTo().alert().getText();
		return msg;
	}
   public void openSubPage(String subPage) {
	   switch (subPage) {
	   		case "Introduction":
	   			introLink.click();
	   		break;
	   		case "Creating Linked LIst":
	   			createLinkedListLink.click();
	   		break;
	   		case "Types of Linked List":
	   			typesOfLinkedList.click();
	   		break;
	   		case "Implement Linked List in Python":
	   			implementLinkedListInPython.click();
	   		break;
	   		case "Traversal":
	   			traversal.click();
	   		break;
	   		case "Insertion":
	   			insertionInLinkedList.click();
	   		break;
	   		case "Deletion":
	   			deletionInLinkedList.click();
	   		break;
	   }
   }

   public void tryHereOnSubPage() {
	   driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//a[@href=\"/tryEditor\"]")).click();
   }

 
}
