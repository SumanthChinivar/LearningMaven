package extentReport;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtentReport {

	WebDriver driver;
	@Test
	public void login()
	{
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/TestReport.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(reporter);
		ExtentTest test=reports.createTest("DWS Test");
		driver=new ChromeDriver();
		test.log(Status.INFO, "Browser is launched");
		driver.manage().window().maximize();
		test.log(Status.INFO,"Window is maximized");
		
		driver.get("https://demowebshop.tricentis.com/");
		
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenCapture("Launch Application"),"HomePage").build());
		
		driver.findElement(By.linkText("Log in")).click();
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenCapture("Log in Link"),"LoginPage").build());
		
		String currentURL=driver.getCurrentUrl();
		if(currentURL.equalsIgnoreCase("://demowebshop.tricentis.com/")) {
			test.log(Status.INFO, "Application launched");
		}else
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenCapture("URL mismatch"),"HomePage").build());
		
		driver.quit();
		reports.flush();
	}
	
	public String screenCapture(String stepName)
	{
		Random random=new Random(1000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest="./snapShots/"+stepName+".png";
		File target=new File(dest);
		try {
			FileHandler.copy(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+dest;
	}
}
