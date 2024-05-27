package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExplicitWait;

public class ProductPage {
	
	private static WebDriver driver;
	private ExplicitWait wait;
	
	@FindBy(xpath = "//*[@style='background-color:#1fcb1a;']")
	private WebElement greenBox;
	
	@FindBy(xpath = "//*[@id='add-to-wishlist-button-28']")
	private WebElement addtoWishlist;
	
	@FindBy(xpath = "//p//*[@href='/wishlist']")
	private WebElement wishlistcontent;

	@FindBy(xpath = "//*[@href='/wishlist']")
	private WebElement wishlistlink;


	public ProductPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public void choosingGreenBox() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, greenBox, 10);
		greenBox.click();
	}
	
	public boolean VerifyaddtoWishlist() {
		addtoWishlist.click();
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, wishlistcontent, 10);
		Boolean verifywishlistcontent = wishlistcontent.isDisplayed();
		wishlistlink.click();
		return verifywishlistcontent;
	}
	
	

}
