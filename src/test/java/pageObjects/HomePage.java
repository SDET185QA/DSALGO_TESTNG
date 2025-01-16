package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.LoggerLoad;
import driver.DriverFactory;

public class HomePage {
	
	WebDriver driver = DriverFactory.getDriver();
	String url ="https://dsportalapp.herokuapp.com";
	String homePageurl="https://dsportalapp.herokuapp.com/home";
	
	//Get Started Button
	@FindBy (xpath="//button[@class='btn']")WebElement getStartedbtn;
	
	//alertmessage
	@FindBy(xpath="//div[contains(text(),'You are not logged in')]")WebElement alertMessage;
	
	//Home Page
	@FindBy (xpath = "//a[@href ='data-structures-introduction']")WebElement getStartedDSintro;
	@FindBy (xpath = "//a[@href ='array']")WebElement getStartedarray;
	@FindBy (xpath = "//a[@href ='linked-list']")WebElement getStartedlinkedlist;
	@FindBy (xpath = "//a[@href ='stack']")WebElement getStartedstack;
	@FindBy (xpath = "//a[@href ='tree']")WebElement getStartedtree;
	@FindBy (xpath = "//a[@href ='graph']")WebElement getStartedgraph;
	@FindBy (xpath = "//a[@href ='queue']")WebElement getStartedqueue;
	
	//dropdown
	@FindBy (xpath="//a[@class='nav-link dropdown-toggle']")WebElement dsDropdown;
	@FindBy (xpath="//div[@class='dropdown-menu show']/a[1]")WebElement dropDownarray;
	@FindBy (xpath="//div[@class='dropdown-menu show']/a[2]")WebElement dropDownlinkedlist;
	@FindBy (xpath="//div[@class='dropdown-menu show']/a[3]")WebElement dropDownstack;
	@FindBy (xpath="//div[@class='dropdown-menu show']/a[4]")WebElement dropDownqueue;
	@FindBy (xpath="//div[@class='dropdown-menu show']/a[5]")WebElement dropDowntree;
	@FindBy (xpath="//div[@class='dropdown-menu show']/a[6]")WebElement dropDowngraph;

	//SignIn
	@FindBy (xpath="//a[@href ='/login']")WebElement signin;

	//Register
	@FindBy (xpath="//a[@href ='/register']")WebElement register;


	//Home Page url     
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	//DS-Algo Main url
	public void dsalgoportal() {
		driver.get(url);
		PageFactory.initElements(driver,this);
	}

	//Get Started Button
	public void getstarted_btn() {

		getStartedbtn.click();
	}

	public String getTitleofPage() {
		String title=driver.getTitle();
		return title;
	}

	public void homepage() {
		driver.get(homePageurl);
	}
	public String getAlert() {
		System.out.println("I am inside Get Alert");
		String alertMsg=alertMessage.getText();
		return alertMsg;
	}


	public void dropdown(String string) {

		 dsDropdown.click();
	        switch (string) {
	            case "Arrays":
	                LoggerLoad.info("User click on " + string);
	                dropDownarray.click();
	                break;
	            case "Linked List":
	                LoggerLoad.info("User click on " + string);
	                dropDownlinkedlist.click();
	                break;
	            case "Stack":
	                LoggerLoad.info("User click on " + string);
	                dropDownstack.click();
	                break;
	            case "Queue":
	                LoggerLoad.info("User click on " + string);
	                dropDownqueue.click();
	                break;
	            case "Tree":
	                LoggerLoad.info("User click on " + string);
	                dropDowntree.click();
	                break;
	            case "Graph":
	                LoggerLoad.info("User click on " + string);
	                dropDowngraph.click();
	                break;
	        }
	}

	public void getStartedhome(String string) {

		 switch (string) {
         case "Data Structures-Introduction":
             LoggerLoad.info("click " + getStartedDSintro.getText() + "link on  DataStructures ");
             getStartedDSintro.click();
             break;
         case "Arrays":
             LoggerLoad.info("click " + getStartedarray.getText() + "link on Array ");
             getStartedarray.click();
             break;
         case "Linked List":
             LoggerLoad.info("click " + getStartedlinkedlist.getText() + "link on LinkedList");
             getStartedlinkedlist.click();
             break;
         case "Stack":
             LoggerLoad.info("click " +  getStartedstack.getText() + "link on stack");
             getStartedstack.click();
             break;
         case "Queue":
             LoggerLoad.info("click " + getStartedqueue.getText() + "link on queue ");
             getStartedqueue.click();
             break;
         case "Tree":
             LoggerLoad.info("click " + getStartedtree.getText() + "link on Tree ");
             getStartedtree.click();
             break;
         case "Graph":
             LoggerLoad.info("click " +getStartedgraph.getText() + "link on Graph ");
             getStartedgraph.click();
             break;
     }

	}
	//Signing
	public void signinLink() {
		signin.click();
	}
	public String login_page() {
		String title = driver.getTitle();
		return title;
	}

	public void registerLink() {
		register.click();
	}

	public String register_page() {
		String title = driver.getTitle();
		return title;
	}


}
