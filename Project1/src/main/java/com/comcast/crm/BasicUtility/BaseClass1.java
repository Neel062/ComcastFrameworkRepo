package com.comcast.crm.BasicUtility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.comcast.crm.propertyfileutility.propertyFileUtilizationClass;

import elementRepo.Homepage;
import elementRepo.LoginPage;

public class BaseClass1 {
	public WebDriver driver;
	public Homepage hp;

	public ExtentTest test;
	public ExtentReports extReport;

	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./htmlreport/extentReport.html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}

	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException {

		propertyFileUtilizationClass flib = new propertyFileUtilizationClass();

		System.out.println("Launch the Browser");
		String BROWSER = flib.getDataFromPropertyFile("browser");

		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// maximize
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Navigate to URL
		driver.get(flib.getDataFromPropertyFile("url"));
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM(Method method) {

		test = extReport.createTest(method.getName());

		hp = new Homepage(driver);
		hp.getLoginBtnLink().click();
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("neelesh.chatterjee@incture.com");
		lp.getPassword().sendKeys("Tosca1234!");

//		lp.getUsername().sendKeys(flib.getDataFromPropertyFile("username"));
//		lp.getPassword().sendKeys(flib.getDataFromPropertyFile("password"));
//		lp.getLoginBtn()).click();

//		lp.performLogin(flib.getDataFromPropertyFile("username"), flib.getDataFromPropertyFile("password"));

		lp.getLoginBtn().click();

	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		hp.getLogOutLink().click();
		// Logout

	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
	}

	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
}
