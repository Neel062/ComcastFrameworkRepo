package verifyBookAddToCart;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BasicUtility.BaseClass1;

import elementRepo.AddToCart;
import elementRepo.Homepage;
import elementRepo.LoginPage;

public class BooksAddToCartVerify extends BaseClass1{

	@Test(groups = "smoke")
	public void AddToBook() throws IOException {
	
		hp.getBooksLink().click();

		AddToCart atc=new AddToCart(driver);
		atc.getAddTocart().click();
		
		atc.getShoppingCart().click();
		//reporter.log
		//test pass / fail
		
		
		atc.getCheckBox().click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).isSelected();
		atc.getUpdateShoppingCart().click();
		test.log(Status.PASS, "Books page is displayed"	);
	}
}
