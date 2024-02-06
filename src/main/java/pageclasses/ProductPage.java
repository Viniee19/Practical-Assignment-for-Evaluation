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
	
	@FindBy(xpath = "//*[@id='add-to-cart-button-72']")
	private WebElement addToCartPDP; //Add to cart button on product details page
	
	@FindBy(xpath = "//*[@class='content']")
	private WebElement content;
	
	@FindBy(xpath = "//*[@class='ico-cart']//*[text()='Shopping cart']")
	private WebElement shoppingCartLink;
	
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
	
	public void clickAddToCartPDP() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, addToCartPDP, 10);
		addToCartPDP.click();	
	}
	public void verifyProductAddedToCart() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, content, 10);
		Boolean verifyContent = content.isDisplayed();	
	}
	public String getTitleOfPage() {
		String titleofpage= driver.getTitle();	
		return titleofpage;
	}
	
	public void navigateToShoppingCartLink() {
		shoppingCartLink.click();	
	}
	
//	Scenario 2nd :
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
