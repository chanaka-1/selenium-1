package LumaProject.LumaProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Naidu {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("C:\\Program Files\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("chanakavenkatesh@mail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys("Venkatesh@716");
		System.out.println(driver.getTitle());
		 WebElement signbtn = driver.findElement(By.name("send"));
		 signbtn.click();
		 
		 WebDriverWait wait = new WebDriverWait(driver , 10);
		 WebElement Customer  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text ()='Customer Login']")));
		 
		 if ( Customer.getText().contains(" CustomerLogin")) {
			 System.out.println("Login sucessfull for username: ");
		 }
		 else {
			 System.out.println("login failed for username:");
		 }
		
		driver.close();
		
}

	}


