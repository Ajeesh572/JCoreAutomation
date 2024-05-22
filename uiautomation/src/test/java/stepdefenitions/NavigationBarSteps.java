package stepdefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.coreautomation.uiautomation.utils.UIActions.CommonFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.NavigationBar;

public class NavigationBarSteps {
	private NavigationBar navigationBar;

	public NavigationBarSteps(NavigationBar navigationBar) {
		this.navigationBar = new NavigationBar();
	}

	@When("^I Fill in field \"([^\"]*)\" by value \"([^\"]*)\" on Navigation Bar$")
	public void fillInField(String fieldName, String searchItem) {
		WebElement element = navigationBar.GetWebElement(navigationBar.GetWebElementByFieldName(fieldName));
		element.clear();
		element.sendKeys(searchItem);
	}

	@When("I Hit enter in {string} on Navigation Bar")
	public void hitEnter(String fieldName) {
		navigationBar.GetWebElement(navigationBar.GetWebElementByFieldName(fieldName)).sendKeys(Keys.ENTER);
		CommonFunctions.WaitForPageToLoad();
	}

	@When("I Click {string} Button on Navigation Bar")
	public void i_click_button_on_navigation_bar(String fieldName) {
		CommonFunctions.WaitForPageToLoad();
		navigationBar.GetWebElement(navigationBar.GetWebElementByFieldName(fieldName)).click();
	}

	@Then("^I Verify Field \"([^\"]*)\" has value \"([^\"]*)\" for attribute \"([^\"]*)\" on Navigation Bar$")
	public void verifyFieldValue(String fieldName, String expectedValue, String attribute) {
		By element = navigationBar.GetWebElementByFieldName(fieldName);
		String actualValue = navigationBar.GetWebElement(element).getAttribute(attribute);
		Assert.assertEquals(expectedValue, actualValue);
	}
}
