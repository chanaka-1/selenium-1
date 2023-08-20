package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
public static WebDriver driver ;

	
	@BeforeTest
	public void setup() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("C:\\Program Files\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
	
		
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		
}
	
}
