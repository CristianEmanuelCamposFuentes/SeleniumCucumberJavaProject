package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GridPage;
import pages.TestSandBox;

public class TestSandBoxSteps {
	private WebDriver driver;
	private GridPage gridPage;
	private TestSandBox testSandBox;
	public TestSandBoxSteps() {
		driver = new ChromeDriver();
		gridPage = new GridPage(driver);
		testSandBox = new TestSandBox(driver);
	}

	@Given("^I Navigate to the sandbox page$")
	public void iAmOnTheSandboxPage() {
		// Navegar a la página sandbox
		testSandBox.navigateToSandBox();
	}

	@When("^I extract and print data from the table$")
	public void extractAndPrintTableData() {
		// Acceder a los valores en la tabla y realizar acciones
		String value = gridPage.getValueFromCell(1, 2);
		System.out.println("Valor de la celda (1, 2): " + value);

		String header = gridPage.getHeaderValue(3);
		System.out.println("Encabezado de la columna 3: " + header);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
