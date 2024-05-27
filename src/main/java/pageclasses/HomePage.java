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


	@FindBy(xpath = "//ul[@class='top-menu']//*[@href='/apparel-shoes']")
	private WebElement clickapperalnshoes;

	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitleOfPage() {
		String titleofpage= driver.getTitle();	
		return titleofpage;
	}
	
	public void apperalandshoesclick() {
		clickapperalnshoes.click();
	}
	

}
