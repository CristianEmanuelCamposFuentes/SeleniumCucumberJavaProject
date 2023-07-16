package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// Creamos un objeto estatico para el driver
	protected static WebDriver driver;
	//Creamos un objeto estatico para el wait
	private static WebDriverWait wait;

	// Creamos un bloque estatico a donde creamos el driver una vez para todas las instancias que creemos en las otras clases de pagina
	// Y agregamos una espera de 10 segundos
	static {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		wait = new WebDriverWait(driver, 10);
	}

	// Constructor
	public BasePage(WebDriver driver){
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public static void navigateTo(String url){
		driver.get(url);


	}
}