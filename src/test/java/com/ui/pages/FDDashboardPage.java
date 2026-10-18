/**
 * 
 */
package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojo.FDDashBoardTablePOJO;
import com.utils.BrowserUtility;
import com.utils.TestUtils;

/**
 * @author Jatin
 *
 */
public class FDDashboardPage extends DashboardPage {

	private static final By SEARCH_TEXT_BOX_LOCATOR = By
			.xpath("//input[@data-placeholder=\"Search for a Job or IMEI\"]"); // NoSuchElementException:

	private static final By USER_ICON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name=\"user-circle\"]");

	private static final By USERNAME_LOCATOR = By.xpath("//span[contains(text(),\"Signed in as\")]/../span[2]");
	private static final By CREATE_JOB_LINK_LOCATOR = By.xpath("//span[contains(text(),\"Create Job\")]/../../..");

	private static final By CREATED_JOB_TODAY = By.xpath("//div[contains(text(),\"Created today\")]/../div[1]/button");

	private static final By FD_DASHBOARD_TABLE = By.tagName("mat-table");

	private static final By PENDING_FOR_DELIVERY_LOCATOR = By
			.xpath("//div[contains(text(),'Pending for delivery')]/..//button");
	private static final By JOB_CREATED_TODAY_LOCATOR = By.xpath("//div[contains(text(),'Created today')]/..//button");
	private static final By READY_FOR_DELIVERY_COUNT_LOCATOR = By.xpath("//mat-table//mat-row");
	private static final By JOB_CREATED_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Create Job')]/../../..");
	private static final By USER_ICON_BUTTON_LOCATOR = By
			.xpath("//mat-icon[@data-mat-icon-name='user-circle']/../../..");
	private static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Sign out')]/..");
	private static final By DOWNLOAD_DELIVERY_NOTE_BUTTON_LOCATOR = By
			.xpath("//span[contains(text(),'Download Delivery Note')]/../../..");

	private ArrayList<FDDashBoardTablePOJO> data;

	public FDDashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchForJob(String viaJobNumberOrIMEI) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, viaJobNumberOrIMEI);
		enterText(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);

	}

	public FDDashboardPage and() {
		return new FDDashboardPage(getWd());
	}

	public CreateJobPage goToCreateJobPage() {
		clickOn(CREATE_JOB_LINK_LOCATOR);
		return new CreateJobPage(getWd());
	}

	public FDDashboardPage getDataFromTheFDTable() {
		data = getDataFromTable(CREATED_JOB_TODAY, FD_DASHBOARD_TABLE);
		return new FDDashboardPage(getWd());
	}

	public boolean checkIFJobIsPresentInTable(String jobNumber) {
		return TestUtils.searchForDataInList(data, jobNumber);
	}

	public GlobalListPage searchbyJOBIDorIMEI(String jobnumber) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, jobnumber);
		hitEnter(SEARCH_TEXT_BOX_LOCATOR);
		GlobalListPage globlelist = new GlobalListPage(getWd());
		return globlelist;
	}

	public GlobalListPage jobcreatedtoday() {
		String jobcreatedToday = getTextValue(JOB_CREATED_TODAY_LOCATOR);
		System.out.println("Job Created Today = " + jobcreatedToday);
		clickOn(JOB_CREATED_TODAY_LOCATOR);
		GlobalListPage globlelist = new GlobalListPage(getWd());
		return globlelist;
	}

	public String getCountPendingForDelivery() {
		String pendingforDelivery = getTextValue(PENDING_FOR_DELIVERY_LOCATOR);
		return pendingforDelivery;
	}

	public String getCountReadyForDelivery() {
		clickOn(By.xpath("//span[contains(text(),'Ready for delivery')]/../../.."));
		List<WebElement> readyCount = fetchMultipleElements(READY_FOR_DELIVERY_COUNT_LOCATOR);
		int count = readyCount.size();
		return Integer.toString(count);
	}

	public CreateJobPage clickOnCreateJob() {
		clickOn(JOB_CREATED_BUTTON_LOCATOR);
		CreateJobPage createjob = new CreateJobPage(getWd());
		return createjob;
	}

	public String getUserName() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'iamfd')]"));
		clickOn(By.xpath("//span[contains(text(),'iamfd')]"));
		return username;
	}

	public String goToSignOutButton() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'Sign out')]"));
		clickOn(SIGN_OUT_BUTTON_LOCATOR);
		return username;
	}

	public ReadyForDeliveryPage goToReadyForDelivery() {
		clickOn(By.xpath("//span[contains(text(),'Ready for delivery')]/../../.."));
		return new ReadyForDeliveryPage(getWd());
	}

	public DownloadDeliveryNotePage goToDownloadDeliveryNote() {
		clickOn(DOWNLOAD_DELIVERY_NOTE_BUTTON_LOCATOR);
		return new DownloadDeliveryNotePage(getWd());
	}

}
