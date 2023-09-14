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
            // Si el scenario fallo, escribe en el reporte
            scenario.log("Scenario fallando, referirse a la imagen adjunta.");
            final byte[] screenshot = ((TakesScreenshot) driver)
                    // BYTES va relacionado con el objeto de tipo byte[]
            .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de pantalla");
        }
    }
}
