package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
}
