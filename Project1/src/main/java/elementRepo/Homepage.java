package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(partialLinkText = "Computers")
	private  WebElement computersLink;
	
	public WebElement getComputersLink() {
		return computersLink;
	}

	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginBtnLink;
	
	public WebElement getLoginBtnLink() {
		return loginBtnLink;
	}

	@FindBy(partialLinkText = "Books")
	private WebElement booksLink;
	
	@FindBy(partialLinkText = "Computers")
	private WebElement comptursLink;
	
	@FindBy(partialLinkText = "Electronics")
	private WebElement ElectronicsLink;
	
	@FindBy(partialLinkText = "Apparel & Shoes")
	private WebElement ApperalLink;
	
	@FindBy(partialLinkText = "Digital downloads")
	private WebElement DigitalLink;
	
	@FindBy(partialLinkText = "Jewelry")
	private WebElement JewelryLink;
	
	@FindBy(partialLinkText = "Gift Cards")
	private WebElement GiftCardsLink;

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComptursLink() {
		return comptursLink;
	}

	public WebElement getElectronicsLink() {
		return ElectronicsLink;
	}

	public WebElement getApperalLink() {
		return ApperalLink;
	}

	public WebElement getDigitalLink() {
		return DigitalLink;
	}

	public WebElement getJewelryLink() {
		return JewelryLink;
	}

	public WebElement getGiftCardsLink() {
		return GiftCardsLink;
	}
	@FindBy (xpath = "//a[text()='Log out']")
	private WebElement LogOutLink;

	public WebElement getLogOutLink() {
		return LogOutLink;
	}
}
