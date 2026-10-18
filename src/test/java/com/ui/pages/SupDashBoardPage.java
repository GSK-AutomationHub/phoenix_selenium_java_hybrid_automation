package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;


public class SupDashBoardPage extends DashboardPage {
	private static final By USER_ICON_BUTTON_LOCATOR = By.xpath("//mat-icon[@data-mat-icon-name='user-circle']/../../..");
	private static final By PENDING_FOR_ASSIGNMENT_LOCATOR = By
			.xpath("//div[contains(text(),'Pending for assignment')]/..//button");
	private static final By PENDING_FOR_REPAIR_LOCATOR = By
			.xpath("//div[contains(text(),'Pending for repair')]/..//button");
	private static final By JOB_ASSIGNMENT_COUNT_LOCATOR = By.xpath("//mat-row");
	private static final By JOB_ASSIGNMENT_BUTTON_LOCATOR = By
			.xpath("//span[contains(text(),'Job Assignment')]/../../..");
	private static final By PENDING_FOR_DELIVERY_LOCATOR = By
			.xpath("//div[contains(text(),'Pending for delivery')]/..//button");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.cssSelector("[placeholder='Search for a Job or IMEI']");
	private static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Sign out')]/..");

	public SupDashBoardPage(WebDriver wd) {
		super(wd);
	}

	public String getUserName() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'iamsup')]"));
		clickOn(By.xpath("//span[contains(text(),'iamsup')]"));
		return username;
	}
	public GlobalListPage searchbyJOBIDorIMEI (String jobnumber) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, jobnumber);
		hitEnter(SEARCH_TEXT_BOX_LOCATOR);
		GlobalListPage globlelist  = new GlobalListPage(getWd());
		return globlelist;
	}

	public String getCountPendingForAssignment() {
		String pendingforAssignment = getTextValue(PENDING_FOR_ASSIGNMENT_LOCATOR);
		return pendingforAssignment;
	}

	public String getCountPendingForRepair() {
		String pendingforRepair = getTextValue(PENDING_FOR_REPAIR_LOCATOR);
		return pendingforRepair;
	}

	public JobAssignmentPage goToJobAssignment() {
		clickOn(JOB_ASSIGNMENT_BUTTON_LOCATOR);
		JobAssignmentPage sup = new JobAssignmentPage(getWd());
		return sup;
	}

	public String getCountJobAssignment() {
		clickOn(JOB_ASSIGNMENT_BUTTON_LOCATOR);
		List<WebElement> jobCount = fetchMultipleElements(JOB_ASSIGNMENT_COUNT_LOCATOR);
		int count = jobCount.size();
		return Integer.toString(count);
	}

	public String getCountPendingForDelivery() {
		String pendingforDelivery = getTextValue(PENDING_FOR_DELIVERY_LOCATOR);
		return pendingforDelivery;
	}
	public String goToSignOutButton() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'Sign out')]"));
		clickOn(SIGN_OUT_BUTTON_LOCATOR);
		return username;
	}

}
