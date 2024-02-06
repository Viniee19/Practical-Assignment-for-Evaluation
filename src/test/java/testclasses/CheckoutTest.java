package testclasses;

import java.io.IOException;

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
	
	
	

}