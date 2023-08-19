package LumaProject.LumaProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("C:\\Program Files\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		
		File file = new File(System.getProperty("C:\\Users\\Naidu\\eclipse-workspace\\LumaProject\\test data\\Book1.N.xlsx"));
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("sheet1");
		
		XSSFRow row = null;
		XSSFCell cell = null;
		String username = null;
		String password = null;
		
		for(int i=1; i<=sheet.getLastRowNum();i++) {
		row = sheet.getRow(i);
		for(int j=0; j<row.getLastCellNum();j++) {
			cell =row.getCell(j);
			
			if(j==0) {
				username = cell.getStringCellValue();
			}
			if(j==1) {
				password = cell.getStringCellValue();
			}
			
		}
	}
		System.out.println("userName:"+username + "--->"+"password:"+password);
		WebElement email = driver.findElement(By.id("email"));
		 email.sendKeys(username);
		 
		 WebElement pass = driver.findElement(By.id("pass"));
		 pass.sendKeys(password);
		 
		 WebElement signbtn = driver.findElement(By.name("send"));
		 signbtn.click();
		 
		 WebDriverWait wait = new WebDriverWait(driver , 10);
		 WebElement CustomerLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text ()='Customer Login']")));
		 
		 if ( CustomerLogin.getText().contains(" CustomerLogin")) {
			 System.out.println("Login sucessfull for username: "+ username);
		 }
		 else {
			 System.out.println("login failed for username:"+ username);
		 }
		 
		 driver.close();
	}
	
	

}

