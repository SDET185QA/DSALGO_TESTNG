package utilities;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyser implements IRetryAnalyzer {

	private static String retrylimitString = null;
	public int retryCount = 0;

	@Override
	public boolean retry(ITestResult result) {
		retrylimitString =ConfigReader.getRetryAnalyserLimit();
		Integer retrylimit = Integer.valueOf(retrylimitString);
		if (retryCount < retrylimit) {
			retryCount++;
			
			System.out.println("Retrying test "+ result.getName() +" - "+retryCount);
			return true;
		}

		return false;
	}

}
