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
		String testName = result.getName();
		driver = DriverFactory.getDriver();
		final byte[] screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//ChainTestListener.log(testName+ " "+" testcase failed");// logs for failed test cases   
	    //ChainTestListener.embed(screenshot, "image/png");//to attach screenshot for failed test cases
		
	}
}
