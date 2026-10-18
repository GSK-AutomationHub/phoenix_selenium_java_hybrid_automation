/**
 * 
 */
package com.android.tests;

import org.testng.annotations.Test;

import com.android.pages.LoginPageClass;
import com.android.utils.MobileDevice;

/**
 * @author Jatin
 *
 */
public class LoginTest {

	@Test(groups = { "sanity" ,"e2e"})
	public void loginTest() {

		LoginPageClass loginPage = new LoginPageClass(MobileDevice.BS);
		loginPage.doLogin("iamfst1", "password");
	}
}
