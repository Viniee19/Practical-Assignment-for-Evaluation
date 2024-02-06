package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExplicitWait;

public class ProductListPage {
//	Scenario 2nd :
	private static WebDriver driver;
	private static ExplicitWait wait;

	@FindBy(xpath = "//*[@src='https://demowebshop.tricentis.com/content/images/thumbs/0000116_blue-and-green-sneaker_125.jpeg']")
	private static WebElement Product;
	
	public ProductListPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void howerproductandClick() throws InterruptedException  {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, Product, 10);
		Actions act =new Actions(driver);
		act.moveToElement(Product).perform();
		Thread.sleep(1000);
		String tooltiptext= Product.getAttribute("title");
		System.out.println("The tooltip text is : "+tooltiptext);
		Product.click();
	}
	
	
	

}
