
package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.runner.Runner;
import com.ui.pages.FDDashboardPage;
import com.ui.pages.LoginPage;
import com.ui.pojo.CreateNewJobData;
import com.utils.Browser;
import com.utils.TestBase;

import static com.utils.TestUtils.*;

/**
 * @author Jatin
 *
 */
@Listeners({ com.listeners.UITestListners2.class })
public class VerifyJobCreation extends UITestBase {
	private LoginPage loginPage;
	private CreateNewJobData customerInformationForNewJob;
	private String job_number = "JOB_18372";

	@BeforeMethod(description = "setup of the Browser")
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME, Runner.m);
		wd = loginPage.getWd();
		customerInformationForNewJob = getCustomerInformationForNewJob();
	}

	@Test(groups = { "sanity" })
	public void createJobTest() {

		job_number = ((FDDashboardPage) loginPage.doLoginWith("iamfd", "password")).goToCreateJobPage()
				.createJobWith(customerInformationForNewJob);
		System.out.println(job_number);
		Assert.assertTrue(notNull(job_number));
	}

//	@Test
//	public void verifyIftheJobIsPresentInTable() {
//
//		Assert.assertTrue(loginPage.doLoginWith("iamfd", "password").getDataFromTheFDTable()
//				.checkIFJobIsPresentInTable(job_number));
//	}
}
