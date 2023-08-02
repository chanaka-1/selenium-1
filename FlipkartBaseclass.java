package com.qa.testscripts;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Flipkartpages;
import com.qa.utility.Excelclass;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FlipkartBaseclass {

	WebDriver driver=null;
	Flipkartpages fp;
	Actions a;
	SoftAssert s=new SoftAssert();//verify the functionality
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser,String Url) {

		WebDriverManager.chromedriver().setup();
		if(Browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();

		}
		else if (Browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}

		else if (Browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}

		else if (Browser.equalsIgnoreCase("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url);
		fp=new Flipkartpages(driver);
	}

	@BeforeMethod 
	public void login() throws InterruptedException, IOException, AWTException {
		String file="C:\\Users\\HP\\eclipse-workspace\\TestAutomationflipkart\\src\\test\\java\\com\\qa\\testdata\\logincredential.xlsx";
		String sheetname="Sheet1";

		String number =Excelclass .getCellData(file, sheetname,1,0);
		String password=Excelclass .getCellData(file, sheetname,1,1);
		WebElement link = fp.getLoginlink();
		a=new Actions(driver);
		a.moveToElement(link).build().perform();
		fp.getUntextfield().sendKeys( number);
		fp.getPwdtextfield().sendKeys( password);
		fp.getLoginbtn().click();
		String atitle = driver.getTitle();
		String exptitle="Flipkart";
		boolean contain =atitle.contains( exptitle);
		if(contain ) {
			s.assertEquals(atitle, exptitle);
			System.out.println("successfuly Home page is Displayed");
		}
		else {
			captureScreenshot(driver,sheetname);
			s.assertFalse(true);
			Reporter.log("Homepage is not displayed");
		}
	}
	@AfterMethod
	public void logout() {
		WebElement l=fp.getUsername();
		a.doubleClick(l).build().perform();
		fp.getLogoutbtn().click();
	}
	@AfterClass
	public void tearDown() {
		driver.close();

	}
	public void captureScreenshot(WebDriver driver,String tname) throws IOException {
		TakesScreenshot s=(TakesScreenshot) driver;
		File src=s.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(src, new File(dest));
	}

}