package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.coreautomation.uiautomation.utils.WebDriverInteractions.BasePage;

public class AmazonHomePage extends BasePage {
	private By searchResults = By.cssSelector("[data-component-type='s-search-result'] h2 a");

	public By GetWebElementByFieldName(String fieldName) {
		Map<String, By> myDictionary = new HashMap<String, By>();
		myDictionary.put("Search Results", searchResults);
		return myDictionary.get(fieldName);
	}
}
