package practise;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import elementRepo.Homepage;
import elementRepo.LoginPage;

public class BaseClass {
	public  WebDriver driver; 
	public static ExtentReports extReport;
	public ExtentTest test;
	
	public Homepage hp;
	public LoginPage lp;
	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark=new ExtentSparkReporter("./htmlreport/extentReport.html");
		extReport=new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
	}
	@BeforeMethod
	public void login(Method method) {
		test = extReport.createTest(method.getName());
		hp=new Homepage(driver);
		hp.getLoginBtnLink().click();
		lp=new LoginPage(driver);
		lp.getUsername().sendKeys("neelesh.chatterjee@incture.com");
		lp.getPassword().sendKeys("Tosca1234!");
		lp.getLoginBtn().click();
	}
	@AfterMethod
	public void logout() {
		hp.getLogOutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
}
