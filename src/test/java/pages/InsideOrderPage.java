package pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	public WebElement listOfAllOrders;
	
	@FindBy(linkText="View all orders")
	public WebElement viewAllOrders;
	
	@FindBy(linkText="View all products")
	public WebElement viewAllProducts;
	
	@FindBy(linkText="Order")
	public WebElement ordersTab;
	
	@FindBy(id="ctl00_logout")
	public WebElement logOutClick;
	
	
	@FindBy(xpath="//h2")
	public WebElement listOfProductsLabel;
	
	@FindBy(xpath="//tbody/tr/th[1]" )
	public WebElement productNameRow;
	
	@FindBy(xpath="//tbody/tr/th[2]")
	public WebElement priceRow;
	
	@FindBy(xpath="//tbody/tr/th[3]")
	public WebElement discountRow;
	
	@FindBy(xpath="//table[@class='ProductsTable']/tbody/tr/td[1]")
	public List<WebElement> products;
	
	@FindBy(xpath="//table[@class='ProductsTable']/tbody/tr")
	public List<WebElement>productsTable;
	
//	@FindBy(xpath="//tbody/tr/td[1]/h1")
//	public WebElement webOrderLabel;
	
	@FindBy(css=".cornerLeft")
	public WebElement orderLabel;
	
	@FindBy(xpath="//option[@value='MyMoney']")
	public WebElement myMoneyOption;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement pricePerUnit;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
	public WebElement discount;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement totall;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement calculateButton;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement customerName;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy(name="ctl00$MainContent$fmwOrder$TextBox4")
	public WebElement state;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zipCode;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList")
	public List<WebElement> ListOfcardType;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList_0")
	public WebElement visaCard;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList_1")
	public WebElement masterCard;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_cardList_2")
	public WebElement americanExpress;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNum;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expirDate;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement proceedButton;
	
	@FindBy(xpath="//input[@type='reset']")
	public WebElement resretButton;
	
	@FindBy(xpath="//tbody/tr/td/div/strong")
	public WebElement submitMsg;
	
	@FindBy(xpath="//tbody/tr[2]")
	public List<WebElement> listOfNewAddedData;
	
	
	

}
