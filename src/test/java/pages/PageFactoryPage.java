package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactoryPage extends BasePage{
    private String botonBuscar = "//input[@value='Buscar con Google']";
    private String barraBusqueda = "//textarea[@name='q']";
    @FindBy(id= "boton")
    WebElement boton;
    public PageFactoryPage() {
        super(driver);
        driver.get("www.google.com");
    }

    public void agregaCriterio(String criterio){
        write(barraBusqueda, criterio);
    }
}
