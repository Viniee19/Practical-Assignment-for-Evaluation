package testclasses;

import java.util.List;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClassDemo {
	
	public static WebDriver driver ;
//	public LoginPage loginpage;
//	public HomePage homepage;
//	public CheckoutPage checkoutpage;


//	@BeforeSuite
	public static void main(String[] args) throws InterruptedException {
		
	

//	driver.findElement(By.xpath("//*[text()='Log in']")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("testtest1@try.test");
//	driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Tosca1234!");
//	driver.findElement(By.xpath("//*[@type='submit' and @value='Log in']")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//div[@class='listbox']//a[@href='/computers']")).click();


	
	
	System.out.println("-------------");
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[text()='Log in']")).click();
	driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("testtest1@try.test");
	driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Tosca1234!");
	driver.findElement(By.xpath("//*[@type='submit' and @value='Log in']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//ul[@class='top-menu']//*[@href='/apparel-shoes']")).click();
	Thread.sleep(1000);
	Actions act =new Actions(driver);
	WebElement product =driver.findElement(By.xpath("//*[@src='https://demowebshop.tricentis.com/content/images/thumbs/0000116_blue-and-green-sneaker_125.jpeg']"));
	act.moveToElement(product).perform();
	Thread.sleep(1000);
	String tooltiptext= product.getAttribute("title");
	product.click();
	System.out.println("Tooltip text is : "+tooltiptext);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@style='background-color:#1fcb1a;']")).click();//choosing green color
	driver.findElement(By.xpath("//*[@id='add-to-wishlist-button-28']")).click();// add to wishlist
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@href='/wishlist']")).click();// click wishlist link
	Thread.sleep(1000);
	String itemName=driver.findElement(By.xpath("//*[@class='cart-item-row']//*[text()='Blue and green Sneaker']")).getText();
	System.out.println("Item name is : "+itemName);
	String defaultQty=driver.findElement(By.xpath("//*[contains(@name,'itemquantity')]")).getAttribute("value");
	System.out.println("Default quantity is : "+defaultQty);
	String price=driver.findElement(By.xpath("//*[@class='product-unit-price']")).getText();
	System.out.println("Actual Price is : "+price);
	String total=driver.findElement(By.xpath("//*[@class='product-subtotal']")).getText();
	System.out.println("Subtotal is : "+total);
	String qty ="5";	
	WebElement qtybox=driver.findElement(By.xpath("//*[contains(@name,'itemquantity')]"));
	qtybox.clear();
	qtybox.sendKeys(qty);
	driver.findElement(By.xpath("//*[@name='updatecart']")).click();
	driver.findElement(By.xpath("//*[@type='checkbox' and @name='addtocart']")).click();// WLto add to cart chechbox	
	driver.findElement(By.xpath("//*[@type='submit' and @name='addtocartbutton']")).click(); //clicking add to cart button
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@name='termsofservice']")).click(); //clicking checkbox of T&C Button 
	driver.findElement(By.xpath("//*[@id='checkout']")).click(); //clicking checkout Button 
	driver.findElement(By.xpath("//*[@id='billing-address-select']")).sendKeys("test test1, Vienna street, Vienna 1234, Austria"); //clicking checkout Button 
	driver.findElement(By.xpath("//*[@onclick='Billing.save()']")).click(); //Continue button
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@onclick='Shipping.save()']")).click(); //Continue button
	Thread.sleep(1000);
//	driver.findElement(By.xpath("//*[@id='shipping-buttons-container']//*[@title='Continue']")).click(); //Continue button
	driver.findElement(By.xpath("//*[@onclick='ShippingMethod.save()']")).click(); //ShippingMethod CONTINUE
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@onclick='PaymentMethod.save()']")).click(); //Payment METHOD CONTINUE
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@onclick='PaymentInfo.save()']")).click(); //PaymentInfo button
	Thread.sleep(5000);
	String itemNameonCKout=driver.findElement(By.xpath("//*[@class='cart-item-row']//*[text()='Blue and green Sneaker']")).getText();
	System.out.println("Item name is : "+itemNameonCKout);
	String qtyonCKout=driver.findElement(By.xpath("//*[@class='qty nobr']")).getText();
	System.out.println("updated qty is : "+qtyonCKout);
	String priceonCKout=driver.findElement(By.xpath("//*[@class='product-unit-price']")).getText();
	System.out.println("Actual Price is : "+priceonCKout);
	String totalonCKout=driver.findElement(By.xpath("(//*[@class='nobr']//*[@class='product-price'])[1]")).getText();
	System.out.println("Subtotal is : "+totalonCKout);
//	//*[@class='product-price order-total']	
	String shipping=driver.findElement(By.xpath("(//*[@class='nobr']//*[@class='product-price'])[2]")).getText();
	String paymentMethodAdditionalFee =driver.findElement(By.xpath("(//*[@class='nobr']//*[@class='product-price'])[3]")).getText();
	String tax=driver.findElement(By.xpath("(//*[@class='nobr']//*[@class='product-price'])[4]")).getText();
	String actualTotalAmount=driver.findElement(By.xpath("//*[@class='product-price order-total']")).getText();
	System.out.println("Actual total amount is : "+actualTotalAmount);

	if(itemName.equals(itemNameonCKout)&&price.equals(priceonCKout)) {
		double expectedAmount = Double.parseDouble(qty)*Double.parseDouble(price);
		if(Double.parseDouble(totalonCKout)==expectedAmount) { //verification of sub-total
			double expectedTotalAmount= Double.parseDouble(totalonCKout)+Double.parseDouble(shipping)+Double.parseDouble(paymentMethodAdditionalFee)+Double.parseDouble(tax);
			if(Integer.parseInt(actualTotalAmount)==(expectedAmount)) {
				System.out.println("Product Name : "+itemName);
				System.out.println("Product Price : "+price);
				System.out.println("Product Quantity : "+price);
				System.out.println("Sub-total Amount : "+totalonCKout);
				System.out.println("Total Amount including all other charges: "+actualTotalAmount);
			}
		}
	}
	
	driver.findElement(By.xpath("//*[@onclick='ConfirmOrder.save()']")).click(); //Confirm BUTTON
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']")).click(); //order confirm content
	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[text()='Log out']")).click(); //LOGOUT LINK




	
	
	

	
	Thread.sleep(2000);

	
	driver.quit();
	}
	
	
	

}
