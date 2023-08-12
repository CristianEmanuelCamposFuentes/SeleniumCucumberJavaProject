// Esto es un archivo de configuracion en Cucumber y no una clase en si misma
package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

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

}

//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");