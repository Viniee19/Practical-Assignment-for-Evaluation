package testclasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import pageclasses.CheckoutPage;

public class CheckoutTest extends TestNGListeners{
	
	@Test(priority=1,groups="Scenario2")
	public String getTitleOfPage() {
		String titleofpage= driver.getTitle();
		return titleofpage;
	}
	
	@Test(priority=2,groups="Scenario2")
	public void proceedToCheckout() throws IOException {
		CheckoutPage cp =new CheckoutPage(driver);
		cp.checkoutSteps();		
	}
	
	@Test(priority=3,groups="Scenario2")
	public void VerifyPaymentSummery() throws IOException {
		CheckoutPage cp =new CheckoutPage(driver);
		cp.verifyProductNameAndPrice();;		
	}
	
	@Test(priority=4,groups="Scenario2")
	public void verifyOrderConfirm() throws IOException {
		CheckoutPage cp =new CheckoutPage(driver);
		boolean check = cp.confirmOrder();	
		Assert.assertEquals(check, true);
		System.out.println("Your order has been successfully processed!");
	}
	
	
	

}
