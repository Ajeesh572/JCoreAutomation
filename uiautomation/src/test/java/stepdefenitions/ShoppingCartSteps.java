package stepdefenitions;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.testng.Assert;

import com.coreautomation.uiautomation.utils.ScenarioContext;

import io.cucumber.java.en.Then;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {
	private ShoppingCartPage shoppingCartPage;
	private ScenarioContext scenariocontext;

	public ShoppingCartSteps(ShoppingCartPage shoppingCartPage, ScenarioContext scenariocontext) {
		this.scenariocontext = scenariocontext;
		this.shoppingCartPage = shoppingCartPage;
	}

	@Then("I Verify {string} is same as {string} on shopping cart")
	public void i_verify_is_same_as_on_shopping_cart(String fieldName, String contextKey) throws ParseException {
		String actualValue = shoppingCartPage.GetWebElement(shoppingCartPage.GetWebElementByFieldName(fieldName))
				.getText();
		String expectedValue = scenariocontext.getContext(contextKey).toString();
		double actualTextDecimal = new BigDecimal(actualValue.replaceAll("[^\\d.]", "")).doubleValue();
		double expectedTextDecimal = new BigDecimal(expectedValue.replaceAll("[^\\d.]", "")).doubleValue();
		Assert.assertTrue(actualTextDecimal == expectedTextDecimal);

	}

	@Then("I Verify Sub Total price displayed is sum of below on shopping cart")
	public void i_verify_sub_total_price_displayed_is_sum_of_below_on_shopping_cart(List<String> keys) {
		double expectedSubTotal = 0;
		for (String key : keys) {
			expectedSubTotal += new BigDecimal(scenariocontext.getContext(key).toString().replaceAll("[^\\d.]", ""))
					.doubleValue();
		}
		String actulSubTotalText = shoppingCartPage
				.GetWebElement(shoppingCartPage.GetWebElementByFieldName("Sub Total")).getText();
		double actualSubTotal = new BigDecimal(actulSubTotalText.replaceAll("[^\\d.]", "")).doubleValue();
		Assert.assertTrue(expectedSubTotal == actualSubTotal,
				String.format("Expected Subtotal in cart is %s actual is %s", expectedSubTotal, actualSubTotal));
	}
}
