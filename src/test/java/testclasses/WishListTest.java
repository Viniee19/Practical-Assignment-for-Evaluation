package testclasses;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import pageclasses.WishListPage;

public class WishListTest extends TestNGListeners  {
	
	@Test (priority=1)
	public void verifyProductAddedtoCartFromWL() {
	WishListPage wlp= new WishListPage(driver);
	wlp.wishlistToCart();
	}
	
	

}
