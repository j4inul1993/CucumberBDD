package com.readExcel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import ups.nj.supperpage.CucumberBaseClass;

public class CrossBrowserTesting extends CucumberBaseClass {

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginWebZooplaPage() throws IOException {
		driver.get("https://www.zoopla.co.uk/");
		driver.findElement(By.xpath("(//*[text()='Accept all cookies'])[2]")).click();
		driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();
		driver.findElement(By.cssSelector("#signin_email")).sendKeys("alammohammed79@gmail.com");
		driver.findElement(By.cssSelector("#signin_password")).sendKeys("SAYEDawan2008@");
		driver.findElement(By.id("signin_submit")).click();
	}

}
