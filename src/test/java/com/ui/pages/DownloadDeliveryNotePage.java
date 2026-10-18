package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BrowserUtility;

public class DownloadDeliveryNotePage extends BrowserUtility {
	private static final By SEARCH_BOX_LOCATOR = By.cssSelector("[data-placeholder=\"Search Job\"]");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Submit')]/..");
	private static final By JOB_FOUND_POPUP_LOCATOR = By.xpath("//*[contains(text(),'Job found successfully')]");
	private static final By PRINT_RECEIPT_LOCATOR = By.xpath("//span[contains(text(),' Print this receipt ')]/..");

	public DownloadDeliveryNotePage(WebDriver wd) {
		super(wd);
	}

	public DownloadDeliveryNotePage enterJobID(String jobID) {
		enterText(SEARCH_BOX_LOCATOR, jobID);
		return new DownloadDeliveryNotePage(getWd());
	}

	public DownloadDeliveryNotePage clickOnSubmit() {
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new DownloadDeliveryNotePage(getWd());
	}

	public String getJobFoundPopUpText() {
		String text = getVisibleText(JOB_FOUND_POPUP_LOCATOR);
		return text;
	}

	public String getJobInformation() {
		String text = getVisibleText(By.className("information"));
		return text;
	}

	public void clickOnPrintReceipt() {
		clickOn(PRINT_RECEIPT_LOCATOR);
	}

}
