package stepdefenitions;

import com.coreautomation.uiautomation.webdriverutils.WebDriverManager;

import io.cucumber.java.After;

public class Hooks {
	@After
	public void disposeWebDriver() {
		WebDriverManager.disposeWebDriverManager();
	}
}
