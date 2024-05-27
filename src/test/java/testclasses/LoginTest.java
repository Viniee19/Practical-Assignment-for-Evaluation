package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import extentlisteners.TestNGListeners;
import utility.ConfigReader;
import utility.ExcelReader;

public class LoginTest extends TestNGListeners {
	
	@Test(priority=1)
	public void validateTitleofPage() {
		String title = loginpage.getTitleOfPage();
		Boolean isPresent =title.contains("Demo");
		Assert.assertEquals(true, isPresent);
	}

	@Test(priority=2)
	public void verifyLogin() throws InterruptedException, IOException {
		loginpage.clickLoginLink();
		loginpage.enterEmail(ExcelReader.readData(0, 1, 1));
		loginpage.enterPassword(ExcelReader.readData(0, 2, 1));
		loginpage.clickLoginButton();
	}
	
	
}
