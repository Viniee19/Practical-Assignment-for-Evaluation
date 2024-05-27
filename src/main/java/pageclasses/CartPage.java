package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import utility.ExplicitWait;

public class CartPage {
	
	private static WebDriver driver;
	private ExplicitWait wait;
	String qty="5";
	

	@FindBy(xpath = "//*[@id='checkout']")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//*[@name='termsofservice']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//*[contains(@name,'itemquantity')]")
	public static WebElement qtyBox;
	
	@FindBy(xpath = "//*[@name='updatecart']")
	private WebElement updateCartButton;
	
	@FindBy(xpath = "//*[@class='cart-item-row']//*[text()='Blue and green Sneaker']")
	public static WebElement itemNameOnCartPage;
	
	@FindBy(xpath = "//*[@class='product-unit-price']")
	public static WebElement itemPriceOnCartPage;
	
	@FindBy(xpath = "//*[@class='product-subtotal']")
	public static WebElement itemTotalAmtOnCartPage;

	public CartPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckbox() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, checkbox, 10);
		checkbox.click();	
	}
	public void clickCheckoutButton() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver,checkoutButton, 10);
		checkoutButton.click();	
	}

	public void enterQty() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver,qtyBox, 10);
		qtyBox.clear();
		qtyBox.sendKeys(qty);
		updateCartButton.click();
	}
	
	
	


}
