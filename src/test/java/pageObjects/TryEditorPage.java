package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryEditorPage {
	

	WebDriver driver;
	@FindBy(xpath = "//form[@id=\"answer_form\"]/button[@type=\"button\"]")
	WebElement runBtn;

	@FindBy(xpath = "//textarea[@tabindex='0']") // Code console where we send the code as input
	WebElement codeConsole;

	@FindBy(xpath = "//div/pre[@id='output']") // Output console area
	WebElement outputConsole;

	public void navigateToTryEditorPage(WebDriver webDriver) {
		driver = webDriver;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void clickOnRunBtn() {
		runBtn.click();
	}

	public String getMsg() {
		try {
			String outPutMsg = driver.switchTo().alert().getText();
			return outPutMsg;
		} catch (NoAlertPresentException ex) {
			return "";
		}
	}

	public String getErrorMsg() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}

	public void executeCode(String code) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		codeConsole.sendKeys(code);
	}

	public String outputConsole() {
		String outPut = driver.findElement(By.xpath("//div/pre[@id='output']")).getText();

		return outPut;
	}


}
