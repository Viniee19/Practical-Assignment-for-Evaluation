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

	@FindBy(xpath = "//*[@id='checkout']")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//*[@name='termsofservice']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//*[contains(@name,'itemquantity')]")
	private WebElement qtyBox;
	
	
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

	public String getTitleOfPage() {
		String titleofpage= driver.getTitle();
		return titleofpage;
	}
	
	public void enterQty() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver,qtyBox, 10);
		qtyBox.clear();
		qtyBox.sendKeys("5");
	}
	
	


}
