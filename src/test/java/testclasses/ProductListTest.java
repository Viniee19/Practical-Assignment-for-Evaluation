package testclasses;

import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import pageclasses.ProductListPage;

public class ProductListTest extends TestNGListeners{
	
	@Test (priority=1)
	public void howeringOnBlueandGreenSneaker() throws InterruptedException {
		ProductListPage.howerproductandClick();
}


}
