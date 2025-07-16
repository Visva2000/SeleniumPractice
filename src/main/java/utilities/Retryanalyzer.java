package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyzer implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private final int maxRetryCount = 3;
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount){
			retryCount++;
			
			result.setAttribute("isRetry", true); // to skip retry part in Extent Report
			return true;
		}
		return false;
	}
	
	
}
