package ups.nj.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import ups.nj.supperpage.CucumberBaseClass;

public class Hooks extends CucumberBaseClass{

    
    @Before
    public void applicationStart() {
    	setUP();
    }
    
    
    @After   // This is Cucumber hooks
 	public void tearDown() {
 		driver.quit();
 	}
}
