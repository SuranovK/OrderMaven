package pomdesign;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InsideOrderPage;
import pages.VerifyingDataInsideOrderPage;
import pages.WebOrderLoginPage;

public class TestVerifyingDataInsideOrder extends AllBrowserSettings{
	WebOrderLoginPage loginPage;
	
	public void login(String userName,String passKey) {
		loginPage.userName.sendKeys(userName);
		loginPage.password.sendKeys(passKey);
		loginPage.loginButton.click();
	}
	@Test
	public void setUpForMethod() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage = new WebOrderLoginPage(driver);
		login("Tester", "test"); 
		
		
}
	

	
	public void VerifyingTable() {
	
		
		
		
	}
}
