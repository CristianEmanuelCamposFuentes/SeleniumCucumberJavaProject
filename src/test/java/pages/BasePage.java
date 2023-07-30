package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
	// El WebDriver es la instancia del navegador que utilizamos para usar Selenium a nuestro gusto
	// Creamos un objeto estatico para el driver
	protected static WebDriver driver;
	//Creamos un objeto estatico para el wait
	private static WebDriverWait wait;

	// Creamos un bloque estatico a donde creamos el driver una vez para todas las instancias que creemos en las otras clases de pagina
	// Y agregamos una espera de 10 segundos
	static {
		ChromeOptions chromeOptions = new ChromeOptions();
		// Instancia del navegador
		driver = new ChromeDriver(chromeOptions);
		// La instancia de la espera, en caso de que no conecte agregar una excepcion
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Constructor
	public BasePage(WebDriver driver){
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public static void navigateTo(String url){
		driver.get(url);
	}

	// Metodo que devuelve un web element y Selenium puede trabajar con el
	private WebElement Find(String locator){

		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void clickElement(String locator){
		// Dado un xpath (locator), va a localizarlo y va a hacer un click sobre este elemento
		Find(locator).click();
	}

	public void write(String locator, String textToWrite){
		// Limpiar el campo de texto
		Find(locator).clear();
		// Enviar el texto al campo de texto
		Find(locator).sendKeys(textToWrite);
	}
}