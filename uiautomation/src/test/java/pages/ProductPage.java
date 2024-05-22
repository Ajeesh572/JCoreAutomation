package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

import com.coreautomation.uiautomation.utils.WebDriverInteractions.BasePage;

public class ProductPage extends BasePage {
	private By addToCart = By.cssSelector("#desktop_qualifiedBuyBox #add-to-cart-button");

	private By priceOfProduct = By.cssSelector("#centerCol .a-price-whole");

	private By productName = By.cssSelector("#titleSection #productTitle");

	public By GetWebElementByFieldName(String fieldName) {
		Map<String, By> myDictionary = new HashMap<String, By>();
		myDictionary.put("Add to Cart", addToCart);
		myDictionary.put("Product Price", priceOfProduct);
		myDictionary.put("Product Name", productName);
		return myDictionary.get(fieldName);
	}
}
