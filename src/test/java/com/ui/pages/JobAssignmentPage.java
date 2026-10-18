package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;

public class JobAssignmentPage extends BrowserUtility{
	private static final By SELECT_ENG_DROPDOWN_LOCATOR = By.xpath(".//span[contains(text(),\"Select Engineer\")]/../../..");
	private static final By SELECT_ENG_MARKZUK_LOCTOR = By.xpath("//span[contains(text(),'Markzuk')]/..");
	private static final By SELECT_ENG_JAY_HOWARD_LOCTOR = By.xpath("//span[contains(text(),'Jay Howard')]/..");
	private static final By JOB_ASSIGN_SUCCESSFULY_LOCTOR = By.xpath("//*[contains(text(),'Job assigned successfully')]");
	
	private WebElement jobRowElement;

	public JobAssignmentPage(WebDriver wd) {
		super(wd);
		// TODO Auto-generated constructor stub
	}
	

	public JobAssignmentPage selectEngMarkzuk(String jobNumber) {
		searchJobinTable(jobNumber);
		clickOn(SELECT_ENG_DROPDOWN_LOCATOR, jobRowElement);
		clickOn(SELECT_ENG_MARKZUK_LOCTOR, jobRowElement);
		clickOn(By.tagName("button"), jobRowElement);
		JobAssignmentPage sup = new JobAssignmentPage(getWd());
		return sup;
	}

	private WebElement searchJobinTable(String jobNumber) {
		java.util.List<WebElement> tableRow = fetchMultipleElements(By.xpath("//*[contains(text(),'" + jobNumber + "')]/.."));
		jobRowElement = tableRow.get(0);
		return jobRowElement;
	}
	public JobAssignmentPage selectEngJatHoward(String jobNumber) {
		searchJobinTable(jobNumber);
		clickOn(SELECT_ENG_DROPDOWN_LOCATOR, jobRowElement);
		clickOn(SELECT_ENG_JAY_HOWARD_LOCTOR, jobRowElement);
		clickOn(By.tagName("button"), jobRowElement);
		JobAssignmentPage sup = new JobAssignmentPage(getWd());
		return sup;
	}

	public String getAssignPopupText () {
				String text = getTextValue(JOB_ASSIGN_SUCCESSFULY_LOCTOR);
				return text;
	}

}
