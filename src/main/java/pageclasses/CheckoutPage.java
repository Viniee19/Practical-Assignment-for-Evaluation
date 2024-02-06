package pageclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExcelReader;
import utility.ExplicitWait;

public class CheckoutPage {
	
	private static WebDriver driver;
	private ExplicitWait wait;
	
	@FindBy(xpath = "//*[@id='billing-address-select']")
	private WebElement addressField ; 
	@FindBy(xpath = "//*[@id='billing-buttons-container']//*[@title='Continue']")
	private WebElement  continue_1; 
	@FindBy(xpath = "//*[@id='shipping-buttons-container']//*[@title='Continue']")
	private WebElement continue_2 ; 
	@FindBy(xpath = "//*[@onclick='ShippingMethod.save()']")
	private WebElement continue_3 ; 
	@FindBy(xpath = "//*[@onclick='PaymentMethod.save()']")
	private WebElement continue_4 ; 
	@FindBy(xpath = "//*[@onclick='PaymentInfo.save()']")
	private WebElement continue_5 ; 	
	@FindBy(xpath = "//*[@class='cart-item-row']//*[text()='Blue and green Sneaker']")
	private WebElement itemNameOnCheckoutPage;	
	@FindBy(xpath = "//*[@class='product-unit-price']")
	private WebElement itemPriceOnCheckoutPage;	
	@FindBy(xpath = "//*[@class='product-subtotal']")
	private WebElement itemTotalAmtOnCheckoutPage;	
	@FindBy(xpath = "//*[@onclick='ConfirmOrder.save()']")
	private WebElement confirmButton ; 
	@FindBy(xpath = "//*[text()='Your order has been successfully processed!']")
	private WebElement orderConfirmedContent ;
	@FindBy(xpath = "//*[text()='Log out']")
	private WebElement logoutLink ;
	
	public CheckoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkoutSteps() throws IOException {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, addressField, 20);
		addressField.sendKeys(ExcelReader.readData(0, 3, 1));	
		continue_1.click();
		wait.waitForVisibility(driver, continue_2, 10);
		continue_2.click();
		wait.waitForVisibility(driver, continue_3, 10);
		continue_3.click();
		wait.waitForVisibility(driver, continue_4, 10);
		continue_4.click();
		wait.waitForVisibility(driver, continue_5, 10);
		continue_5.click();	
	}
	
	public void verifyProductNameAndPrice() {
	int quantity=Integer.parseInt(CartPage.qtyBox.getAttribute("value"));
	int subTotalAmount=Integer.parseInt(itemPriceOnCheckoutPage.getText())*quantity;
    System.out.println(subTotalAmount);

	if(CartPage.itemNameOnCartPage.equals(itemNameOnCheckoutPage)&&CartPage.itemPriceOnCartPage.equals(itemPriceOnCheckoutPage)) {
		System.out.println("Item name is : " +itemNameOnCheckoutPage+" and "+"Actual Price is : "+itemPriceOnCheckoutPage);
	}
   	}
	
    public boolean confirmOrder() {
		wait =new ExplicitWait();
    	wait.waitForVisibility(driver, confirmButton, 10);
		confirmButton.click();	
    	wait.waitForVisibility(driver, orderConfirmedContent, 10);
    	boolean ispresent=orderConfirmedContent.isDisplayed();
    	logoutLink.click();
    	return ispresent;		
	}
    
	
	
	

}
