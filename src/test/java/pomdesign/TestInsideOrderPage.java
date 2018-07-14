package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.InsideOrderPage;
import pages.WebOrderLoginPage;

public class TestInsideOrderPage extends AllBrowserSettings{
	
	WebOrderLoginPage loginPage;
	InsideOrderPage allOrdersPage;
	String userId = "Tester";
	String password = "test";
	 
	
	@BeforeMethod
	public void setUpForMethod() {
	
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage = new WebOrderLoginPage(driver);
		 
		 
}
	public void login(String userName,String passKey) {
		loginPage = new WebOrderLoginPage(driver);
		loginPage.userName.sendKeys(userName);
		loginPage.password.sendKeys(passKey);
		loginPage.loginButton.click();
		
	}
	
	@Test(description = "Testing our main testcase")
	
	public void labelsVerifications() {
		
		//assertEquals(driver.getTitle(), "Web Orders","Does not signed in ");
		
//		loginPage.userName.sendKeys("Tester");
//		loginPage.password.sendKeys("test");
//		loginPage.loginButton.click();
		login(userId, password); 
		
		
		allOrdersPage = new InsideOrderPage(driver);
		String expected = "Welcome, " + userId +"!";
		System.out.println("expected: " + expected);
		System.out.println("actual: " + allOrdersPage.welcomeMsg.getText());
		 
		assertTrue(allOrdersPage.WebOrder.isDisplayed());//,"Web Order is not displayed"
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""),expected);//,"Welcome message is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed());//,"List of all Orders label is displayed");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed());
		assertTrue(allOrdersPage.viewAllProducts.isDisplayed());
		assertTrue(allOrdersPage.ordersTab.isDisplayed(), "Orders are not displayed");
		
		allOrdersPage.viewAllProducts.click();
		assertTrue(allOrdersPage.listOfProductsLabel.isDisplayed());
		assertTrue(allOrdersPage.discountRow.isDisplayed());
		assertTrue(allOrdersPage.priceRow.isDisplayed());
		
		List<String>expectProd = Arrays.asList("MyMoney","FamilyAlbum","ScreenSaver");
		List<String>actualProd = new ArrayList<String>();
		
		//allOrdersPage.products.forEach(elem -> actualProd.add(elem.getText()));
		
		for (WebElement eachelement : allOrdersPage.products) {
			actualProd.add(eachelement.getText());
			System.out.println(eachelement.getText());
			
			}
		
		assertEquals(actualProd, expectProd);
		
		
		List<String> stringProductTable = new ArrayList<>();
		for (WebElement eachProdTable : allOrdersPage.productsTable) {
		
			System.out.println(eachProdTable.getText());
			String[] prodData = eachProdTable.getText().split(" ");
			
			switch(prodData[0]) {
			
			case "MyMoney":
				assertEquals(prodData[1], "$100");
				assertEquals(prodData[2], "8%");
				break;
				
				case "FamilyAlbum":
					assertEquals(prodData[1], "$80");
					assertEquals(prodData[2], "15%");
					break;
				case "ScreenSaver":
					assertEquals(prodData[1], "$20");
					assertEquals(prodData[2], "10%");
					break;
			}
				
			}
				
			//System.out.println(stringProductTable);
			
			
			
		
		
		
		
		
	}

	//@Test
	public void test1() {
		System.out.println("Hi");
		
	}


	@AfterMethod
	
	public void LogOut() {
		InsideOrderPage insideOrderPage = new InsideOrderPage(driver);
		insideOrderPage.logOutClick.click();
	
}
	
	}
