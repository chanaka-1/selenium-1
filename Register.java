package pageObjects;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {

	public WebDriver driver;
	private By Create_an_Account = By.xpath("(//ul[@class='header links']/li)[3]");
	private By firstname = By.xpath("//input[@id='firstname']");
	private By lastname = By.xpath("//input[@id='lastname']");
	private By email_address = By.xpath("//input[@id='email_address']");
	private By password = By.xpath("//input[@id='password']");
	private By password_confirmation = By.xpath("//input[@id='password-confirmation']");
	private By submit_button = By.xpath("(//button[@class='action submit primary']/.)[1]");
	private By Namevalidated = By.xpath("(//li[@class='greet welcome']//span)[1]");
	private By UserDropdown = By.xpath("(//li[@class='customer-welcome'])[1]");
	private By LogOut = By.xpath("(//li[@class='authorization-link'])[1]");

	public Register(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Create_Account() {
		return driver.findElement(Create_an_Account);
	}

	public WebElement first_name() {
		return driver.findElement(firstname);
	}

	public WebElement last_name() {
		return driver.findElement(lastname);
	}

	public WebElement emailaddress() {
		return driver.findElement(email_address);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement passwordconfirmation() {
		return driver.findElement(password_confirmation);
	}

	public WebElement submit() {
		return driver.findElement(submit_button);
	}

	public WebElement Namevalidated() {
		return driver.findElement(Namevalidated);
	}

	public WebElement UserDropdown() {
		return driver.findElement(UserDropdown);
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
