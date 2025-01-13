package base;
import java.io.IOException;
import java.time.Duration;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import utilities.ExcelReader;

import driver.DriverFactory;
import pageObjects.LoginPage;
import utilities.ConfigReader;


public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public ExcelReader excelReader = new ExcelReader(ConfigReader.getexcelfilepath());

	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String browser) {
		
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
	

}
