package com.coreautomation.uiautomation.webdriverutils.factorywrapper;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements IDriver {
	private static WebDriver Driver;

	/**
	 * Returns Chrome driver Instance.
	 */
	public WebDriver InitDriver() {
		ChromeOptions options = new ChromeOptions();
		return InitDriver(options);
	}

	/**
	 * Initialize Chrome driver with ChromeOptions provided.
	 * 
	 * @param options: ChromeOptions.
	 * @return: ChromeOptions.
	 */
	public WebDriver InitDriver(ChromeOptions options) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
		InitDefaultValuesForChromeOptions(options);
		Driver = new ChromeDriver(options);
		return Driver;
	}

	private void InitDefaultValuesForChromeOptions(ChromeOptions options) {
		
		Map<String, Object> loggingPrefs = new HashMap<>();
        loggingPrefs.put("browser", "ALL");
        options.setCapability("goog:loggingPrefs", loggingPrefs);
		options.addArguments("disable-infobars");
		options.addArguments("--incognito");
		options.addArguments("--disable-impl-side-painting");
		options.addArguments("disable-popup-blocking", "true");
	    options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
	}
}
