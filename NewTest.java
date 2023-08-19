package LumaProject.LumaProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTest {

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
		driver.findElement(By.id("email")).sendKeys("killer123@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys("Killer@123");
		System.out.println(driver.getTitle());
		 WebElement signbtn = driver.findElement(By.name("send"));
			Thread.sleep(3000);
		 signbtn.click();
			Thread.sleep(3000);
			String actTitle = driver.getTitle();
			System.out.println(actTitle);
			String ExpectTitle = "Home Page";
			
			if(actTitle.contains(ExpectTitle)) {
				System.out.println("login sucessfull");
				
			}
			else {
				System.out.println("login fail");
			}
		driver.findElement(By.id("search")).sendKeys("jackets for men");
		driver.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]"
				+ "/div[2]/div[2]/ol/li[6]/div/div/strong/a")).click();
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-50\"]")).click();
		driver.findElement(By.xpath("//span[text() ='Add to Cart']")).click();
		Thread.sleep(3000);
		String actTitle1 = driver.getTitle();
		System.out.println(actTitle1);
		String ExpectTitle1 = "Jupiter All-Weather Trainer";
		
		if(actTitle1.contains(ExpectTitle1)) {
			System.out.println("Item added to cart");
			
		}
		else {
			System.out.println("item not added to cart");
		}
		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		
		String actTitle2 = driver.getTitle();
		System.out.println(actTitle2);
		String ExpectTitle2 = "Checkout";
		
		if(actTitle2.contains(ExpectTitle2)) {
			System.out.println("sucesfully checkout order details");
			
		}
		else {
			System.out.println("sucesfully not checkout order details");
		}
		
		driver.close();
	}

}
