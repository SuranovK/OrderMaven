package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.PasswordAuthentication;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		assertTrue(allOrdersPage.listOfAll.isDisplayed());//,"List of all Orders label is displayed");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed());
		assertTrue(allOrdersPage.viewAllProducts.isDisplayed());
		assertTrue(allOrdersPage.ordersTab.isDisplayed(), "Orders are not displayed");
		
		
	}
}
