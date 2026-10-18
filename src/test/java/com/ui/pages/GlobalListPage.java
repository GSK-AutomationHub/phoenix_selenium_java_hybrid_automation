package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojo.TableListPojo;
import com.utils.Browser;
import com.utils.BrowserUtility;

public class GlobalListPage extends BrowserUtility {

	private static final By JOB_TABLE_ROW_INFO_LOCATOR = By.xpath("//mat-row");
	private static final By JOB_TABLE_CELL_INFO_LOCATOR = By.xpath("//mat-cell");
	private static final By JOB_NUMBER_LOCATOR = By.xpath("//button[text()]");
	
	public GlobalListPage (Browser browser) {
		super(browser);
	}
	public GlobalListPage (WebDriver wd) {
		super(wd);
	}
	public ArrayList<TableListPojo> fetchJobInfo() throws InterruptedException  {
		Thread.sleep(5000);
		List<WebElement> tableRowList = fetchMultipleElements(JOB_TABLE_ROW_INFO_LOCATOR);
		ArrayList<TableListPojo> createdjob = new ArrayList<TableListPojo>();
		List<WebElement> result = fetchMultipleElements(JOB_TABLE_CELL_INFO_LOCATOR);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int index = 0;
		for(int row = 0; row < tableRowList.size(); row++) {
			createdjob.add(new TableListPojo(result.get(index).getText(), result.get(index+1).getText(), result.get(index+2).getText(),
					result.get(index+3).getText(), result.get(index+4).getText(), result.get(index+5).getText(), result.get(index+6).getText()));
		     index = index+7;
		     
		}
		return createdjob;
	} 
	public GlobalDetailsPage clickOnJobNumber() {
		clickOn(JOB_NUMBER_LOCATOR);
		GlobalDetailsPage details = new GlobalDetailsPage(getWd());
		return details;
	} 
	

}
