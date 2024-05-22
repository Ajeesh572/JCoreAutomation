package com.coreautomation.uiautomation.webdriverutils;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coreautomation.uiautomation.utils.PropertyReader;

/**
 * 
 */
public class DriverManager {

	public Supplier<WebDriver> GetWebDriver = () -> Driver;

	public Supplier<WebDriverWait> GetWebDriverWait = () -> WebDriverWait;

	private final String configPropertyFilePath = "src/test/resources/config.properties";

	/**
	 * Gets or sets driver wait.
	 */
	protected static WebDriverWait WebDriverWait;

	/**
	 * Method to close and quit the Driver.
	 */
	protected static void QuitDriver() {
		try {
			Optional.ofNullable(Driver).ifPresent(D -> D.close());
		} catch (WebDriverException e) {

		} finally {
			Optional.ofNullable(Driver).ifPresent(D -> D.quit());
		}
	}

	/**
	 * Gets or sets web driver.
	 */
	protected static WebDriver Driver;

	protected void InitWebDriver() {
		String browserName = PropertyReader.GetValue(configPropertyFilePath, "Browser");
		InitWebDriver(DriverFactory.GetDriver(browserName));
	}

	/**
	 * Method to initialize Driver.
	 * 
	 * @param driver: Initializes web driver.
	 */
	protected void InitWebDriver(WebDriver driver) {
		long explicitWait = Long.valueOf(PropertyReader.GetValue(configPropertyFilePath, "ExplicitWait"));
		Driver = driver;
		WebDriverWait = new WebDriverWait(Driver, Duration.ofMillis(explicitWait));
		Driver.get(PropertyReader.GetValue(configPropertyFilePath, "url"));
		Driver.manage().logs().get("browser").forEach(logEntry -> System.out.println(logEntry.getMessage()));
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
	}

}
