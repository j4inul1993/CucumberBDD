package ups.nj.supperpage;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CucumberBaseClass {
	
	public static Logger logger;
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	public CucumberBaseClass() {
		logger = Logger.getLogger("Zoopla Automation"); // Added logger
		PropertyConfigurator.configure("log4j.properties");// Added logger
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/ups/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  
	public void setUP() {
		logger.info("******** > Test excuted with chrome browser  < ***********");
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
	}
}
