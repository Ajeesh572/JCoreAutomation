package com.coreautomation.uiautomation.utils.UIActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.coreautomation.uiautomation.webdriverutils.WebDriverManager;

public class ActionHelper {
	
	/**
	 * Presses Escape Key.
	 */
	public static void PressEacape()
	{
	    Actions actions = new Actions(WebDriverManager.Instance().GetWebDriver.get());
	    actions.sendKeys(Keys.ESCAPE).perform();
	}
}
