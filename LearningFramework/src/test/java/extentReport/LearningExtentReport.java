package extentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtentReport {

	@Test
	public void login()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/LoginReport.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(reporter);
		ExtentTest test=reports.createTest("Launching the browser");
		WebDriver driver=new ChromeDriver();
		test.log(Status.INFO, "Browser is launched");
		driver.manage().window().maximize();
		test.log(Status.INFO,"Window is maximized");
		
		driver.get("https://demowebshop.tricentis.com/");
		test.log(Status.INFO, "Application launched");
		driver.quit();
		reports.flush();
	}
}
