package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;

public class ProductTest extends TestNGListeners {

	@Test(priority=1,groups="Scenario1")
	public void verifyAddToCart() throws InterruptedException {
		productpage.clickAddToCartPDP();
		productpage.verifyProductAddedToCart();
//		test.info("Product added into the cart successfully");
		System.out.println("Verified verifyAddToCart method successfully");
	}
	
	@Test(priority=3,groups="Scenario1")
	public void verifyNavigation() throws InterruptedException {
		productpage.navigateToShoppingCartLink();		
//		test.info("Navigated to the shoppingcart link successfully");
		System.out.println("Verified verifyNavigation method successfully");		
	}
	
	@Test (priority=2,groups="Scenario1")
	public void validateTitleofPage() {
		String title = productpage.getTitleOfPage();
		Boolean isPresent =title.contains("Build");
		Assert.assertEquals(true, isPresent);
		System.out.println("Verified validateTitleofPage method of product details page successfully");
	}
	
	
//	Scenario 2nd
	@Test(priority=1,groups="Scenario2")
	public void ChooseGreenColor() throws InterruptedException {
		productpage.choosingGreenBox();		
	}
	
	@Test(priority=2,groups="Scenario2")
	public void verifyWishList() throws InterruptedException {
		boolean check =productpage.VerifyaddtoWishlist();	
		Assert.assertEquals(check, true);
		System.out.println("The product has been added to your wishlist");
	}
	
	

	
}
