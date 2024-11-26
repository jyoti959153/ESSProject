package com.ESS.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class RetryAnalyserListenerImplementClass implements ITestListener,ISuiteListener ,IRetryAnalyzer{
	int count=0;
	int countLimit=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<countLimit)
		{
		count++;
		return true;
		}
		
		return false;
	}
	

}
