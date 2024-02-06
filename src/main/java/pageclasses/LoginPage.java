package pageclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ExplicitWait;

public class LoginPage {
	
	private static WebDriver driver;
	private ExplicitWait wait;

	@FindBy(xpath = "//*[text()='Log in']")
	private WebElement loginlink;
	
	@FindBy(xpath = "//*[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id='Password']")
	private  WebElement password;
	
	@FindBy(xpath = "//*[@type='submit' and @value='Log in']")
	private WebElement loginbutton;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginLink() {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, loginlink, 10);
		loginlink.click();	
	}
	public void enterEmail(String eml) {
		wait =new ExplicitWait();
		wait.waitForVisibility(driver, email, 10);
		email.sendKeys(eml);	
	}
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);	
	}
	public void clickLoginButton() {
		loginbutton.click();	
	}

	public String getTitleOfPage() {
		String titleofpage= driver.getTitle();	
		return titleofpage;
	}
	
	

}
