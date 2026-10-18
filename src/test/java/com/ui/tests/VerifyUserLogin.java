/**
 * 
 */
package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.runner.Runner;
import com.ui.pages.FDDashboardPage;
import com.ui.pages.LoginPage;
import com.utils.Browser;
import com.utils.Machine;

/**
 * @author Jatin
 *
 */
@Listeners({ com.listeners.UITestListners2.class })

public class VerifyUserLogin extends UITestBase {

	private LoginPage loginPage;

	@BeforeMethod(description = "setup of the Browser", alwaysRun = true)
	public void setup() {
		loginPage = new LoginPage(Browser.CHROME, Runner.m);
		wd = loginPage.getWd();
	}

	@Test(description = "Verify User Login", groups = { "sanity", "e2e", "smoke" })
	public void verifyUserLogin() {

		Assert.assertEquals(((FDDashboardPage) loginPage.doLoginWith("iamfd", "password")).getUserName(), "iamfd");

	}
}
