package HomePageTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Register;
import resources.base;

public class RegisterTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	public Register Rs;

	@BeforeClass
	public void initialize() throws Exception {
		driver = initializeDriver();
	}

	@Test(priority = 0)
	public void Register() throws Exception {

		driver.navigate().to(prop.getProperty("Url"));
		Rs = new Register(driver);
		Rs.Create_Account().click();
		Rs.first_name().sendKeys("babu6");
		Rs.last_name().sendKeys("babu6");
		Rs.emailaddress().sendKeys("babu6@gmail.com");
		Rs.Password().sendKeys("Test@123");
		Rs.passwordconfirmation().sendKeys("Test@123");
		Rs.submit().click();
         Thread.sleep(2000);
		Rs.pagetolaod(driver, 100);
		Assert.assertEquals(prop.getProperty("HomapageURl"), driver.getCurrentUrl());
		getScreenShotPath("Login", driver);
		String Name = Rs.Namevalidated().getText();
		if (Name.contains("babu6babu6")) {
			System.out.println(" UserName is Validated Successfully ");
		}

	}

	@Test(priority = 1)
	public void LogOut() throws Exception {
		Rs.UserDropdown().click();
		Thread.sleep(2000);
		Rs.LogOut_Button().click();
		Thread.sleep(1000);
		
	}
	@AfterClass
	public void tear() {
		driver.manage().deleteAllCookies();
		driver.close();
	}


}
