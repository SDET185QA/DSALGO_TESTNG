package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StackPage {
	
	WebDriver driver;

	@FindBy (xpath = "//a[@href=\"operations-in-stack\"]")
	WebElement operationsInStack;		//Click on Operations in Stack link
	
	@FindBy (xpath = "//a[@href=\"implementation\"]")
	WebElement implementation;		//Click on implementation link
	
	@FindBy (xpath="//a[@href=\"stack-applications\"]")
	WebElement applications;		//Click on applications link
	
	public void navigateToStackPage(WebDriver WebDriver) {
		driver = WebDriver;
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		PageFactory.initElements(driver,this);
		}
	
	public void clickOnOperationsInStack() {
		//driver.findElement(By.xpath("//a[@href=\"/stack/operations-in-stack/\"]")).click();
		operationsInStack.click();
	}
	
	public void clickOnImplementation() {
		implementation.click();
	}
	
	public void ClickOnApplications() {
		applications.click();
	}

	public void ClickOnPracticeQns() {
		driver.findElement(By.xpath("//a[@href=\"/stack/practice\"]")).click();
	}
	
	public String getCurrentUrl() {
		String Url = driver.getCurrentUrl();
		return Url;
	}

	public void openSubPage(String subPage) {
		switch (subPage) {
		case "OperationsInStack":
			operationsInStack.click();
		break;
		case "Implementation":
			implementation.click();
		break;
		case "Applications":
			applications.click();
		break;
		}
	}
	
	public String getPracticeQnsContent() {
		return driver.findElement(By.xpath("//div[@id='content']")).getText().trim();
	}
	public void clickOnTryHereOnSubPage() {
		driver.findElement(By.xpath("//a[@href=\"/tryEditor\"]")).click();
	}



}
