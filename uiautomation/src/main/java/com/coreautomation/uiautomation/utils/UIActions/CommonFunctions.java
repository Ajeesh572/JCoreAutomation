package com.coreautomation.uiautomation.utils.UIActions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.coreautomation.uiautomation.webdriverutils.WebDriverManager;

public class CommonFunctions {
	/**
	 * Waits for Document to be ready.
	 */
	public static void WaitForPageToLoad() {
		WebDriverManager.Instance().GetWebDriverWait.get()
				.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	}
}
