/**
 * 
 */
package com.listeners;

import java.io.File;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.runner.Runner;
import com.ui.tests.UITestBase;
import com.utils.TestBase;
import com.utils.TestUtils;

/**
 * @author Jatin
 *
 */
public class UITestListners2 extends UITestBase implements ITestListener {

	ExtentReports extentReports;
	ExtentSparkReporter extentSparkReporter;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Starting the Test *********" + result.getMethod().getMethodName());
		System.out.println("*********About the Test *********" + result.getMethod().getDescription());
		System.out.println("*********Priority Of Test *********" + result.getMethod().getPriority());
		System.out.println("******** Test Group *********" + Arrays.toString(result.getMethod().getGroups()));
		test = extentReports.createTest(result.getMethod().getMethodName());
		
		test.assignCategory(Arrays.toString(result.getMethod().getGroups()));
		test.assignDevice(System.getProperty("os.name"), "Chrome", "Dev");
		
		test.log(Status.INFO, "********* Starting the Test *********" + result.getMethod().getMethodName());

		test.log(Status.INFO, "*********About the Test *********" + result.getMethod().getDescription());
		test.log(Status.INFO, "*********Priority Of Test *********" + result.getMethod().getPriority());
		test.log(Status.INFO, "******** Test Group *********" + Arrays.toString(result.getMethod().getGroups()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Test Passed :) *********" + result.getMethod().getMethodName());
		test.log(Status.PASS, "********* Test Passed *********" + result.getMethod().getMethodName());

		test.addScreenCaptureFromPath(TestUtils.takeScreenshot(wd, result.getMethod().getMethodName()));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtils.takeScreenshot(wd, result.getMethod().getMethodName());
		test.log(Status.FAIL, "*********Test Failed *********" + result.getMethod().getMethodName());

		test.addScreenCaptureFromPath(TestUtils.takeScreenshot(wd, result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, "********* Skipped Test *********" + result.getMethod().getMethodName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		extentSparkReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir")) + "//reports//report.html");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

	}

	@Override
	public synchronized void onFinish(ITestContext context) {

		extentReports.flush();
	}

}
