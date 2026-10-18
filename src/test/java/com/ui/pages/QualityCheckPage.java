package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;


public class QualityCheckPage extends BrowserUtility {
	private WebElement rowElements;

	public QualityCheckPage(WebDriver wd) {
		super(wd);
	}
	public QualityCheckBeginPage clickOnBeginQcButton(String jobNumber) {
		locateJobRow(jobNumber);
		clickOn(By.xpath(".//span[contains(text(),'Begin QC')]/.."), rowElements);
		return new QualityCheckBeginPage(getWd());
	}
	private WebElement locateJobRow (String jobNumber) {
		By rowLocator=By.xpath("//mat-cell[contains(text(),'"+jobNumber+"')]/..");
		List<WebElement> jobRow = fetchMultipleElements(rowLocator);
		rowElements = jobRow.get(0);
		return rowElements;
	}


}
