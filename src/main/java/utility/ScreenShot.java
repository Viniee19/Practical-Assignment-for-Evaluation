package utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static String captureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File source = scrshot.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
		File destination = new File(path);
		org.openqa.selenium.io.FileHandler.copy(source, destination);		

		return path;
	}

}
