package pages;

import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage{

	private String searchButton = "//input[@value='Buscar con Google']";
	private String searchTextField = "//input[@title='Buscar']";


	// Necesario para heredar
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
}
