package com.ui.tests;

import static com.utils.TestUtils.notNull;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.runner.Runner;
import com.ui.pages.CreateJobPage;
import com.ui.pages.DashboardPage;
import com.ui.pages.DownloadDeliveryNotePage;
import com.ui.pages.EngDashBoardPage;
import com.ui.pages.FDDashboardPage;
import com.ui.pages.GlobalDetailsPage;
import com.ui.pages.JobAssignmentPage;
import com.ui.pages.LoginPage;
import com.ui.pages.QcDashBoardPage;
import com.ui.pages.QualityCheckBeginPage;
import com.ui.pages.RepairJobBeginPage;
import com.ui.pages.SupDashBoardPage;
import com.ui.pojo.CreateNewJobData;
import com.utils.Browser;
import com.utils.TestUtils;

@Listeners({ com.listeners.UITestListners2.class })

public class PhoenixInWarrantyFlowTest extends UITestBase {
	private LoginPage loginPage;
	private FDDashboardPage fdDashBoardPage;
	private CreateJobPage createjobpage;
	private String job_ID;
	private SupDashBoardPage supDashBoardPage;
	private EngDashBoardPage engDashBoardPage;
	private RepairJobBeginPage repairjobpage;
	private QcDashBoardPage qcDashBoardPage;
	private QualityCheckBeginPage qcCheckBeginPage;
	private String deliveryPopUp;
	private DownloadDeliveryNotePage downloadDeliveryNotePage;

	@BeforeClass(description = "Verify Open Browser and Load Page", alwaysRun = true)
	public void loadPageTest() {
		loginPage = new LoginPage(Browser.CHROME, Runner.m);
		wd = loginPage.getWd();

	}

	@Test(description = "Verify FD Login User Name", groups = { "e2e", "ui", "sanity" }, priority = 1)
	public void verifyFDLoginUserNameTest() {
		fdDashBoardPage = (FDDashboardPage) loginPage.doLoginWith("iamfd", "password");
		Assert.assertEquals(fdDashBoardPage.getUserName(), "iamfd");
	}

	@Test(description = "Match Pending & Ready For Delivery Count ", groups = { "ui" }, priority = 2)
	public void matchPendingAndReadyForDeliveryTest() {
		Assert.assertEquals(fdDashBoardPage.getCountPendingForDelivery(), fdDashBoardPage.getCountReadyForDelivery());
	}

	@Test(description = "Verify Create Job Test", groups = { "sanity" }, priority = 3)
	public void verifyCreateJobTest() {
		CreateNewJobData createNewJobData = TestUtils.getCustomerInformationForNewJob();
		String job_number = fdDashBoardPage.goToCreateJobPage().createJobWith(createNewJobData);
		System.out.println(job_number);
		Assert.assertTrue(notNull(job_number));
	}

	@Test(description = "Verify Search Job & Global Details Test", groups = { "sanity" }, priority = 4)
	public void verifyFDSearchJobAndGlobalDetailsTest() {
		GlobalDetailsPage globaldetails = fdDashBoardPage.searchbyJOBIDorIMEI(job_ID).clickOnJobNumber();
		Assert.assertEquals(globaldetails.getJobDetails().getOem(), "Google");
		Assert.assertEquals(globaldetails.getcustomerDetails().getName(), "Abhishek Yadav");
		Assert.assertEquals(globaldetails.getActionStatus().get(1).getActionStatus(), "Pending For Job Assignment");
	}

	@Test(description = "Verify Sign Out", groups = { "e2e", "ui", "sanity" }, priority = 5)
	public void verifyFDSignOutTest() {
		Assert.assertEquals(fdDashBoardPage.goToSignOutButton(), "Sign out");
	}

	@Test(description = "Verify Sup Login User Name", groups = { "e2e", "ui", "sanity" }, priority = 6)
	public void verifySupLoginUserNameTest() {
		supDashBoardPage = (SupDashBoardPage) loginPage.doLoginWith("iamsup", "password");
		Assert.assertEquals(supDashBoardPage.getUserName(), "iamsup");
	}

