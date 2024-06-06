package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {

	public AddToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title=\"Show products in category Notebooks\"]")
	private WebElement addCompTOCart;
	
	public WebElement getAddCompTOCart() {
		return addCompTOCart;
	}
	
	@FindBy (xpath = "//input[@value='Add to cart']")
	private WebElement AddToCartLaptop;
	
	public WebElement getAddToCartLaptop() {
		return AddToCartLaptop;
	}
	@FindBy(xpath = "//img[@alt='Picture of Computing and Internet']/../../..//input")
	private WebElement addTocart;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement ShoppingCart;

	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement CheckBox;
	
	@FindBy (xpath = "//input[@name='updatecart']")
	private WebElement UpdateShoppingCart;
	
	

	public WebElement getAddTocart() {
		return addTocart;
	}

	public WebElement getShoppingCart() {
		return ShoppingCart;
	}

	public WebElement getCheckBox() {
		return CheckBox;
	}

	public WebElement getUpdateShoppingCart() {
		return UpdateShoppingCart;
	}
	
}
