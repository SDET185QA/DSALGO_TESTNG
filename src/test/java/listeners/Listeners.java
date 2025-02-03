package listeners;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;


import driver.DriverFactory;
import utilities.CaptureScreenshot;
import utilities.ConfigReader;


public class Listeners implements ITestListener {
	WebDriver driver =DriverFactory.getDriver(); 
	ExtentReports extentReport;
	ExtentTest extentTest;
	ExtentSparkReporter sparkReporter;
	
	
	@Attachment(value = "Screenshot of {0}", type = "image/png")
    public static byte[] getScreenShot(WebDriver driver) {
	 	driver = DriverFactory.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter("./target/extent-reports/extent-report.html");	
		
		sparkReporter.config().setReportName("Quality Questers DSAlgo");
		sparkReporter.config().setDocumentTitle("DSAlgo Automation Report");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		sparkReporter.config().setTheme(Theme.STANDARD);
		extentReport = new ExtentReports();
		
		try {
			sparkReporter.loadXMLConfig(new File("extent-config.xml"));
		} catch (IOException e) {
			
		}
		
		extentReport.attachReporter(sparkReporter);
			
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("Team Name", "Quality Questers");
		extentReport.setSystemInfo("Application URL", ConfigReader.getlUrl("applicationUrl"));
		extentReport.setSystemInfo("Browser Name", ConfigReader.getBrowserType());
		extentReport.setSystemInfo("Operating Systen", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version") );
		extentReport.getReport();
		extentReport.getReportSubject();
		extentReport.getTestSubject();
		
		
		}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName + " execution started" );
		extentTest.generateLog(Status.PASS, testName);
		extentTest.assignAuthor("Qualtiy "+" "+ "Questers");
		extentTest.assignCategory("Quality"+" "+ " " +"Questers" + " "+ "TestNG" + " " +" Test Cases");
	
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		extentTest.log(Status.PASS,testName + " is successfully executed");
		extentTest.assignAuthor("Quality "+" "+ "Questers");
		extentTest.assignCategory("Quality"+" "+ " " +"Questers" + " "+ "TestNG" + " " +"Passed"+ " "+ " Test Cases");
		
		
	}

	
public void onTestFailure(ITestResult result) {
		
		String ScreenshotName = result.getMethod().getMethodName().replace(" ", "_") + ".png";
		String ScreenshotDir = "\\screenshots\\";
		String path = System.getProperty("user.dir")+ ScreenshotDir +ScreenshotName;
		
		if(result.getStatus()==ITestResult.FAILURE){
			Reporter.log("<a href='"+path + "'> <img src='"+ path + "' height='100' width='100'/> </a>");
			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(Status.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			extentTest.assignAuthor("Quality "+" "+ "Questers");
			extentTest.assignCategory("Quality"+" "+ " " +"Questers" + " "+ "TestNG" + " " +"Failed"+ " "+ " Test Cases");
			CaptureScreenshot.takeScreenshot(ScreenshotName);
			//extentTest.addScreenCaptureFromBase64String(ScreenshotDir, ScreenshotName);//added now	
			//extentTest.addScreenCaptureFromBase64String(ScreenshotDir, ScreenshotName);//added now	
			extentTest.addScreenCaptureFromPath(path);
	    	getScreenShot(driver);
	     	Allure.addAttachment(ScreenshotName, new ByteArrayInputStream(getScreenShot(driver)));
	    	         		
	     	extentReport.createTest(result.getName())
			.log(Status.FAIL, "Test case Failed: "+result.getName())
			.log(Status.FAIL, "Test case Failed Reason: "+result.getThrowable())
			.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	
		}

     	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.assignAuthor("Quality "+" "+ "Questers");
		extentTest.log(Status.SKIP, testName+" is skipped");
		extentTest.assignCategory("Quality"+" "+ " " +"Questers" + " "+ "TestNG" + " " +"Skipped"+ " "+ " Test Cases");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}

}