	@Test(description = "Match Pending & Job For Assignment Count ", groups = { "ui", "smoke" }, priority = 7)
	public void matchPendingandJobForAssignmentTest() {
		Assert.assertEquals(supDashBoardPage.getCountPendingForAssignment(), supDashBoardPage.getCountJobAssignment());
	}

	@Test(description = "Verify Job Assign Successfully", groups = { "sanity" }, priority = 8)
	public void verifyJobAssignSuccessfullyTest() {
		JobAssignmentPage jobAssign = supDashBoardPage.goToJobAssignment().selectEngMarkzuk(job_ID);
		Assert.assertEquals(jobAssign.getAssignPopupText(), "Job assigned successfully");
	}

	@Test(description = "Verify Search Job & Global Details Test", groups = { "e2e", "ui", "smoke" }, priority = 9)
	public void verifySupSearchJobAndGlobalDetailsTest() {
		GlobalDetailsPage globaldetails = supDashBoardPage.searchbyJOBIDorIMEI(job_ID).clickOnJobNumber();
		Assert.assertEquals(globaldetails.getJobDetails().getOem(), "Google");
		Assert.assertEquals(globaldetails.getcustomerDetails().getName(), "Abhishek Yadav");
		Assert.assertEquals(globaldetails.getActionStatus().get(2).getActionStatus(), "Pending For Repair");
	}

	@Test(description = "Verify Sign Out", groups = { "e2e", "ui", "sanity" }, priority = 10)
	public void verifySupSignOutTest() {
		Assert.assertEquals(fdDashBoardPage.goToSignOutButton(), "Sign out");
	}

	@Test(description = "Verify Eng Login User Name", groups = { "e2e", "ui", "sanity" }, priority = 11)
	public void verifyEngLoginUserNameTest() {
		engDashBoardPage = (EngDashBoardPage) loginPage.doLoginWith("iameng", "password");
		Assert.assertEquals(engDashBoardPage.getUserName(), "iameng");
	}

	// test failing miss match count.
	@Test(description = "Match Pending & Repair Job Count ", groups = {  "ui", "sanity", "smoke"}, priority = 12)
	public void matchPendingandRepairJobCountTest() {
		Assert.assertEquals(engDashBoardPage.getPendingForRepairCount(), engDashBoardPage.getRepairJobCount());
	}

	@Test(description = "Verify Repair Job Completed", groups = { "ui", "sanity", "smoke" }, priority = 13)
	public void verifyRepairJobTest() {
		repairjobpage = engDashBoardPage.clickOnRepairJob().clickOnBeginRepairButton(job_ID).addingSelectProblem()
				.addingRemak().clickOnSubmit();
		Assert.assertEquals(repairjobpage.getPopUpText(), "Job repaired successfully");
	}

	@Test(description = "Verify Search Job & Global Details Test", groups = { "e2e", "ui", "smoke" }, priority = 14)
	public void verifyEngSearchJobAndGlobalDetailsTest() {
		GlobalDetailsPage globaldetails = engDashBoardPage.searchbyJOBIDorIMEI(job_ID).clickOnJobNumber();
		Assert.assertEquals(globaldetails.getJobDetails().getOem(), "Google");
		Assert.assertEquals(globaldetails.getcustomerDetails().getName(), "Abhishek Yadav");
		Assert.assertEquals(globaldetails.getActionStatus().get(3).getActionStatus(), "Pending For QC");
	}

	@Test(description = "Verify Sign Out", groups = { "e2e", "ui", "sanity" }, priority = 15)
	public void verifyEngSignOutTest() {
		Assert.assertEquals(engDashBoardPage.goToSignOutButton(), "Sign out");
	}

	@Test(description = "Verify QC Login User Name", groups = { "e2e", "ui", "sanity" }, priority = 16)
	public void verifyQCLoginUserNameTest() {
		qcDashBoardPage = (QcDashBoardPage) loginPage.doLoginWith("iamqc", "password");
		Assert.assertEquals(qcDashBoardPage.getUserName(), "iamqc");
	}

