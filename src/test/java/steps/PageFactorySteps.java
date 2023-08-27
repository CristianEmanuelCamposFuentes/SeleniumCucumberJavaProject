package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.PageFactoryPage;

public class PageFactorySteps extends BasePage {
    // inicializo una instancia de la pagina de prueba
    PageFactoryPage paginaPrueba = new PageFactoryPage();

    // Constructor, para poder heredar de la clase padre
    public PageFactorySteps() {
        super(driver);
    }


    // "^ Texto que quiero evaluar sin espacios al prinicipio y final$"
    @Given("^Entro un criterio a la pagina de prueba$")
    public void agregoCriterio() {
        paginaPrueba.agregaCriterio("River Plate");
    }
}
