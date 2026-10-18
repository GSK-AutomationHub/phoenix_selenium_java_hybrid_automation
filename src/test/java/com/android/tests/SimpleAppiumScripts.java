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
import io.appium.java_client.android.AndroidElement;

public class SimpleAppiumScripts {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("app", System.getProperty("user.dir") + "\\apk\\fst-v1.apk");
		AppiumDriver<AndroidElement> driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
		Wait<WebDriver> wait = new WebDriverWait(driver, 30L);
		By userNameTextBoxLocator = By.id("editTextUsername");
		By passwordTextBoxLocator = By.id("editTextPassword");
		By submitButton = By.id("submitButton");
		// AndroidElement userNameTextBoxElement =
		// driver.findElement(userNameTextBoxLocator);

		AndroidElement userNameTextBoxElement = (AndroidElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(userNameTextBoxLocator));
		// AndroidElement passwordAndroidElement =
		// driver.findElement(passwordTextBoxLocator);

		AndroidElement passwordAndroidElement = (AndroidElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator));

		// AndroidElement submitButtonAndroidElement = driver.findElement(submitButton);

		AndroidElement submitButtonAndroidElement = (AndroidElement) wait
				.until(ExpectedConditions.elementToBeClickable(submitButton));
		userNameTextBoxElement.sendKeys("iamfst2");
		passwordAndroidElement.sendKeys("password");
		submitButtonAndroidElement.click();
	}
}
