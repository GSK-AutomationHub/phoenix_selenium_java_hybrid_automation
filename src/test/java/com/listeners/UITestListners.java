/**
 * 
 */
package com.listeners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ui.tests.UITestBase;
import com.utils.TestBase;
import com.utils.TestUtils;

/**
 * @author Jatin
 *
 */
public class UITestListners extends UITestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Starting the Test *********" + result.getMethod().getMethodName());
		System.out.println("*********About the Test *********" + result.getMethod().getDescription());
		System.out.println("*********Priority Of Test *********" + result.getMethod().getPriority());
		System.out.println("******** Test Group *********" + Arrays.toString(result.getMethod().getGroups()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Test Passed :) *********" + result.getMethod().getMethodName());
		TestUtils.takeScreenshot(wd, result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtils.takeScreenshot(wd, result.getMethod().getMethodName());
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
