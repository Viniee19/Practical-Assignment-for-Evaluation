package testclasses;

import java.util.List;

import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	String amount ="";
	WebElement qtybox=driver.findElement(By.xpath("//*[contains(@name,'itemquantity')]"));
	qtybox.clear();
	qtybox.sendKeys(qty);
	driver.findElement(By.xpath("//*[@type='checkbox' and @name='addtocart']")).click();// WLto add to cart chechbox
	driver.findElement(By.xpath("//*[@type='submit' and @name='addtocartbutton']")).click(); //clicking add to cart button
	Thread.sleep(1000);
	
	
	

	
	Thread.sleep(2000);

	
	driver.quit();
	}
	
	
	

}
