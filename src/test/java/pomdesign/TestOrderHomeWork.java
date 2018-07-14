package pomdesign;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.LocalDate;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.DateAndTime;
import pages.InsideOrderPage;
import pages.WebOrderLoginPage;

public class TestOrderHomeWork extends AllBrowserSettings{
	
	WebOrderLoginPage loginPage;
	InsideOrderPage allOrdersPage;
	String userId = "Tester";
	String password = "test"; 
	
//	public String whichCard(String cardType) {
//		for (WebElement eachcardType : allOrdersPage.ListOfcardType) {
//			if(eachcardType.getAttribute("value")()==cardType) {
//			return cardType;
//			}else { 
//				return eachcardType.getAttribute("value");
//			}
//			}
//	}
//	
	
	@BeforeMethod
	public void setUpForMethod() {
	
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		//loginPage = new WebOrderLoginPage(driver);
		 
		
}
	public void login(String userName,String passKey) {
		loginPage = new WebOrderLoginPage(driver);
		loginPage.userName.sendKeys(userName);
		loginPage.password.sendKeys(passKey);
		loginPage.loginButton.click();
		
	}
	
	@Test(description = "Tessting verification of new added data")
	
	public void labelsVerifications() {
		
		//assertEquals(driver.getTitle(), "Web Orders","Does not signed in ");
		
//		loginPage.userName.sendKeys("Tester");
//		loginPage.password.sendKeys("test");
//		loginPage.loginButton.click();
		login(userId, password); 
		
		
		allOrdersPage = new InsideOrderPage(driver);
		String expectedText = "Welcome, " + userId +"!";
		System.out.println("expected: " + expectedText);
		System.out.println("actual: " + allOrdersPage.welcomeMsg.getText());
		 
		assertTrue(allOrdersPage.WebOrder.isDisplayed());//,"Web Order is not displayed"
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""),expectedText);//,"Welcome message is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed());//,"List of all Orders label is displayed");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed());
		assertTrue(allOrdersPage.viewAllProducts.isDisplayed());
		assertTrue(allOrdersPage.ordersTab.isDisplayed(), "Orders are not displayed");
		
		allOrdersPage.ordersTab.click();
		assertTrue(allOrdersPage.orderLabel.isDisplayed());
		String quant = "14";
		String custName = "Will Smith";
		String strt = "123 Avenue street";
		String cityName = "Houston";
		String stateName = "Texas";
		String zip = "72919";
		String carNumber = "12198890124356";
		String exDate = "20/20";
		
		allOrdersPage.myMoneyOption.click();
		AssertJUnit.assertTrue(allOrdersPage.myMoneyOption.isSelected());
		allOrdersPage.quantity.sendKeys(Keys.BACK_SPACE);
		allOrdersPage.quantity.sendKeys(quant);
		allOrdersPage.customerName.sendKeys(custName);
		allOrdersPage.street.sendKeys(strt);
		allOrdersPage.city.sendKeys(cityName);
		allOrdersPage.state.sendKeys(stateName);
		allOrdersPage.zipCode.sendKeys(zip);
		allOrdersPage.visaCard.click();
		allOrdersPage.cardNum.sendKeys(carNumber);
		allOrdersPage.expirDate.sendKeys(exDate);
		allOrdersPage.proceedButton.click();
		
		String productName = allOrdersPage.myMoneyOption.getAttribute("value");
			
		String date = LocalDate.now().toString();
		String cardType = allOrdersPage.visaCard.getAttribute("value");
		AssertJUnit.assertEquals(allOrdersPage.submitMsg.getText(), "New order has been successfully added.");
		
		
		allOrdersPage.viewAllOrders.click();
		AssertJUnit.assertTrue(allOrdersPage.listOfAllOrders.isDisplayed());
		 
		List<String>expectedData = new ArrayList<>();
		expectedData.add(custName);
		expectedData.add(productName);
		expectedData.add(quant);
		expectedData.add(date);
		expectedData.add(strt);
		expectedData.add(cityName);
		expectedData.add(stateName);
		expectedData.add(zip);
		expectedData.add(cardType);
		expectedData.add(carNumber);
		expectedData.add(exDate);
		
		System.out.println("EXPECTED LIST OF DATA");
		
		for (String eachExpec : expectedData) {
			System.out.println(eachExpec);
			
		}
		System.out.println("================================");
		System.out.println("ACTUAL LIST OF DATA");
		
		List<String>aData = new ArrayList<>();
		
		for (WebElement eachActual : allOrdersPage.listOfNewAddedData) {
			for(int i=0;i<aData.size();i++) {
				
			aData.add(eachActual.getText());
			
			}
			}
		for (String eachData : aData) {
			System.out.println(eachData);
		}
	
	//assertEquals(aData, expectedData);
	}

	
}	

			
		
		
		
		
		
	