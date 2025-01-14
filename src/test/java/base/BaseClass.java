package base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.ExcelReader;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import pageObjects.LoginPage;
import utilities.ConfigReader;


public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public ExcelReader excelReader = new ExcelReader(ConfigReader.getexcelfilepath());

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser) {
		if(browser.trim()=="")
			browser = ConfigReader.getBrowserType();
		DriverFactory.initializeBrowser(browser);
		driver = DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}


	
	public void loginToPortal() throws IOException
	{
		LoginPage sign = new LoginPage();
		String[][] validLoginData = new String[1][3];
		validLoginData[0][0] = excelReader.getCellData("Login", 1, 0);
		validLoginData[0][1] = excelReader.getCellData("Login", 1, 1);
		String username = validLoginData[0][0];
		String password = validLoginData[0][1];
		driver.get(ConfigReader.getlUrl("applicationUrl"));
		sign.clickOnGetstarted();
		sign.clickOnSignin();
		sign.enter_user_name(username);
		sign.enter_user_password(password);
		sign.clickonLogin(); 
		
	}
	
	public String failedTestShot(String methodname)
	{
		String filepath = null;
		System.out.println();
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// String screenshotBase64 = ((TakesScreenshot) element).getScreenshotAs(OutputType.BASE64);
		
		try {
			Allure.addAttachment("screenshot", FileUtils.openInputStream(screenshotFile));
			filepath = System.getProperty("user.dir")+"/ScreenShots/"+methodname+".png";
					//"C:\\Users\\golda\\eclipse-workspacenew\\DsAlgoTestNgProject\\src\\test\\java\\util\\"+methodname+".png";
			FileUtils.copyFile(screenshotFile, new File(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return filepath;
	}
	

}
