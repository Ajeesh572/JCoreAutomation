package com.coreautomation.uiautomation.webdriverutils;

import org.openqa.selenium.WebDriver;

import com.coreautomation.uiautomation.webdriverutils.factorywrapper.Chrome;

public class DriverFactory {
	/**
	 * Represents Browser names.
	 */
	private enum Browser {
		Chrome
	}

	/**
	 * Gets respective instance of WebDriver according the name given in parameter.
	 * 
	 * @param browser
	 * @return: WebDriver Instance of respective browser.
	 */
	public static WebDriver GetDriver(String browser) {
		switch (Browser.valueOf(browser)) {
		case Chrome:
			return new Chrome().InitDriver();
		default:
			return null;
		}
	}
}
