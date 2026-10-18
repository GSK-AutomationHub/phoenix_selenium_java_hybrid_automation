package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;


public class QcDashBoardPage extends DashboardPage {
	private static final By USER_ICON_BUTTON_LOCATOR = By
			.xpath("//mat-icon[@data-mat-icon-name='user-circle']/../../..");
	private static final By PENDING_FOR_QC_COUNT_LOCATOR = By
			.xpath("//div[contains(text(),'Pending for QC')]/..//button");
	private static final By QC_COMPLETED_COUNT_LOCATOR = By.xpath("//div[contains(text(),'QC Completed')]/..//button");
	private static final By QC_REJECTED_COUNT_LOCATOR = By.xpath("//div[contains(text(),'QC Rejected')]/..//button");
	private static final By QUALITY_CHECK_COUNT_LOCATOR = By.xpath("//mat-table//mat-row");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.cssSelector("[placeholder='Search for a Job or IMEI']");
	private static final By SIGN_OUT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Sign out')]/..");

	public QcDashBoardPage(WebDriver wd) {
		super(wd);
	}

	public String getUserName() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'iamqc')]"));
		clickOn(By.xpath("//span[contains(text(),'iamqc')]"));
		return username;
	}
	public GlobalListPage searchbyJOBIDorIMEI (String jobnumber) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, jobnumber);
		hitEnter(SEARCH_TEXT_BOX_LOCATOR);
		GlobalListPage globlelist  = new GlobalListPage(getWd());
		return globlelist;
	}

	public String getPendingForQcCount() {
		String text = getTextValue(PENDING_FOR_QC_COUNT_LOCATOR);
		return text;
	}

	public String getQcCompletedCount() {
		String text = getTextValue(QC_COMPLETED_COUNT_LOCATOR);
		return text;
	}

	public String getQcRejectedCount() {
		String text = getTextValue(QC_REJECTED_COUNT_LOCATOR);
		return text;
	}
	public String getQualityCheckCount() {
		clickOn(By.xpath("//span[contains(text(),'Quality Check')]/../../.."));
		List<WebElement> qualityCheckCount = fetchMultipleElements(QUALITY_CHECK_COUNT_LOCATOR);
		int count = qualityCheckCount.size();
		return Integer.toString(count);
	}
	public QualityCheckPage goToQualityCheck() {
		clickOn(By.xpath("//span[contains(text(),'Quality Check')]/../../.."));
		QualityCheckPage qc = new QualityCheckPage(getWd());
		return qc;
	}
	public String goToSignOutButton() {
		clickOn(USER_ICON_BUTTON_LOCATOR);
		String username = getTextValue(By.xpath("//span[contains(text(),'Sign out')]"));
		clickOn(SIGN_OUT_BUTTON_LOCATOR);
		return username;
	}

}
