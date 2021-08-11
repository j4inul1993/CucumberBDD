package com.readExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	WebDriver driver;
	
	
	@DataProvider(name = "Authentication")
	public static Object [][] credentials(){
		return new Object [][] {{"Alammohammed79@gmail.com", "SAYEDawan2008@"},
			                    {"Alammohammed79@gmail.com", "SAYEDawan2008@"}};
	}	
	@Test(dataProvider = "Authentication")
	public void testWebSite(String userName, String pwd) {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("https://www.zoopla.co.uk/");
				
		driver.findElement(By.xpath("(//*[text()='Accept all cookies'])[2]")).click();
		driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();

		driver.findElement(By.cssSelector("#signin_email")).sendKeys(userName);
		driver.findElement(By.cssSelector("#signin_password")).sendKeys(pwd);
		
		driver.findElement(By.id("signin_submit")).click();		
	}	
}
