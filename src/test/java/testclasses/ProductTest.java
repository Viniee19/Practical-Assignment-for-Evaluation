package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class ProductTest extends TestNGListeners {

	@Test(priority=1)
	public void ChooseGreenColor() throws InterruptedException {
		productpage.choosingGreenBox();		
	}
	
	@Test(priority=2)
	public void verifyWishList() throws InterruptedException {
		boolean check =productpage.VerifyaddtoWishlist();	
		Assert.assertEquals(check, true);
		System.out.println("The product has been added to your wishlist");
	}
	
	

	
}
