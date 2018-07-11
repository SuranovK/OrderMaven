package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsideOrderPage {
	
	public InsideOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[.='Web Orders']")   //"//h1[text()]
	public WebElement WebOrder;
	
	@FindBy(css=".login_info")
	public WebElement welcomeMsg;
	
	@FindBy(xpath="//h2[contains(.,'List of All Orders')]") //"//h2[.='List of All Orders']")
	public WebElement listOfAll;
	
	@FindBy(linkText="View all orders")
	public WebElement viewAllOrders;
	
	@FindBy(linkText="View all products")
	public WebElement viewAllProducts;
	
	@FindBy(linkText="Order")
	public WebElement ordersTab;
	
	@FindBy(id="ctl00_logout")
	public WebElement logOutClick;
	
	
	
	
	
	
	
	
	

}
