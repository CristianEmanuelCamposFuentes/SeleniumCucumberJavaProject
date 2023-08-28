package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasePage{

	// Defino los selectores de elementos
	private String searchButton = "//input[@value='Buscar con Google']";
	private String searchTextField = "//textarea[@name='q']";
	private String firstResult = "";


	// Constructor , es necesario para heredar
	public GooglePage() {
		super(driver);
	}

	// Es publico porque lo vamos a usar desde los step definitions
	public void navigateToGoogle(){
		navigateTo("https://www.google.com");
	}

	public void clickGoogleSearch(){
		clickElement(searchButton);
	}

	public void enterSearchCriteria(String criteria){
		write(searchTextField, criteria);
	}

	public String firstResult(){
		return textFromElement(firstResult);
	}

}
