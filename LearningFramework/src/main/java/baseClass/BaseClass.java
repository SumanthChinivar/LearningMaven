package baseClass;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BaseClass {
	public WebDriver driver;
	public SoftAssert softAssert;
	String userName="sumanthchinivar16@gmail.com";
	String password="Rowdy@123";
	
	@BeforeClass
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		Reporter.log("Empty Browser is launched",true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized",true);
		driver.get("https://demowebshop.tricentis.com/");
		Reporter.log("DemoWebshop is launched",true);
		softAssert=new SoftAssert();
	}
	
	@BeforeMethod
	public void login()
	{
		driver.findElement(By.linkText("Log in")).click();
		Reporter.log("User clicked on login link",true);
		driver.findElement(By.id("Email")).sendKeys(userName);
		String enteredUserName=driver.findElement(By.id("Email")).getAttribute("value");
		softAssert.assertEquals(enteredUserName, userName,"User name is different");
		Reporter.log("User name is entered into the username text field",true);
		
		driver.findElement(By.id("Password")).sendKeys(password);
		String enteredPassword=driver.findElement(By.id("Password")).getAttribute("value");
		softAssert.assertEquals(enteredPassword, password,"Password is not matching");
		Reporter.log("User entered password into username text field",true);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Reporter.log("user clicked on login",true);
	
	}
	
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.linkText("Log out")).click();
		Reporter.log("User clicked on logout",true);
		WebElement logoutButton=driver.findElement(By.linkText("Register"));
		softAssert.assertEquals(logoutButton.isDisplayed(), true,"User didnot logout");
		Reporter.log("User logged out successfully",true);
	}
	
	@AfterClass
	public void quitBrowser()
	{
		driver.quit();
		Reporter.log("Browser closed",true);
	}
}
