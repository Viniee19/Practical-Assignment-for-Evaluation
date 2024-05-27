package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class CartTest extends TestNGListeners{

	@Test (priority=0)
	public void changeProductQty() {
	Cartpage.enterQty();
	}
	
	@Test (priority=1)
	public void acceptTAndCCheckbox() throws InterruptedException {
		Cartpage.clickCheckbox();
		System.out.println("Accepted tearms and conditions successfully");
	}
	
	@Test (priority=2)
	public void verifyCheckout() throws InterruptedException {
		Cartpage.clickCheckoutButton();
		System.out.println("Verified cart page successfully");
	}
	

	

}
