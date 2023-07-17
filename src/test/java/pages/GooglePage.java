package pages;

import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage{
	// Necesario para heredar
	public GooglePage() {
		super(driver);
	}

	// Es publico porque lo vamos a usar desde los step definitions
	public void navigateToGoogle(){
		navigateTo("https://www.google.com");
	}
}
