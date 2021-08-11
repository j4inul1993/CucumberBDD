package ups.nj.listener;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.CommonUtility;

public class TestListener implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("I  am in onStart method  :"+ result.getName());	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I  am in onSuccess method  :"+ result.getName());	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" Test failed  :"+ result.getName());	
		try {
			CommonUtility.takeScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
