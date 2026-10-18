package com.android.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MyAndroidUtils {
	AppiumDriver<AndroidElement> driver;
	Wait<WebDriver> wait;

	public MyAndroidUtils() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("app", System.getProperty("user.dir") + "\\apk\\fst-v1.apk");
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, 30L);
	}
	
	public void enterText(By locator, String text) {
		AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}
	
	public void clickOn(By locator) {
		AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

}
