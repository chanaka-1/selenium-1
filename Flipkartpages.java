package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkartpages {
	WebDriver driver;
	@FindBy(linkText ="Login")
	WebElement loginlink;
	@FindBy(xpath ="//span[text()='Enter Email/Mobile number']/../../input")
	WebElement untextfield;
	@FindBy(xpath ="//input[@type='password']")
	WebElement pwdtextfield;
	@FindBy(xpath ="//form[@autocomplete='on']/div[4]/button")
	WebElement loginbtn; 
	@FindBy(name="q")
	WebElement searchtextfield;
	@FindBy(xpath = "//div[text()='Logout']")
	WebElement logoutbtn;
	@FindBy(xpath = "//div[contains(text(),'Siddanagoud')]")
	WebElement username;
    @FindBy(xpath="//form[@method='GET']/div/button")
	WebElement magnifierbtn;  
	@FindBy(name="B_NuCI")
	WebElement title;
     @FindBy(xpath="//div[text()='SAMSUNG Galaxy F12 (Sky Blue, 64 GB)']")
	WebElement mobiles;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")
	WebElement partmobile;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")
	WebElement popular;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div")
	WebElement samsung;
	@FindBy(xpath="//div[text()='Specifications']/..")
	WebElement specification;

	@FindBy(xpath="//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/form[1]/button[1]")
	 WebElement buynow;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[1]/div/div[1]/div[2]/div[1]/div[2]/img")
	 WebElement  page;
	
	public WebElement getpage() {
		return page;
	}
	public WebElement getbuynow() {
		return buynow;
	}
	public WebDriver getDriver() {
		return driver;
	}

    public WebElement getLoginlink() {
		return loginlink;
	}
   public WebElement getUntextfield() {
		return untextfield;
	}

   public WebElement getPwdtextfield() {
		return pwdtextfield;
	}
   public WebElement getLoginbtn() {
		return loginbtn;
	}

  public WebElement getSearchtextfield() {
		return searchtextfield;
	}

   public WebElement getLogoutbtn() {
		return logoutbtn;
	}

  public WebElement getUsername() {
		return username;
	}


  public WebElement getMagnifierbtn() {
		return magnifierbtn;
	}

  public WebElement getTitle() {
		return title;
	}

  public WebElement getMobiles() {
		return mobiles;
	}

  public WebElement getPartmobile() {
		return partmobile;
	}
  public WebElement getspecification() {
		return specification;
	}

  public WebElement getPopular() {
		return popular;
	}

  public WebElement getSamsung() {
		return samsung;
	}

public Flipkartpages (WebDriver driver) {  
		PageFactory.initElements(driver,this);

	}
}

