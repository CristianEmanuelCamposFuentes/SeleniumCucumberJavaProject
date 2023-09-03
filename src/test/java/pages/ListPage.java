package pages;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {
    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }

    public void enterSearchCriteria() throws InterruptedException {
        Thread.sleep(600);
        write(searchField, "Washington");
    }

    public List<String> getAllSearchResults(){
        // Lista de WebElements devuelta segun el name aplicado en el input
        List<WebElement> list = bringMeAllElements(searchResults);
        // Creo una lista vacia para despues pasar estos WebElements
        List<String> stringsFromList = new ArrayList<String>();
        // Recorro la lista de WebElements , obtengo el Texto y lo agrego a la
        // nueva lista de Strings
        for (WebElement element : list) {
            stringsFromList.add(element.getText());
        }
        // Necesito Strings para despues validar que los textos se encuentren en una lista
        return stringsFromList;
    }







}
