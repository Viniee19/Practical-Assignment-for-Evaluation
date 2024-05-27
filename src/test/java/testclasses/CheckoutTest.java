package testclasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import pageclasses.CheckoutPage;

public class CheckoutTest extends TestNGListeners{

	@Test(priority=1)
	public void proceedToCheckout() throws IOException {
		CheckoutPage cp =new CheckoutPage(driver);
		cp.checkoutSteps();		
	}
	
	@Test(priority=2)
	public void VerifyPaymentSummery() throws IOException {
		CheckoutPage cp =new CheckoutPage(driver);
		boolean status=cp.verifyProductNameAndPrice();	
		Assert.assertEquals(status, true);
		System.out.println("Verified successfully the product name and its price");

	}
	
	@Test(priority=3)
	public void verifyOrderConfirm() throws IOException {
		CheckoutPage cp =new CheckoutPage(driver);
		boolean check = cp.confirmOrder();	
		Assert.assertEquals(check, true);
		System.out.println("Your order has been successfully processed!");
	}
	
	
	

}
