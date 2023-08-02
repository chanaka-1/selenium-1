package com.qa.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class Pageproductdetails extends  FlipkartBaseclass {

	@Test
	public void search() throws InterruptedException, AWTException { 
		fp.getSearchtextfield().clear(); 
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		fp.getSearchtextfield().sendKeys("mobiles");
		fp.getMagnifierbtn().click();
		Thread.sleep(1000);
		WebElement click =fp.getPartmobile();
		Thread.sleep(2000);
		a.doubleClick(click).perform(); 
		String aurl = driver.getCurrentUrl();
		String expurl="https://www.flipkart.com/realme-narzo-50i-carbon-black-32-gb/p/itm53fa214c23501?pid=MOBG6MY4QPAW6PQN&lid=LSTMOBG6MY4QPAW6PQNODSGXD&marketplace=FLIPKART&q=mobiles&store=tyy%2F4io&srno=s_1_1&otracker=AS_QueryStore_HistoryAutoSuggest_1_3_na_na_na&otracker1=AS_QueryStore_HistoryAutoSuggest_1_3_na_na_na&fm=SEARCH&iid=5c974c5e-4047-43d0-8b62-63ff7f65f0fe.MOBG6MY4QPAW6PQN.SEARCH&ppt=hp&ppn=homepage&ssid=2fk3me2nnk0000001642667652179&qH=eb4af0bf07c16429";
		s.assertEquals(aurl, expurl);
		System.out.println("successfuly mobile page is Displayed");
		Thread.sleep(2000);
		fp.getPopular().click();
		Thread.sleep(2000);
		fp.getSamsung().click();
		Thread.sleep(2000);
		System.out.println("specification page  is displayed");
	}

}