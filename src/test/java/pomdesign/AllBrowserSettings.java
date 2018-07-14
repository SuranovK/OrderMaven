package pomdesign;

import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.LogOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.InsideOrderPage;

public class AllBrowserSettings {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
				//Setting up web browser 
				System.out.println("Setting up WebDriver in BeforeClass...");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().fullscreen();
				
	}
//	@AfterMethod
//	
//	public void LogOut() { 
//		InsideOrderPage insideOrderPage = new InsideOrderPage(driver);
//		insideOrderPage.logOutClick.click();
		
//	}

	@AfterClass
	public void teasdown() {
		driver.quit();
	}
	
}
