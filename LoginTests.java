package HomePageTests;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.Login_Signup;
import resources.base;

public class LoginTests extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	public Login_Signup Ls;

	@BeforeClass
	public void initialize() throws Exception {
		driver = initializeDriver();
	}

	@Test(priority = 0)
	public void Login() throws Exception {
		driver.navigate().to(prop.getProperty("Url"));
		Ls = new Login_Signup(driver);
		Ls.sign().click();
		Thread.sleep(10000);
		Ls.Gmail().sendKeys("potaho@hexi.pics");
		Thread.sleep(2000);
		Ls.pwd().sendKeys("Test@98560");
		Ls.Sign_in().click();
		Thread.sleep(5000);
		Ls.pagetolaod(driver, 100);
		Assert.assertEquals(prop.getProperty("Url"), driver.getCurrentUrl());
		getScreenShotPath("Login", driver);
		String Name = Ls.Namevalidated().getText();
		if (Name.contains("SudheerKumar")) {
			System.out.println(" UserName is Validated Successfully ");
		}
	}

	@Test(priority = 1)
	public void SearchProducts() throws Exception {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\data\\ProductsData.xlsx";
		HashMap<String, String> Data = resources.ExcelUtils.getexceldata(path, "Prod", "ProductName");
		ArrayList<String> Values = new ArrayList<>();
		Values.addAll(Data.values());
		System.out.println(Values);
		int size = Values.size();
		for (int i = 0; i < size; i++) {
			Ls.SearchField().sendKeys(Values.get(i));
			Actions act1 = new Actions(driver);
			act1.sendKeys(Keys.ARROW_DOWN).perform();
			act1.sendKeys(Keys.ENTER).perform();
			Thread.sleep(3000);
			WebElement Element = driver.findElement(By.xpath("//a[contains(text(),'" + Values.get(i) + "')]"));
			act1.moveToElement(Element);
			Element.click();

			Ls.pagetolaod(driver, 100);
			WebElement Size = driver.findElement(By.xpath("//div[text()='L']"));
			Size.click();

			WebElement Color = driver.findElement(By.xpath("(//div[@class='swatch-option color'])[1]"));
			Color.click();

			WebElement CartAdd = driver.findElement(By.xpath("//button//span[text()='Add to Cart']"));
			CartAdd.click();
			Thread.sleep(10000);
			System.out
					.println(driver.findElement(By.xpath("(//a[@class='action showcart']/span)[2]/span[1]")).getText());
			Thread.sleep(2000);
		}
	}

	@Test(priority = 2)
	public void Navigate_to_Cart() throws Exception {
		Ls.Cart().click();
		Ls.pagetolaod(driver, 100);
		Thread.sleep(1000);
		Ls.ViewCart().click();
		Ls.pagetolaod(driver, 100);
		Thread.sleep(5000);
	}

	@Test(priority = 3)
	public void DeleteProducts() throws Exception {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\data\\ProductsData.xlsx";
		HashMap<String, String> Data = resources.ExcelUtils.getexceldata(path, "Prod1", "DeleteProduct");
		ArrayList<String> Values = new ArrayList<>();
		Values.addAll(Data.values());
		System.out.println(Values);
		int size = Values.size();
		for (int i = 0; i < size; i++) {
			WebElement Element = driver.findElement(
					By.xpath("(//a[contains(text(),'" + Values.get(i) + "')])[2]/../../../../../tr[2]/td/div/a[3]"));
			Element.click();
			Ls.pagetolaod(driver, 100);
			Thread.sleep(5000);
			System.out
					.println(driver.findElement(By.xpath("(//a[@class='action showcart']/span)[2]/span[1]")).getText());
			Thread.sleep(2000);
			Ls.pagetolaod(driver, 100);
		}
	}

	@Test(priority = 4)
	public void CheckOut() throws Exception {
		Ls.CheckOut().click();
		Thread.sleep(2000);
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\data\\ProductsData.xlsx";
		HashMap<String, String> Data = resources.ExcelUtils.getexceldata(path, "Shipping", "ShippingMethod");
		ArrayList<String> Values = new ArrayList<>();
		Values.addAll(Data.values());
		System.out.println(Values);
		if (Values.get(0).equalsIgnoreCase("Flat Rate")) {
			driver.findElement(By.xpath("(//td[text()='Flat Rate']/../../tr)[1]/td/input")).click();
			Ls.Next().click();
			Thread.sleep(5000);
		} else if (Values.get(0).equalsIgnoreCase("Best Way")) {
			driver.findElement(By.xpath("(//td[text()='Best Way']/../../tr)[2]/td/input")).click();
			Ls.Next().click();
			Thread.sleep(5000);
		}
		Ls.pagetolaod(driver, 100);
		Ls.Place_Order().click();
		Thread.sleep(10000);
		getScreenShotPath("OrderedPlaced", driver);
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='checkout-success']//p"));
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='checkout-success']//p//a"));
		System.out.println(ele1.getText() + ":::" + ele2.getText());
	}

	@Test(priority = 5)
	public void LogOut() throws Exception {
		Ls.UserDropdown().click();
		Thread.sleep(2000);
		Ls.LogOut_Button().click();
	}

	@AfterClass
	public void tear() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
