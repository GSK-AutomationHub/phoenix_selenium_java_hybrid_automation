package com.ui.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojo.ActionStatusPojo;
import com.ui.pojo.CustomerDetailsPojo;
import com.ui.pojo.ProblemsReportedPojo;
import com.ui.pojo.ServiceLocationDetailsPojo;
import com.ui.pojo.TableListPojo;
import com.utils.Browser;
import com.utils.BrowserUtility;

public class GlobalDetailsPage extends BrowserUtility {

	private static final By JOB_DETAILS_CELL_LOCATOR = By
			.xpath("//strong[contains(text(),'Job Details')]/../.././../..//mat-table//mat-row//mat-cell");
	private static final By CUSTOMER_DETAILS_CELL_LOCATOR = By
			.xpath("//strong[contains(text(),'Customer Details')]/../.././../..//mat-table//mat-row//mat-cell");
	private static final By SERVICE_LOCATION_DETAILS_CELL_LOCATOR = By
			.xpath("//strong[contains(text(),'Service Location Details')]/../.././../..//mat-table//mat-row//mat-cell");
	private static final By PROBLEMS_REPORTED_ROW_LOCATOR = By
			.xpath("//strong[contains(text(),'Problems Reported')]/../.././../..//mat-table//mat-row");
	private static final By PROBLEMS_REPORTED_CELL_LOCATOR = By
			.xpath("//strong[contains(text(),'Problems Reported')]/../.././../..//mat-table//mat-row//mat-cell");
	private static final By ACTION_STATUS_ROW_LOCATOR = By
			.xpath("//strong[contains(text(),'Action Status')]/../.././../..//mat-table//mat-row");
	private static final By ACTION_STATUS_CELL_LOCATOR = By
			.xpath("//strong[contains(text(),'Action Status')]/../.././../..//mat-table//mat-row//mat-cell");

	public GlobalDetailsPage(Browser browser) {
		super(browser);
	}

	public GlobalDetailsPage(WebDriver wd) {
		super(wd);
	}

	public TableListPojo getJobDetails() {
		List<WebElement> result = fetchMultipleElements(JOB_DETAILS_CELL_LOCATOR);
		TableListPojo jobdetails = new TableListPojo(result.get(0).getText(), result.get(1).getText(),
				result.get(2).getText(), result.get(3).getText(), result.get(4).getText(), result.get(5).getText(),
				result.get(6).getText());
		return jobdetails;
	}

	public CustomerDetailsPojo getcustomerDetails() {
		List<WebElement> result = fetchMultipleElements(CUSTOMER_DETAILS_CELL_LOCATOR);
		CustomerDetailsPojo customerdetails = new CustomerDetailsPojo(result.get(0).getText(), result.get(1).getText(),
				result.get(2).getText());
		return customerdetails;
	}

	public ServiceLocationDetailsPojo getServiceLocationDetails() {
		List<WebElement> result = fetchMultipleElements(SERVICE_LOCATION_DETAILS_CELL_LOCATOR);
		ServiceLocationDetailsPojo servicelocationdetails = new ServiceLocationDetailsPojo(result.get(0).getText(),
				result.get(1).getText(), result.get(2).getText());
		return servicelocationdetails;
	}

	public ArrayList<ProblemsReportedPojo> getProblemsReported() {
		List<WebElement> tableRowList = fetchMultipleElements(PROBLEMS_REPORTED_ROW_LOCATOR);
		ArrayList<ProblemsReportedPojo> problemreportedlist = new ArrayList<ProblemsReportedPojo>();
		List<WebElement> result = fetchMultipleElements(PROBLEMS_REPORTED_CELL_LOCATOR);
		int index = 0;
		for (int row = 0; row < tableRowList.size(); row++) {
			problemreportedlist.add(new ProblemsReportedPojo(result.get(index).getText(),
					result.get(index + 1).getText(), result.get(index + 2).getText(), result.get(index + 3).getText()));
			index = index + 4;
		}
		return problemreportedlist;
	}

	public ArrayList<ActionStatusPojo> getActionStatus() {
		List<WebElement> tableRowList = fetchMultipleElements(ACTION_STATUS_ROW_LOCATOR);
		ArrayList<ActionStatusPojo> actionstatuslist = new ArrayList<ActionStatusPojo>();
		List<WebElement> result = fetchMultipleElements(ACTION_STATUS_CELL_LOCATOR);
		int index = 0;
		for (int row = 0; row < tableRowList.size(); row++) {
			actionstatuslist.add(new ActionStatusPojo(result.get(index).getText(), result.get(index + 1).getText()));
			index = index + 2;
		}
		return actionstatuslist;
	}

}
