package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GridPage;

public class GridTestSteps {
	GridPage grid = new GridPage();

	@Given("^I Navigate to the dinamic table$")
	public void navigateToTheGridPage() {
		// Navegar a la tabla dinamica
		grid.navigateToGrid();
	}

	@When("^I can return the value I wanted$")
	public void returnValue() {
		// Acceder a los valores en la tabla y realizar acciones
		String value = grid.getValueFromCell(1, 2);
		System.out.println("Valor de la celda (1, 2): " + value);

		String header = grid.getHeaderValue(3);
		System.out.println("Encabezado de la columna 3: " + header);
	}

	@Then("^Return other value that I want to proove$")
    public void getValueFromGrid() {

		String valueTwo = grid.getValueFromGrid(2, 2);
		System.out.println(valueTwo);
	}
}
