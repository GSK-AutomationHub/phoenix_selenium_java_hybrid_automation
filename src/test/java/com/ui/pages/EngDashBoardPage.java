package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;


public class EngDashBoardPage extends DashboardPage{
	private static final By USER_ICON_BUTTON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name='user-circle']/../../..");
	private static final By SEARCH_BOX_LOCATOR = By.cssSelector("[placeholder='Search for a Job or IMEI']");
	private static final By PENDING_FOR_REPAIR_LOCATOR = By
			.xpath("//div[contains(text(),'Pending for repair')]/..//button");
	private static final By REPAIR_COMPLETED_LOCATOR = By
			.xpath("//div[contains(text(),'Repair completed')]/..//button");
	private static final By REPAIR_JOB_BUTTON_LOCATOR = By
			.xpath("//span[contains(text(),'Repair Job')]/../../..");
	private static final By REPAIR_JOB_COUNT_LOCATOR = By.xpath("//mat-table//mat-row");
	private static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Sign out')]/..");
	

	public EngDashBoardPage(WebDriver wd) {
		super(wd);
	}
	public String getUserName () {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'iameng')]"));
		clickOn(By.xpath("//span[contains(text(),'iameng')]"));
		return username;	
	}
	public String getJhowardUserName () {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getVisibleText(By.xpath("//span[contains(text(),'jhoward')]"));
		clickOn(By.xpath("//span[contains(text(),'jhoward')]"));
		return username;	
	}
	public GlobalListPage searchbyJOBIDorIMEI (String jobnumber) {
		enterText(SEARCH_BOX_LOCATOR, jobnumber);
		hitEnter(SEARCH_BOX_LOCATOR);
		GlobalListPage globlelist  = new GlobalListPage(getWd());
		return globlelist;
	}
	public String getPendingForRepairCount() {
		String pendingforRepair = getVisibleText(PENDING_FOR_REPAIR_LOCATOR);
		return pendingforRepair;
	}
	public String getRepairCompletedCount() {
		String pendingforRepair = getVisibleText(REPAIR_COMPLETED_LOCATOR);
		return pendingforRepair;
	}
	public RepairJobPage clickOnRepairJob() {
		clickOn(REPAIR_JOB_BUTTON_LOCATOR);
		RepairJobPage eng = new RepairJobPage(getWd());
		return eng;
	}
	public String getRepairJobCount() {
		clickOn(REPAIR_JOB_BUTTON_LOCATOR);
		List<WebElement> jobCount = fetchMultipleElements(REPAIR_JOB_COUNT_LOCATOR);
		int count = jobCount.size();
		return Integer.toString(count);
	}
	public String goToSignOutButton() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'Sign out')]"));
		clickOn(SIGN_OUT_BUTTON_LOCATOR);
		return username;
	}


}
