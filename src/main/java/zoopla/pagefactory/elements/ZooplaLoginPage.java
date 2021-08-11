package zoopla.pagefactory.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ups.nj.supperpage.CucumberBaseClass;

public class ZooplaLoginPage extends CucumberBaseClass {

	public ZooplaLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[text()='Sign in'])[5]")
	@CacheLookup
	private WebElement clickingSigninBTN;

	public WebElement getClickingSigninBTN() {
		return clickingSigninBTN;
	}

	@FindBy(xpath = "(//*[text()='Accept all cookies'])[2]")
	@CacheLookup
	private WebElement acceptCookies;

	public WebElement getAcceptCookies() {
		return acceptCookies;
	}

	@FindBy(xpath = "//*[@type='email']")
	@CacheLookup
	private WebElement sendUserName;

	public WebElement getsendUserName() {
		return sendUserName;
	}

	@FindBy(xpath = "//*[@type='password']")
	@CacheLookup
	private WebElement sendPwd;

	public WebElement getPwd() {
		return sendPwd;
	}
	
	@FindBy (xpath = "//*[@data-testid='price']")
	@CacheLookup
	private WebElement verifyPrice;
	public WebElement getVerifyThePrice() {
		return verifyPrice;
	}

	@FindBy(id = "search-input-location")
	@CacheLookup
	private WebElement searchLocation;

	public WebElement getSearchLocation() {
		return searchLocation;
	}
	
	public void getElement() {
		List<WebElement> price = driver.findElements(By.xpath("//*[@size='6']"));
	    System.out.println("Total property counting Num : "+ price.size());
	    for (WebElement value : price) {
	    	String priceValue = value.getText(); // getAttribute();	getText();   	
	    	System.out.println("Property Price List : "+ priceValue);
	    }
	    
	}
	public void clickOnProperty() {
		List<WebElement> element = driver.findElements(By.xpath("//*[@class='css-wfndrn-StyledContent e2uk8e18']"));
		for (int i =0; i <element.size(); i++) {
			if(i > 5) {
				System.out.println("Selected property number : " + i);
				element.get(i).click();
				break;
			}
		}
			
		    }
	     
	
	}

