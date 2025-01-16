package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	
	@FindBy (xpath = "//a[@href=\"/home\"]/button[@class=\"btn\"]") 
	WebElement getStartedBtn;  //Home page
	
	@FindBy (xpath = "//a[@href='/register']") 
	WebElement clickRegisterLink; // 2nd home page click on Register
	
	@FindBy (id = "id_username")
	WebElement userName; //The user is on the user name text box
	
	@FindBy (id = "id_password1")
	WebElement passWord;
	
	@FindBy (id = "id_password2")
	WebElement passWordConfirmation;
	
	@FindBy (xpath = "//input[@value='Register']") // The user clicks on Register button
	WebElement registerBtn; 
	
	@FindBy (xpath = "//*[@class=\"alert alert-primary\"]")
	WebElement passwordErrorMsg;
	
		
	public void clickOnGetStarted() {
		getStartedBtn.click();
	}
	
	
	public void navigateToRegistrationPage(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
//	public void clickOnRegister() {
//		driver.get(secondHomePageUrl);
//		clickRegisterLink.click();
//		
//	}

	public void clickOnRegisterBtn() {
		registerBtn.click();
	}
	

	public String getErrorOnRegister(String msg) {
		// TODO: lookup the error text from the correct element
		return msg;
	}

	public void enterPassword(String passwordTxt) {
		passWord.sendKeys(passwordTxt);
	}

	public void enterPasswordConf(String passwordTxt) {
		passWordConfirmation.sendKeys(passwordTxt);
		
	}

	public void enterUserName(String usernameTxt) {
		userName.sendKeys(usernameTxt);
	}

	
	public String getErrorOnPasswordMsg() {
		String msg = passwordErrorMsg.getText();
		return msg;
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	

}
