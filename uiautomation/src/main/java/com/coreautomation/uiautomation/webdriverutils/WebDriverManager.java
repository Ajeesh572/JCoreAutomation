package com.coreautomation.uiautomation.webdriverutils;

public class WebDriverManager extends DriverManager {
	private static WebDriverManager instance;

	private WebDriverManager() {
		InitWebDriver();
	}

	/**
	 * Make WebDriverManager Instance as null;
	 */
	public static void disposeWebDriverManager() {
		QuitDriver();
		instance = null;
	}

	/**
	 * @return Instance of this class.
	 */
	public static WebDriverManager Instance() {
		if (instance == null) {
			instance = new WebDriverManager();
		}

		return instance;
	}

}
