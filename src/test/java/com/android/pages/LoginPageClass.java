/**
 * 
 */
package com.android.pages;

import org.openqa.selenium.By;

import com.android.utils.AndroidUtils;
import com.android.utils.MobileDevice;

/**
 * @author Jatin
 *
 */
public class LoginPageClass extends AndroidUtils {

	private static final By userNameTextBoxLocator = By.id("editTextUsername");
	private static final By passwordTextBoxLocator = By.id("editTextPassword");
	private static final By submitButtonLocator = By.id("submitButton");

	/**
	 * @param e
	 */
	public LoginPageClass(MobileDevice e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	public void doLogin(String userName, String password) {
		enterText(userNameTextBoxLocator, userName);
		enterText(passwordTextBoxLocator, password);
		clickOn(submitButtonLocator);
	}
}
