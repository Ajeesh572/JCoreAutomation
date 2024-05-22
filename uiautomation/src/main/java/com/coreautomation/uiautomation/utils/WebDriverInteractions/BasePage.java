package com.coreautomation.uiautomation.utils.WebDriverInteractions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coreautomation.uiautomation.webdriverutils.WebDriverManager;

public abstract class BasePage {
	public WebDriver driver;
	public WebDriverWait webDriverWait;

	public BasePage() {
		driver = WebDriverManager.Instance().GetWebDriver.get();
		webDriverWait = WebDriverManager.Instance().GetWebDriverWait.get();
	}

	/**
	 * Gets WebElement from By Locator.
	 * 
	 * @param byElement: By Locator.
	 * @return: WebElement Instance.
	 */
	public WebElement GetWebElement(By byElement) {

		return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	/**
	 * Gets WebElements Using By Locator.
	 * 
	 * @param byElement: By Locator of List of Elements.
	 * @return: List of WebElement Instances.
	 */
	public List<WebElement> GetWebElements(By byElement) {
		return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byElement));
	}

	/**
	 * Gets Page title of Current page.
	 * 
	 * @return
	 */
	public String GetPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Waits for Invisibility of an element
	 * 
	 * @param byElement: By Element.
	 */
	public void WaitUntilElementIsInvisible(By byElement) {
		webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}
}
