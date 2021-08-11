package com.readExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class TextFileReading {
	public static Logger logger;
	public static Properties prop;
	public static WebDriver driver;
 
	public static void initialization() throws Throwable {
		// Loading Config.properties file steps
		prop = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		prop.load(configPropfile);
		// Loading Config.properties file is done
		String br = prop.getProperty("browser");
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			
		} else if (br.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			System.setProperty("webdriver.chrome.driver", "chrome");
			driver = new ChromeDriver();
			
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", prop.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));

	}

	@Test
	public static void main() throws Throwable{
		TextFileReading.initialization();
		driver.findElement(By.xpath("(//*[text()='Accept all cookies'])[2]")).click();
		driver.findElement(By.xpath("(//*[text()='Sign in'])[1]")).click();
		driver.findElement(By.cssSelector("#signin_email")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.cssSelector("#signin_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("signin_submit")).click();
	}
}
