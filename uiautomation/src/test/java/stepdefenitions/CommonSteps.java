package stepdefenitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.coreautomation.uiautomation.utils.ScenarioContext;
import com.coreautomation.uiautomation.utils.UIActions.CommonFunctions;
import com.coreautomation.uiautomation.webdriverutils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.AmazonHomePage;

public class CommonSteps {
	private AmazonHomePage amazonHomePage;
	private ScenarioContext scenariocontext;

	public CommonSteps(AmazonHomePage amazonHomePage, ScenarioContext scenariocontext) {
		this.amazonHomePage = amazonHomePage;
		this.scenariocontext = scenariocontext;
	}

	@Given("I Launched application")
	public void iLaunchedApplication() {
		WebDriverManager.Instance().GetWebDriver.get();
		CommonFunctions.WaitForPageToLoad();
	}

	@When("^I Switch to tab \"([^\"]*)\"$")
	public void i_switch_to_tab(int tabNumber) {
		WebDriver driver = WebDriverManager.Instance().GetWebDriver.get();
		List<String> windowHandlesList = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandlesList.get(tabNumber));
	}

	@Then("^I Verify Page Title (is|contains) \"([^\"]*)\"$")
	public void ThenIVerifyPageTitleIs(String condition, String expectedPageName) {
		String actualPageName = amazonHomePage.GetPageTitle();
		Boolean status = condition == "is" ? expectedPageName.equals(actualPageName)
				: actualPageName.contains(expectedPageName);
		Assert.assertTrue(status,
				String.format("Expected PageTitle is %s but actual is %s", expectedPageName, actualPageName));
	}
}
