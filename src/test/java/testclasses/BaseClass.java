package testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pageclasses.CartPage;
import pageclasses.CheckoutPage;
import pageclasses.HomePage;
import pageclasses.LoginPage;
import pageclasses.ProductListPage;
import pageclasses.ProductPage;
import pageclasses.WishListPage;

public class BaseClass {
	
	public static WebDriver driver ;
	public LoginPage loginpage;
	public HomePage homepage;
	public ProductPage productpage;
	public CartPage Cartpage;
	public WishListPage wishlistpage;
	public ProductListPage productlistpage;
	public CheckoutPage checkouttpage;

	@BeforeTest	
    @Parameters("browser")	
	public void initBrowser(@Optional("defaultBrowser") String browser) throws InterruptedException {    	
    if(browser.equalsIgnoreCase("Chrome")) {
	    driver=new ChromeDriver();
	    }
    else if(browser.equalsIgnoreCase("firefox")) {
    	driver=new FirefoxDriver();
    	}
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com");
	Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeClass
	public void createObject() {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		productpage=new ProductPage(driver);
		Cartpage=new CartPage(driver);
		wishlistpage=new WishListPage(driver);
		productlistpage=new ProductListPage(driver);
		checkouttpage =new CheckoutPage(driver);
	}

}
