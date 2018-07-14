package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyingDataInsideOrderPage {
	
	public VerifyingDataInsideOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="//*[@id='ctl00_menu']/li[2]/a")
	public WebElement viewAllProductLink;
	
	@FindBy(xpath="//h2")
	public WebElement listOfProductsLabel;
	
	@FindBy(xpath="//tbody/tr/th[1]" )
	public WebElement productNameRow;
	
	@FindBy(xpath="//tbody/tr/th[2]")
	public WebElement priceRow;
	
	@FindBy(xpath="//tbody/tr/th[3]")
	public WebElement discountRow;
	
	
}
