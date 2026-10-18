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

public class SimpleAppiumScripts2 {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		MyAndroidUtils androidUtils = new MyAndroidUtils();
		By userNameTextBoxLocator = By.id("editTextUsername");
		By passwordTextBoxLocator = By.id("editTextPassword");
		By submitButton = By.id("submitButton");
		androidUtils.enterText(userNameTextBoxLocator, "iamfst2");
		androidUtils.enterText(passwordTextBoxLocator, "password");
		androidUtils.clickOn(submitButton);

	}
}
