package Com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



import Com.Utils.Readpropertyfile;



/*
 * Logic to retry test cases and no of retries depends on parameter from properties file
 */
public class RetryFailedTestCases implements IRetryAnalyzer{

	int counter=0;
	int limit=Integer.parseInt(Readpropertyfile.get("NoOfRetries"));

	@Override
	public boolean retry(ITestResult result) {
		if(counter<limit) {
			counter++;
			return true;
		}
		return false;
	}

}
