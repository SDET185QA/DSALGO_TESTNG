package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import driver.DriverFactory;
//import com.aventstack.chaintest.plugins.ChainTestListener;


public class Chaintestlistner implements ITestListener {
	WebDriver driver =DriverFactory.getDriver(); 
	@Override
	public void onTestFailure(ITestResult result) {
		driver = DriverFactory.getDriver();
		final byte[] screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	//	ChainTestListener.embed(screenshot, "image/png");
		
	}
}
