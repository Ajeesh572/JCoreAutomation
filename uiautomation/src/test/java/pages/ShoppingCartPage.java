package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.coreautomation.uiautomation.utils.WebDriverInteractions.BasePage;

public class ShoppingCartPage extends BasePage {
	private By itemPrice = By.cssSelector(".sc-list-item-content [class*=badge-price-to-pay]");
	private By subTotal = By.cssSelector("[data-name=Subtotals] [id*='subtotal-amount-buybox']");

	public By GetWebElementByFieldName(String fieldName) {
		Map<String, By> myDictionary = new HashMap<String, By>();
		myDictionary.put("Price", itemPrice);
		myDictionary.put("Sub Total", subTotal);
		return myDictionary.get(fieldName);
	}
}
