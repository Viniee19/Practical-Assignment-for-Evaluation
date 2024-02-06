package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public void waitForVisibility(WebDriver driver, WebElement element, int timeout) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	wait.until(ExpectedConditions.visibilityOf(element));
	}

}
