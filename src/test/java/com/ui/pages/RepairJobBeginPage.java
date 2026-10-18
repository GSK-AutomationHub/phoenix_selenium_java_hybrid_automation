package com.ui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.pojo.CustomerReportedProblemsPojo;
import com.ui.pojo.JobNumberDetailsPojo;
import com.utils.BrowserUtility;

public class RepairJobBeginPage extends BrowserUtility {
	private static final By JOB_NUMBER_DETAIL_CELL_LOCATOR = By.xpath("//mat-cell[contains(text(),'JOB')]/..//mat-cell");
	private static final By CUSTOMER_REPORTED_PROBLEMS_ROW_LOCATOR = By.xpath("//mat-header-cell[contains(text(),'Problem')]/../..//mat-row");
	private static final By CUSTOMER_REPORTED_PROBLEMS_CELL_LOCATOR = By.xpath("//mat-header-cell[contains(text(),'Problem')]/../..//mat-row//mat-cell");
	private static final By SELECT_PROBLEM_DROPDOWN_LOCATOR = By.xpath("//span[contains(text(),'Select Problem')]/../../..");
	private static final By REMARKS_TEXT_BOX_LOCATOR = By.xpath("//input[@placeholder=\"Remarks\"]");
	private static final By ADD_MORE_PROBLEMS_BUTTON_LOCATOR = By.xpath("//mat-icon[contains(text(),'add')]/../..]");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Submit')]/..");
	
	public RepairJobBeginPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}

	public JobNumberDetailsPojo getJobNumberDetails() {
		List<WebElement> celllist = fetchMultipleElements(JOB_NUMBER_DETAIL_CELL_LOCATOR);
		JobNumberDetailsPojo jobdetails = new JobNumberDetailsPojo(celllist.get(0).getText(), celllist.get(1).getText(),
				celllist.get(2).getText(), celllist.get(3).getText(), celllist.get(4).getText(),
				celllist.get(5).getText());
		return jobdetails;
	}
	public ArrayList<CustomerReportedProblemsPojo> getCustomerReportedProblems() {
		List<WebElement> rowlist = fetchMultipleElements(CUSTOMER_REPORTED_PROBLEMS_ROW_LOCATOR);
		ArrayList<CustomerReportedProblemsPojo> problemlist = new ArrayList<CustomerReportedProblemsPojo>();
		List<WebElement> celllist= fetchMultipleElements(CUSTOMER_REPORTED_PROBLEMS_CELL_LOCATOR);
		int count = 0;
		for (int i = 0; i < rowlist.size(); i++) {
			CustomerReportedProblemsPojo job = new CustomerReportedProblemsPojo(celllist.get(count).getText(), celllist.get(count+1).getText());
			count = count +2;
			problemlist.add(job);
		}
		return problemlist;
	}
	public RepairJobBeginPage addingSelectProblem() {
		clickOn(SELECT_PROBLEM_DROPDOWN_LOCATOR);
		Random random =new Random();
		int problem = random.nextInt(10);
		By locator;
			if (problem == 0) {
			locator = By.xpath("//span[contains(text(),'Smartphone is running slow')]/..");
			} else if (problem == 1) {
				locator = By.xpath("//span[contains(text(),'Poor battery life')]/..");
			}else if (problem == 2) {
				locator = By.xpath("//span[contains(text(),'Phone or app crashes')]/..");
			}else if (problem == 3) {
				locator = By.xpath("//span[contains(text(),'Sync issue')]/..");
			}else if (problem == 4) {
				locator = By.xpath("//span[contains(text(),'MicroSD card is not working on your phone')]/..");
			}else if (problem == 5) {
				locator = By.xpath("//span[contains(text(),'Overheating')]/..");
			}else if (problem == 6) {
				locator = By.xpath("//span[contains(text(),'Connecting problem with Bluetooth, Wifi, Cellular network')]/..");
			}else if (problem == 7) {
				locator = By.xpath("//span[contains(text(),'Cracked screen')]/..");
			}else if (problem == 8) {
				locator = By.xpath("//span[contains(text(),'Other')]/..");
			}else if (problem == 9) {
				locator = By.xpath("//span[contains(text(),'Camera issue')]/..");
			}else if (problem == 10) {
				locator = By.xpath("//span[contains(text(),'Head Phone Jack not working')]/..");
			}else {
			locator = By.xpath("//span[contains(text(),'Smartphone is running slow')]/..");
			}
		clickOn(locator);
		RepairJobBeginPage repair = new RepairJobBeginPage(getWd());
		return repair;
	}
	public RepairJobBeginPage addingRemak() {
		enterText(REMARKS_TEXT_BOX_LOCATOR, "Problem Solved");
		RepairJobBeginPage repair = new RepairJobBeginPage(getWd());
		return repair;
	}
	public RepairJobBeginPage addingOtherProblem() {
		clickOn(ADD_MORE_PROBLEMS_BUTTON_LOCATOR);
		RepairJobBeginPage repair = new RepairJobBeginPage(getWd());
		return repair;
	}
	public RepairJobBeginPage clickOnSubmit() {
		clickOn(SUBMIT_BUTTON_LOCATOR);
		RepairJobBeginPage repair = new RepairJobBeginPage(getWd());
		return repair;
	}
	public String getPopUpText() {
		String text = getTextValue(By.xpath("//*[contains(text(),'Job repaired successfully')]"));
		return text;
	}
	
}
