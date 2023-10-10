package pageObjects;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Signup {

	public WebDriver driver;
	private By Log_Sign = By.xpath("(//ul[@class='header links']/li)[2]");
	private By Email = By.xpath("//input[@id='email']");
	private By Password = By.xpath("//input[@name='login[password]']");
	private By Sign_in = By.xpath("(//button[@name='send'])[1]");
	private By LogOut = By.xpath("(//li[@class='authorization-link'])[1]");
	private By Namevalidated = By.xpath("(//li[@class='greet welcome']//span)[1]");
	private By UserDropdown = By.xpath("(//li[@class='customer-welcome'])[1]");
	private By SearchField = By.xpath("//input[@id='search']");
	private By Cart = By.xpath("//a[@class='action showcart']");
	private By ViewCart = By.xpath("//a[@class='action viewcart']");
	private By CheckOut = By.xpath("//button//span[text()='Proceed to Checkout']");
	private By Next = By.xpath("//button//span[text()='Next']");
	private By Place_Order = By.xpath("//button//span[text()='Place Order']");

	public Login_Signup(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement sign() {
		return driver.findElement(Log_Sign);
	}

	public WebElement Place_Order() {
		return driver.findElement(Place_Order);
	}

	public WebElement Next() {
		return driver.findElement(Next);
	}

	public WebElement CheckOut() {
		return driver.findElement(CheckOut);
	}

	public WebElement Cart() {
		return driver.findElement(Cart);
	}

	public WebElement ViewCart() {
		return driver.findElement(ViewCart);
	}

	public WebElement SearchField() {
		return driver.findElement(SearchField);
	}

	public WebElement Gmail() {
		return driver.findElement(Email);
	}

	public WebElement pwd() {
		return driver.findElement(Password);
	}

	public WebDriver loginfailedalert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {

		}
		return driver;
	}

	public WebElement Namevalidated() {
		return driver.findElement(Namevalidated);
	}

	public WebElement UserDropdown() {
		return driver.findElement(UserDropdown);
	}

	public WebElement Sign_in() {
		return driver.findElement(Sign_in);
	}

	public WebElement LogOut_Button() {
		return driver.findElement(LogOut);
	}

	public void pagetolaod(WebDriver driver, long time) {
		Wait<WebDriver> wait = new WebDriverWait(driver, time);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

}
