package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;


public class RepairJobPage extends BrowserUtility {
	private WebElement rowElements ;

	public RepairJobPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}
//	public RepairJobBeginPage clickOnBeginRepairButton(String jobNumber) {
//		clickOn(By.xpath("//mat-cell[contains(text(),'"+jobNumber +"')]/..//mat-cell[7]//button"));
//		RepairJobBeginPage eng = new RepairJobBeginPage(getWd());
//		return eng;	
//	}
	public RepairJobBeginPage clickOnBeginRepairButton(String jobNumber) {
		locateJobRow(jobNumber);
		clickOn(By.xpath(".//span[contains(text(),'Begin Repair')]/.."), rowElements);
		return new RepairJobBeginPage(getWd());
	}
	private WebElement locateJobRow (String jobNumber) {
		By rowLocator=By.xpath("//mat-cell[contains(text(),'"+jobNumber+"')]/..");
		List<WebElement> jobRow = fetchMultipleElements(rowLocator);
		rowElements = jobRow.get(0);
		return rowElements;
	}
	
}
