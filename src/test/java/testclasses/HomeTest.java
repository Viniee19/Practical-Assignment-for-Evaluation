package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import extentlisteners.TestNGListeners;

public class HomeTest extends TestNGListeners {
	
	
	@Test (priority=1)
	public void validateTitleofPage() {
		String title = homepage.getTitleOfPage();
		System.out.println("The title of the current page is :"+title);
		Boolean isPresent =title.contains("Shop");	
		Assert.assertEquals(true, isPresent);
		System.out.println("Successfully validated the title over a homepage");
	}
	
		
	@Test(priority=2)
	public void clickingOnAPPARELandSHOES() {
		homepage.apperalandshoesclick();
		System.out.println("Successfully clicked on APPAREL and SHOES on top menu of homepage");
    }


}
