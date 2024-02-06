package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import extentlisteners.TestNGListeners;

public class HomeTest extends TestNGListeners {
	
	@Test (priority=1,groups={"Scenario1"})
	public void selectProduct() {
		homepage.selectComputers();
//		test.info("Chosen computers category and selected Desktops");
		System.out.println("Chosen computers category and selected Desktops");
	}
	
	@Test (priority=3,groups={"Scenario1"})
	public void verifyAddToCartClick() {
		homepage.clickAddToCart();
//		test.info("Clicked on Add to cart button over a homepage");
		System.out.println("Successfully clicked on Add to cart button on homepage");
	}
	
	@Test (priority=2,groups={"Scenario1"})
	public void validateTitleofPage() {
		String title = homepage.getTitleOfPage();
		Boolean isPresent =title.contains("Desktops");	
		Assert.assertEquals(true, isPresent);
//		test.info("Successfully validated the title"); // need to handle nullpointerexception here
		System.out.println("Successfully validated the title over a homepage");
	}
	
//		SCENARIO 2nd :
	
	@Test(priority=1,groups={"Scenario2"})
	public void verifyTopmenuAndSidemenu() {
		boolean validation=homepage.topmenuAndSidemenu();
		SoftAssert sa= new SoftAssert();
	    sa.assertEquals(validation, true);
	    System.out.println("Validated the Topmenus and Sidemenus are Same");
    }
		
	@Test(priority=2,groups={"Scenario2"})
	public void clickingOnAPPARELandSHOES() {
		homepage.apperalandshoesclick();
		System.out.println("Successfully clicked on APPAREL and SHOES on top menu of homepage");
    }


}
