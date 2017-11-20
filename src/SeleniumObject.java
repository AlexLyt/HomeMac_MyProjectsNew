import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SeleniumObject {
	WebDriver wd;

	
		
	@BeforeClass
		public void SetUp (){
		
		System.out.println("Firefox started");
		System.setProperty("webdriver.gecko.driver", "/Users/alexlytvynenko/Desktop/Alex's/Selenium/SeleniumSetUp/geckodriver");
	    wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	@Test
		public void testGooglePageTitleInIEBrowser() {
		
			 wd.navigate().to("http://www.google.com");

			String strPageTitle = wd.getTitle();
			System.out.println("Page title: - "+strPageTitle);
			Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		}

	@AfterClass		
	public void tearDown() {
			if(wd!=null) {
				System.out.println("Closing chrome browser");
				wd.quit();
			}
		}
		
	}