	@Test(description = "Match Pending For Qc & Quality Check Count ", groups = { "ui", "smoke" }, priority = 17)
	public void matchPendingForQcAndQualityCheckCountTest() {
		Assert.assertEquals(qcDashBoardPage.getPendingForQcCount(), qcDashBoardPage.getQualityCheckCount());
	}

	@Test(description = "Verify Begin QC Test", groups = { "ui", "e2e", "sanity" }, priority = 18)
	public void verifyBeginQcTest() {
		qcCheckBeginPage = qcDashBoardPage.goToQualityCheck().clickOnBeginQcButton(job_ID).clickOnSubmitButton();
		Assert.assertEquals(qcCheckBeginPage.getPopUpText(), "QC done successfully");
	}

	@Test(description = "Verify Search Job & Global Details Test", groups = { "sanity" }, priority = 19)
	public void verifyQcSearchJobAndGlobalDetailsTest() {
		GlobalDetailsPage globaldetails = qcDashBoardPage.searchbyJOBIDorIMEI(job_ID).clickOnJobNumber();
		Assert.assertEquals(globaldetails.getJobDetails().getOem(), "Google");
		Assert.assertEquals(globaldetails.getcustomerDetails().getName(), "Abhishek Yadav");
		Assert.assertEquals(globaldetails.getActionStatus().get(4).getActionStatus(), "Pending for Delivery");
	}

	@Test(description = "Verify Sign Out", groups = { "e2e", "ui", "sanity" }, priority = 20)
	public void verifySignOutTest() {
		Assert.assertEquals(qcDashBoardPage.goToSignOutButton(), "Sign out");
	}

	@Test(description = "Verify Delivery Login User Name", groups = { "e2e", "ui", "sanity" }, priority = 21)
	public void verifyDeliveryLoginUserNameTest() {
		fdDashBoardPage = (FDDashboardPage) loginPage.doLoginWith("iamfd", "password");
		Assert.assertEquals(fdDashBoardPage.getUserName(), "iamfd");
	}

	@Test(description = "Verify Job Close Succesfully ", groups = { "sanity" }, priority = 22)
	public void verifyJobCloseSuccesfullyTest() {
		deliveryPopUp = fdDashBoardPage.goToReadyForDelivery().clickOnJobCloseButton(job_ID).getDeliveryPopUpText();
		Assert.assertEquals(deliveryPopUp, "Job delivered successfully");
	}

	@Test(description = "Verify Download Delivery Note ", groups = { "e2e", "ui", "sanity" }, priority = 23)
	public void verifyDownloadDeliveryNoteTest() {
		downloadDeliveryNotePage = fdDashBoardPage.goToDownloadDeliveryNote().enterJobID(job_ID).clickOnSubmit();
		Assert.assertEquals(downloadDeliveryNotePage.getJobFoundPopUpText(), "Job found successfully");
		System.out.println(downloadDeliveryNotePage.getJobInformation());
	}

	@Test(description = "Verify Delivery Search Job & Global Details Test", groups = { "sanity" }, priority = 24)
	public void verifyDeliverySearchJobAndGlobalDetailsTest() throws InterruptedException {
		GlobalDetailsPage globaldetails = fdDashBoardPage.searchbyJOBIDorIMEI(job_ID).clickOnJobNumber();
		Assert.assertEquals(globaldetails.getJobDetails().getOem(), "Google");
		Assert.assertEquals(globaldetails.getActionStatus().get(5).getActionStatus(), "Delivered to customer");
		Assert.assertEquals(globaldetails.getcustomerDetails().getName(), "Abhishek Yadav");
		Assert.assertEquals(globaldetails.getActionStatus().get(6).getActionStatus(), "Job Closed Successfully");
	}

	@Test(description = "Verify Sign Out as Delivery", groups = { "e2e", "ui", "sanity" }, priority = 25,dependsOnMethods = "verifyDeliverySearchJobAndGlobalDetailsTest")
	public void verifyDeliverySignOutTest() {
		Assert.assertEquals(fdDashBoardPage.goToSignOutButton(), "Sign out");
	}

	@AfterClass(description = "Closing the Browser", alwaysRun = true)
	public void closeTheBrowserTest() {
		loginPage.shutDown();
	}

}
