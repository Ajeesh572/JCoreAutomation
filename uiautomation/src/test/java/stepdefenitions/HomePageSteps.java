package stepdefenitions;

import java.util.List;

import org.testng.Assert;

import com.coreautomation.uiautomation.utils.ScenarioContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;

public class HomePageSteps {

	private HomePage homePage;
	private ScenarioContext scenariocontext;

	public HomePageSteps(HomePage homePage, ScenarioContext scenariocontext) {
		this.homePage = homePage;
		this.scenariocontext = scenariocontext;
	}

	@When("I Note {string} name from Search list and save by key {string} on home page")
	public void i_note_name_from_search_list_and_save_by_key_on_home_page(String itemNumberOfSearchResults,
			String keyName) {
		String choosenItemName = homePage.GetWebElements(homePage.GetWebElementByFieldName("Search Results"))
				.get(Integer.parseInt(itemNumberOfSearchResults)).getText();
		scenariocontext.setContext(keyName, choosenItemName);
	}

	@When("I Choose Item {string} of search result on home page")
	public void i_choose_item_of_search_result_on_home_page(String itemNumberOfSearchResults) {
		homePage.GetWebElements(homePage.GetWebElementByFieldName("Search Results"))
				.get(Integer.parseInt(itemNumberOfSearchResults)).click();
	}

	@Then("^I Verify \"([^\"]*)\" are for \"([^\"]*)\" on home page$")
	public void verifySearchResults(String fieldName, String expectedTextInSearchItems) {
		List<String> missMatchedResults = homePage.GetWebElements(homePage.GetWebElementByFieldName(fieldName)).stream()
				.map(item -> item.getText())
				.filter(text -> !text.toLowerCase().contains(expectedTextInSearchItems.toLowerCase())).toList();
		Assert.assertTrue(missMatchedResults.size() == 0,
				String.format("Searched item is %s and miss match found is %s", expectedTextInSearchItems,
						String.join(", ", missMatchedResults)));
	}
}
