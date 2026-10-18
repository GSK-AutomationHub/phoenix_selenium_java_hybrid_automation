package com.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.BrowserUtility;


public class ReadyForDeliveryPage extends BrowserUtility {
	private static final By JOB_CLOSE_BUTTON_LOCATOR = By.xpath(".//span[contains(text(),'Close')]/..");
	private static final By JOB_DELIVERED_SUCCESSFULLY_POPUP_LOCATOR = By.xpath("//*[contains(text(),'Job delivered successfully')]");

	public ReadyForDeliveryPage(WebDriver wd) {
		super(wd);
	}

	public ReadyForDeliveryPage clickOnJobCloseButton(String jobNumber) {
		List<WebElement> jobRow = fetchMultipleElements(
				By.xpath("//mat-cell[contains(text(),' " + jobNumber + " ')]/.."));
		WebElement element = jobRow.get(0);
		clickOn(JOB_CLOSE_BUTTON_LOCATOR, element);
		return new ReadyForDeliveryPage(getWd());
	}
	public String getDeliveryPopUpText() {
		String text = getTextValue(JOB_DELIVERED_SUCCESSFULLY_POPUP_LOCATOR);
		return text;
	}
	

}
