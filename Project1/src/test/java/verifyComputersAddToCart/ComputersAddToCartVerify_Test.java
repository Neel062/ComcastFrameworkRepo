package verifyComputersAddToCart;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BasicUtility.BaseClass1;

import elementRepo.AddToCart;

public class ComputersAddToCartVerify_Test extends BaseClass1{

	@Test(groups = "integration")
	public void AddToComputers() {
		hp.getComputersLink().click();
		
		AddToCart atc1 = new AddToCart(driver);
		atc1.getAddCompTOCart().click();
		atc1.getAddToCartLaptop().click();
		atc1.getShoppingCart().click();
		atc1.getCheckBox().click();
		atc1.getUpdateShoppingCart().click();
		
		test.log(Status.PASS, "Computers page is displayed"	);
	}
}
