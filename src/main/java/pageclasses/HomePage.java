package pageclasses;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExplicitWait;

public class HomePage {
	
	private static WebDriver driver;
	private ExplicitWait wait;
//	wait =new ExplicitWait();
//	wait.waitForVisibility(driver,qtyBox, 10);

	@FindBy(xpath = "//div[@class='listbox']//a[@href='/computers']")
	private WebElement computersLink;
	
	@FindBy(xpath = "//div[@class='listbox']//a[@href='/desktops']")
	private WebElement desktopLink;
	
	@FindBy(xpath = "//*[@data-productid='72']//*[@value='Add to cart']")
	private WebElement addtoCartButton;
	
	@FindBy(xpath = "//ul[@class='top-menu']//*[@href='/apparel-shoes']")
	private WebElement clickapperalnshoes;
	
	@FindBy(xpath = "//ul[@class='top-menu']/li")
	private List<WebElement> topMenus;
	
	@FindBy(xpath = "//*[text()='Categories']//ancestor::div[2]//ul[@class='list']/li")
	private List<WebElement> sideMenus;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectComputers() {
		computersLink.click();
		desktopLink.click();		
	}
	
	public void clickAddToCart() {
		addtoCartButton.click();	
	}
	public String getTitleOfPage() {
		String titleofpage= driver.getTitle();	
		return titleofpage;
	}
	
	public void apperalandshoesclick() {
		clickapperalnshoes.click();
	}
	
	public boolean topmenuAndSidemenu() {
		boolean result=true;
		if(topMenus.size()==sideMenus.size()) {
			 int noofElement = topMenus.size();
		for(int i=0;i<noofElement;i++) {
			if(topMenus.get(i).equals(sideMenus.get(i))) {
				result=true;//Validated the Topmenus and Sidemenus are Same
			}
		}			
		}else {
			result=false;//Validated the Topmenus and Sidemenus are NOT Same
		}
		return result;//Validated the Topmenus and Sidemenus are Same
	}
	
	

}
