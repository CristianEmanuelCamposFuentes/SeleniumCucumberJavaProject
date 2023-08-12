package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestSandBox;

public class TestSandBoxSteps {
	TestSandBox sandBoxPage = new TestSandBox();

	@Given("^I Navigate to the sandbox page$")
	public void navigateToTheSandboxSite(){
		sandBoxPage.navigateToSandBox();
	}

	@And("^Select a value from the dropdowns$")
	public void selectState(){
		sandBoxPage.selectCategory("Action");
	}
}
