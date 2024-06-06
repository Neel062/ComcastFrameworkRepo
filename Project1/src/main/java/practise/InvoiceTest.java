package practise;

import org.testng.annotations.Test;

import com.comcast.crm.BasicUtility.BaseClass1;

import junit.framework.Assert;

public class InvoiceTest extends BaseClass1 {
	
	@Test
	public void BooksAddToCartVerify() {
		System.out.println("execute BooksAddToCartVerify");
		System.out.println(driver.getTitle());
		
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void ComputersAddToCartVerify() {
		System.out.println("execute ComputersAddToCartVerify");
		System.out.println(driver.getTitle());
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
