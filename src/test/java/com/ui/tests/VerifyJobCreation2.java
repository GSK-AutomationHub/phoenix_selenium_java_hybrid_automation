/**
 * 
 */
package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.pojo.CreateNewJob;
import com.runner.Runner;
import com.ui.pages.FDDashboardPage;
import com.ui.pages.LoginPage;
import com.ui.pojo.CreateNewJobData;
import com.ui.pojo.FDDashBoardTablePOJO;
import com.utils.Browser;
import com.utils.Machine;
import com.utils.TestUtils;

import static com.utils.TestUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jatin
 *
 */
@Listeners({ com.listeners.UITestListners2.class })

public final class VerifyJobCreation2 extends UITestBase {
	private LoginPage loginPage;
	private CreateNewJobData createNewJobData;
	private String job_number = "JOB_18372";

	@BeforeMethod(description = "setup of the Browser", alwaysRun = true)
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME, Runner.m);
		wd = loginPage.getWd();
		createNewJobData = TestUtils.getCustomerInformationForNewJob();
	}

	@Test(groups = { "sanity", "e2e", "smoke" })
	public void createJobTest() {
		job_number = ((FDDashboardPage) loginPage.doLoginWith("iamfd", "password")).goToCreateJobPage().createJobWith(createNewJobData);
		Assert.assertTrue(notNull(job_number));
	}

}
