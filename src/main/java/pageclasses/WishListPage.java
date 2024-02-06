package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExplicitWait;

public class WishListPage {
	
	private static WebDriver driver;
	private ExplicitWait wait;

//	wait =new ExplicitWait();
//	wait.waitForVisibility(driver,qtyBox, 10);
	
	@FindBy(xpath = "//*[@type='checkbox' and @name='addtocart']")
	private WebElement wLtoAddtoCart;
	
	@FindBy(xpath = "//*[@type='submit' and @name='addtocartbutton']")
	private WebElement addToCartButton;
	
	public WishListPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void wishlistToCart() {
		wLtoAddtoCart.click();
		addToCartButton.click();
	}

}
