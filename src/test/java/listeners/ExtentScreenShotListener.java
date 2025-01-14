package listeners;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;
import utilities.ConfigReader;


public class ExtentScreenShotListener extends BaseClass implements ITestListener {
	ExtentSparkReporter sparkReport = null;
	ExtentReports extentReport = null;
	ExtentTest extentTest = null;
	
	@Override
	  public void onTestFailure(ITestResult tr) {
		extentTest = extentReport.createTest(tr.getName());
		extentTest.log(Status.FAIL, "The test failed is"+tr.getName());
		extentTest.log(Status.FAIL, "The test failed cause is"+tr.getThrowable());		
		 try
		 {
			 String imgPath = failedTestShot(tr.getMethod().getMethodName());
			 //String imgPath=new BaseClass().captureScreen(tr.getName());
			 extentTest.addScreenCaptureFromPath(imgPath);
			 
		 }
		 catch(Exception e1)
		 {
			 e1.printStackTrace();
		 }
		 
		 
		
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  extentTest = extentReport.createTest(tr.getName());
		extentTest.log(Status.SKIP, "The test Skipped is"+tr.getName());
	  }
	  
	  

	  @Override
	  public void onTestSuccess(ITestResult tr) {
		  extentTest = extentReport.createTest(tr.getName());
		  extentTest.log(Status.PASS, "The test passed is"+tr.getName());
	   
	  }
	  
	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
		  
		  //String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName="DSAlgoTestNGExtentReportsListner.html";
	    sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/extent-results/"+fileName);
	    sparkReport.config().setDocumentTitle("DSAlgo Automation Report");
	    sparkReport.config().setReportName("DSAlgo TestNG Testing");
	    sparkReport.config().setTheme(Theme.STANDARD);
	    
	    
	    
	    extentReport = new ExtentReports();
	    extentReport.attachReporter(sparkReport);
	    extentReport.setSystemInfo("Application URL", ConfigReader.getlUrl("applicationUrl"));
		extentReport.setSystemInfo("Browser Name", ConfigReader.getBrowserType());
		extentReport.setSystemInfo("Operating Systen", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version") );

	  }
	  
	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
		  extentReport.flush();
	  }

}
