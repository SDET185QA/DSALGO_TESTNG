package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.DriverFactory;
import utilities.LoggerLoad;



public class LoginPage {
	WebDriver driver = DriverFactory.getDriver();

		@FindBy(xpath = "//button[@class='btn']")
		WebElement getStarted;
		
		@FindBy(linkText = "Sign in")
	    private WebElement signIn;
		
		@FindBy(id = "id_username")
	    private WebElement usernameField;
		
		@FindBy(id = "id_password")
	    private WebElement passwordField;
		
		@FindBy(xpath = "//input[contains(@value,'Login')]")
	    private WebElement loginButton;
		
		@FindBy(xpath = "//a[@href='/logout']")
	    private WebElement signoutButton;
		
		@FindBy(xpath = "//div[@class='alert alert-primary']")
	    private WebElement logoutalert;
		
		
		@FindBy(xpath = "//a[@href='data-structures-introduction']")
	    private WebElement getStartedDataStructures;
		
		@FindBy(xpath = "//a[@href='array']")
	    private WebElement getStartedArray;
		
		@FindBy(xpath = "//a[@href='linked-list']")
	    private WebElement getStartedLinkedList;
		
		@FindBy(xpath = "//a[@href='stack']")
	    private WebElement getStartedStack;
		
		
		@FindBy(xpath = "//a[@href='queue']")
	    private WebElement getStartedQueue;
		
		
		@FindBy(xpath = "//a[@href='tree']")
	    private WebElement getStartedTree;
		
		@FindBy(xpath = "//a[@href='graph']")
	    private WebElement getStartedGraph;
		
		// Constructor to initialize the page object with the WebDriver instance
		public LoginPage() {
			
			// Use the PageFactory.initElements method to initialize the elements on the login page
			PageFactory.initElements(driver, this);
		}

		
		public void clickOnGetstarted() {
			LoggerLoad.info("Clicking in Get started Button " );
		    getStarted.click();
			
		}
		
		
		public void clickOnSignin() {
			LoggerLoad.info("Clicking in Signin Button " );
			signIn.click();
		}
		
		public String getTitleHomePage(String expectedTitle) {
			LoggerLoad.info("Getting the page Title " );
			String actualTitle = driver.getTitle();
			LoggerLoad.info(actualTitle);
			return actualTitle;
		}
		
		public void clickonLogin() {
			LoggerLoad.info("Clicking in Login Button " );
			loginButton.click();
					
				}
				
	   public String validate_login_with_blank_credentials(String validationMessage,String field) {
			LoggerLoad.info("Expected error message is   "+ validationMessage );
			String message1 = null;
			if (field.equalsIgnoreCase("username")) {
					@SuppressWarnings("deprecation")
					String message = usernameField.getAttribute("validationMessage");
					message1 =message;	

					} else if (field.equalsIgnoreCase("password")) {
						@SuppressWarnings("deprecation")
						String message = passwordField.getAttribute("validationMessage");
						message1 =message;		
					}
					
					return message1;
							
				}
				
		public void enter_user_name(String username) {
			  LoggerLoad.info("Clearing the username fields");
			  usernameField.clear();
			  LoggerLoad.info("Entering the  User Name  "+ username );
			  usernameField.sendKeys(username);	
				}
				
	   public void enter_user_password(String password) {
			  LoggerLoad.info("Clearing the username fields");
			  passwordField.clear();
			  LoggerLoad.info("Entering the  User Name  "+ password );
			  passwordField.sendKeys(password);	
				}
				
	  public void enter_login_credentails(String username, String password ) {
		    LoggerLoad.info("Clearing the username fields");
			usernameField.clear();
			LoggerLoad.info("Entering the  User Name  "+ username );
			usernameField.sendKeys(username);
			LoggerLoad.info("Clearing the password fields");
			passwordField.clear();
			LoggerLoad.info("Entering the  Password "+ password );
			passwordField.sendKeys(password);
							
					
				}
	  public void clickOnGetstartedDataStructures() {
			LoggerLoad.info("Clicking on Datastructures-Introduction getstarted");
			getStartedDataStructures.click();
					
				}
	  public void clickonLogout() {
			LoggerLoad.info("Clicking in Signout Button " );
			signoutButton.click();
			}
				
	   public String getlogoutAlert(String expectedLogoutMessage) {
		   LoggerLoad.info("Getting Alert Message" );
		   String logoutMessage = logoutalert.getText();
		   LoggerLoad.info(logoutMessage);
		   return logoutMessage;
		   }
				
       public void clickOnGetstartedArray() {
    	   LoggerLoad.info("Clicking on Array Getstarted" );		
    	   getStartedArray.click();
    	   }
       public void clickOnGetstartedLinkedList() {
    	   LoggerLoad.info("Clicking on Linked List Getstarted" );	
    	   getStartedLinkedList.click();
    	   }
       public void clickOnGetstartedStack() {
    	   LoggerLoad.info("Clicking on Linked List Getstarted" );	
    	   getStartedStack.click();
    	   }
       public void clickOnGetstartedQueue() {
	
    	   LoggerLoad.info("Clicking on Queue Getstarted" );	
    	   getStartedQueue.click();
    	   }
       public void clickOnGetstartedTree() {
    	   LoggerLoad.info("Clicking on Tree  Getstarted" );	
    	   getStartedTree.click();
    	   }

       public void clickOnGetstartedGraph() {
    	   LoggerLoad.info("Clicking on Graph  Getstarted" );	
    	   getStartedGraph.click();
					
				}

}
