package baseClass;

import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {
	public WebDriver driver;
	public SoftAssert softAssert;
	String userName = "sumanthchinivar16@gmail.com";
	String password = "Rowdy@123";
	static ExtentReports reports;
	public static ExtentTest test;

	
	@BeforeSuite
	public void reports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/DWSReport.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		Reporter.log("Empty Browser is launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized", true);
		driver.get("https://demowebshop.tricentis.com/");
		Reporter.log("DemoWebshop is launched", true);
		softAssert = new SoftAssert();
	}

	@BeforeMethod
	public void login(Method method) {
		driver.findElement(By.linkText("Log in")).click();
		Reporter.log("User clicked on login link", true);
		driver.findElement(By.id("Email")).sendKeys(userName);
		String enteredUserName = driver.findElement(By.id("Email")).getAttribute("value");
		softAssert.assertEquals(enteredUserName, userName, "User name is different");
		Reporter.log("User name is entered into the username text field", true);

		driver.findElement(By.id("Password")).sendKeys(password);
		String enteredPassword = driver.findElement(By.id("Password")).getAttribute("value");
		softAssert.assertEquals(enteredPassword, password, "Password is not matching");
		Reporter.log("User entered password into username text field", true);

		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("user clicked on login", true);
		test = reports.createTest(method.getName());
	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("User clicked on logout", true);
		WebElement logoutButton = driver.findElement(By.linkText("Register"));
		softAssert.assertEquals(logoutButton.isDisplayed(), true, "User didnot logout");
		Reporter.log("User logged out successfully", true);
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
		Reporter.log("Browser closed", true);
	}

	@AfterSuite
	public void flush() {
		reports.flush();
	}
}
