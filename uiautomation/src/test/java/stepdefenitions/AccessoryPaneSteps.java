package stepdefenitions;

import com.coreautomation.uiautomation.utils.ScenarioContext;
import com.coreautomation.uiautomation.utils.UIActions.CommonFunctions;

import io.cucumber.java.en.When;
import pages.AccessoryPane;

public class AccessoryPaneSteps {
	private AccessoryPane accessoryPane;
	private ScenarioContext scenariocontext;

	public AccessoryPaneSteps(ScenarioContext scenariocontext, AccessoryPane accessoryPane) {
		this.scenariocontext = scenariocontext;
		this.accessoryPane = accessoryPane;
	}

	@When("I close Accessory Pane if displayed")
	public void i_close_accessory_pane_if_displayed() {
		try {
			accessoryPane.GetWebElement(accessoryPane.GetWebElementByFieldName("Close")).click();
		} catch (Exception rv) {
			return;
		}
		accessoryPane.WaitUntilElementIsInvisible(accessoryPane.GetWebElementByFieldName("Pane"));
		CommonFunctions.WaitForPageToLoad();
	}
}
