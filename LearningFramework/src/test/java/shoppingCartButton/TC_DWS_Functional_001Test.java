package shoppingCartButton;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseClass.BaseClass;
import elementRepository.HomePage;

public class TC_DWS_Functional_001Test extends BaseClass{
	@Test
	public void click_On_Register_Link() {
		HomePage home=new HomePage(driver);
		home.getShoppingCartLink().click(); 
		
		test.log(Status.INFO,"click on register link");	
	}
}
