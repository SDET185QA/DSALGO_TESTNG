package utilities;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	public int retryCount = 0;
	public int retryLimit = 3;

	@Override
	public boolean retry(ITestResult result) {
		
		if (retryCount < retryLimit) {
			retryCount++;
			
			System.out.println("Retrying test "+ result.getName() +" - "+retryCount);
			return true;
		}

		return false;
	}

}
