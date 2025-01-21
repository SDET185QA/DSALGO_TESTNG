package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedListIntroPage {
	
	WebDriver driver;

	@FindBy (xpath = "//a[@href=\"/tryEditor\"]")
	WebElement tryHereClickBtn;			//Click on try here button
	
	@FindBy (xpath="//a[@href=\"/linked-list/practice\"]")
	WebElement practiceQnsLink;		//Click on practice questions link

	public void tryHere() {
		tryHereClickBtn.click();
	}
	
	public void practiceQns() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		practiceQnsLink.click();
	}

	public void navigateToLinkedListIntroPage(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(driver,this);
	}
	
	public String getPracticeQnsContent() {
		return driver.findElement(By.xpath("//div[@id='content']")).getText().trim();
	}


}
