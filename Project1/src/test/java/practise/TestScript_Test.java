package practise;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestScript_Test extends BaseClass{
	@Test
	public void clickOnBooks() {
		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books");
//		Reporter.log("Books page is displayed",true);
		test.log(Status.PASS, "Books page is displayed"	);
	}
}
