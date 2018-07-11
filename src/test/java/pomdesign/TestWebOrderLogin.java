package pomdesign;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.WebOrderLoginPage;

public class TestWebOrderLogin extends AllBrowserSettings {
	
	
	@Ignore
	@Test
	public void positiveLoginTest() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
		
	}
	@Test(priority = 1)
	public void positiveLoginTestUsingPOM() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.userName.sendKeys("Tester");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();
		
		String expectTitle = "Web Orders";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectTitle);

		System.out.println("Happy pass actual title " + actualTitle);
	}
	
	@Test(priority = 2)
	
	public void InvalidUserNameTest() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.userName.sendKeys("Invalid");
		loginPage.password.sendKeys("test");
		loginPage.loginButton.click();
		String errormsg = loginPage.InvldUserNameErrMsg.getText();
	
		assertEquals(errormsg, "Invalid Login or Password.");
		System.out.println("Invalid username error message " + errormsg);
	
	}
	
	@Test (priority = 3)
	public void InvalidPasswordTeste() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
		loginPage.userName.sendKeys("Tester");
		loginPage.password.sendKeys("invalid");
		loginPage.loginButton.click();
		
		String errPaswwordMsg = loginPage.InvldPasswordErrMsg.getText();
		assertEquals(errPaswwordMsg, "Invalid Login or Password.");
		System.out.println("Invalid password error message " + errPaswwordMsg);
		
	}
	
	}
	
	


