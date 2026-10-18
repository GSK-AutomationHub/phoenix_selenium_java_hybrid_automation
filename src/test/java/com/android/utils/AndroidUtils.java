/**
 * 
 */
package com.android.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.TestUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * @author Jatin
 *
 */
public class AndroidUtils {

	private static String userName = "atbatchaug_rNexwd";
	private static String accessKey = "ecMRczZxH3SJwy8kq1xS";
	private AndroidDriver<AndroidElement> driver;
	private Wait<WebDriver> wait;

	public AndroidUtils(MobileDevice e) {
		if (e == MobileDevice.LOCAL) {
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("platformName", "platformName");
			caps.setCapability("app", System.getProperty("user.dir") + "\\apk\\fst-v1.apk");
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), caps);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		else if (e == MobileDevice.BS) {
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("device", TestUtils.getPropertiesForAndroid("DEVICE"));
			caps.setCapability("os_version", TestUtils.getPropertiesForAndroid("OS_VERSION"));
			caps.setCapability("project", TestUtils.getPropertiesForAndroid("PROJECT"));
			caps.setCapability("build", TestUtils.getPropertiesForAndroid("BUILD"));
			caps.setCapability("name", TestUtils.getPropertiesForAndroid("NAME"));
			caps.setCapability("app", TestUtils.getPropertiesForAndroid("BROWSER_STACK_APP"));

			try {
				driver = new AndroidDriver<AndroidElement>(
						new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
			} catch (MalformedURLException exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
			

		}
		wait = new WebDriverWait(driver, 30L);
	}

	public void enterText(By locator, String text) {
		AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(text);
	}

	public void clickOn(By locator) {
		AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}
}
