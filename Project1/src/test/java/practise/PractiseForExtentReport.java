package practise;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class PractiseForExtentReport {

	public ExtentReports report;
	@BeforeSuite
	public void Config() {
		//spark Report Config
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test suite result");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);

				//add env information & create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "WINDOWS-11");
				report.setSystemInfo("BROWSER", "Chrome-100");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	@Test
	public void createContact() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot eDriver = (TakesScreenshot)driver;
		String FilePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContact");
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}else {
			test.addScreenCaptureFromBase64String(FilePath, "ErrorFile");
		}
		report.flush();
	}
	
	@Test
	public void createContactwithORG() {
		
		ExtentTest test = report.createTest("createContactwithORG");
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}else {
			test.log(Status.FAIL, "contact is not created");
		}
	}
	
	@Test
	public void createContactwithphno() {
		
		ExtentTest test = report.createTest("createContactwithphno");
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}else {
			test.log(Status.FAIL, "contact is not created");
		}
	}
}
