package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojo.JobNumberDetailsPojo;
import com.utils.BrowserUtility;

public class QualityCheckBeginPage extends BrowserUtility {
	private static final By JOB_NUMBER_DETAIL_CELL_LOCATOR = By.xpath("//mat-cell[contains(text(),'JOB')]/..//mat-cell");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Submit')]/..");
	private static final By BACK_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Back')]/..");
	private static final By REJECT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Reject')]/..");
	

	public QualityCheckBeginPage(WebDriver wd) {
		super(wd);
	}
	public JobNumberDetailsPojo getJobNumberDetails() {
		List<WebElement> celllist = fetchMultipleElements(JOB_NUMBER_DETAIL_CELL_LOCATOR);
		JobNumberDetailsPojo jobdetails = new JobNumberDetailsPojo(celllist.get(0).getText(), celllist.get(1).getText(),
				celllist.get(2).getText(), celllist.get(3).getText(), celllist.get(4).getText(),
				celllist.get(5).getText());
		return jobdetails;
	}
	public QualityCheckBeginPage clickOnSubmitButton() {
		clickOn(SUBMIT_BUTTON_LOCATOR);
		return new QualityCheckBeginPage(getWd());
	}
	public QualityCheckBeginPage clickOnBackButton() {
		clickOn(BACK_BUTTON_LOCATOR);
		return new QualityCheckBeginPage(getWd());
	}
	public QualityCheckBeginPage clickOnRejectButton() {
		clickOn(REJECT_BUTTON_LOCATOR);
		return new QualityCheckBeginPage(getWd());
	}
	public String getPopUpText() {
		String text = getTextValue(By.xpath("//*[contains(text(),'QC done successfully')]"));
		return text;
	}
	
	public String getRejectionPopUpText() {
		String text = getTextValue(By.xpath("//*[contains(text(),'QC done successfully!! Pending for Assignment')]"));
		return text;
	}


}
