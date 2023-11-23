package steps;

// Comodin para que optimice toda

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePage;

// Step Definition Class
public class GoogleSteps {
	// Instancia de la pagina Google
	GooglePage google = new GooglePage();

	// "^ TextoQueQuieroEvaluar $"
	@Given("^I am on the Google search page$")
	public void navigateToGoogle(){
	// Instancia de WebDriver utiliza el metodo para navegar a Google
	google.navigateToGoogle();
	}
	@When("^I enter a search criteria$")
	public void enterSearchCriteria(){
		google.enterSearchCriteria("Villa La Angostura Imagenes");
	}
	@And("^click on the search button$")
	public void clickSearchButton(){
		google.clickGoogleSearch();
	}
	@Then("^the results match the criteria$")
	public void validateResults(){
		String actualResult = google.firstResult();
		String expectedText = "Villa La Angostura";
		Assert.assertTrue(actualResult.contains(expectedText));
	}

}