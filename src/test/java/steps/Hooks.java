package steps;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;



public class Hooks extends BasePage {
    public Hooks(){
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            scenario.log("ESTO FALLO MAN");
            final byte[] screenshot = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de pantalla");
        }
    }
}
