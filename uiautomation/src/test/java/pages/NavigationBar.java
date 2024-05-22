package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.coreautomation.uiautomation.utils.WebDriverInteractions.BasePage;
import com.coreautomation.uiautomation.webdriverutils.WebDriverManager;

public class NavigationBar extends BasePage {

	public NavigationBar() {
		((JavascriptExecutor) WebDriverManager.Instance().GetWebDriver.get()).executeScript("window.scrollTo(0, 0)");
	}

	private By searchBox = By.cssSelector("#twotabsearchtextbox");

	private By cart = By.cssSelector("a#nav-cart");

	public By GetWebElementByFieldName(String fieldName) {
		Map<String, By> myDictionary = new HashMap<String, By>();
		myDictionary.put("Search Box", searchBox);
		myDictionary.put("Cart", cart);
		return myDictionary.get(fieldName);
	}
}
