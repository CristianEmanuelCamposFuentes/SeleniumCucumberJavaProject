// Esto es un archivo de configuracion en Cucumber y no una clase en si misma
package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "steps",
		tags = "@Test"

)

/* *
	Esta clase va a unir todas las funcionalidades, y los features
 * */
public class runner {
	@AfterClass
	public static void cleanDriver() {
		BasePage.closeBrowser();
	}
}

