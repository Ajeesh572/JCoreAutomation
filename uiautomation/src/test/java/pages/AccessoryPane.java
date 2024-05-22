package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.coreautomation.uiautomation.utils.WebDriverInteractions.BasePage;

public class AccessoryPane extends BasePage {
	private By accessoryPane = By.cssSelector("#attach-accessory-pane");
	private By closeAccessoryPane = By.cssSelector("a.a-link-normal.close-button");

	public By GetWebElementByFieldName(String fieldName) {
		Map<String, By> myDictionary = new HashMap<String, By>();
		myDictionary.put("Close", closeAccessoryPane);
		myDictionary.put("Pane", accessoryPane);
		return myDictionary.get(fieldName);
	}
}
