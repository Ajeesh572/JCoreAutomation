package stepdefenitions;

import org.testng.Assert;

import com.coreautomation.uiautomation.utils.ScenarioContext;
import com.coreautomation.uiautomation.utils.UIActions.CommonFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;

public class ProductPageSteps {
	private ProductPage productPage;
	private ScenarioContext scenariocontext;

	public ProductPageSteps(ProductPage productPage, ScenarioContext scenariocontext) {
		this.productPage = productPage;
		this.scenariocontext = scenariocontext;
	}

	@When("I Note price of product by key {string} on Products page")
	public void i_note_price_of_product_by_key_on_products_page(String keyName) {
		String productPrice = productPage.GetWebElement(productPage.GetWebElementByFieldName("Product Price"))
				.getText();
		scenariocontext.setContext(keyName, productPrice);
	}

	@When("I Click {string} Button on Products page")
	public void i_click_button_on_products_page(String fieldName) {
		productPage.GetWebElement(productPage.GetWebElementByFieldName(fieldName)).click();
		CommonFunctions.WaitForPageToLoad();
	}

	@Then("I Verify Product name is {string} on Products page")
	public void i_verify_product_name_is_on_products_page(String expectedTextCntextKey) {
		String expectedValue = scenariocontext.getContext(expectedTextCntextKey).toString();
		String actualValue = productPage.GetWebElement(productPage.GetWebElementByFieldName("Product Name")).getText();
		Assert.assertEquals(expectedValue, actualValue);
	}
}
