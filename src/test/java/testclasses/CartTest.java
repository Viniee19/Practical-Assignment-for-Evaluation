package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class CartTest extends TestNGListeners{

	@Test (priority=1, groups={"Scenario1","Scenario2"})
	public void acceptTAndCCheckbox() throws InterruptedException {
		Cartpage.clickCheckbox();
//		test.info("Verified cart page successfully");
		System.out.println("Accepted tearms and conditions successfully");
	}
	
	@Test (priority=2,groups={"Scenario1","Scenario2"})
	public void verifyCheckout() throws InterruptedException {
		Cartpage.clickCheckoutButton();
//		test.info("Verified cart page successfully");
		System.out.println("Verified cart page successfully");
	}
	
	@Test (priority=3,groups="Scenario1")
	public void validateTitleofPage() {
		String title = Cartpage.getTitleOfPage();
		Boolean isPresent =title.contains("Checkout");
		Assert.assertEquals(true, isPresent);
//		test.info("Successfully validated the title"); // need to handle nullpointerexception here
		System.out.println("Verified validateTitleofPage method of checkout successfully");
	}
	
	@Test (priority=0,groups="Scenario2")
	public void changeProductQty() {
	Cartpage.enterQty();
	}
	

}
