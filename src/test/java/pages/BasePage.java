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
	protected static WebDriverWait wait;

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
		// get() carga una pagina web nueva en la ventana del navegador actual
		driver.get(url);
	}

	// Metodo que devuelve un web element y Selenium puede trabajar con el, se va a crear esta instancia del WebElement y
	// Navegador (con sus metodos), para despues a traves de la herencia reutilizar en tod o el proyecto.
	private WebElement Find(String locator){
		// Espera hasta que el elemento este presente en la pagina
		// Utiliza el objeto wait para esperar, lleva dos parametros: WebDriverWait(instanciaDelNavegador, tiempoDeEspera)
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void clickElement(String locator){
		// Le agrego una espera al elemento web para cuando sea visible y este disponible para clickear
		/*
		* El objeto By en Selenium se utiliza para localizar elementos en la página web. En otras palabras, es una forma
		*  de decirle a Selenium cómo encontrar un elemento específico en el DOM (Documento de Objeto del Modelo) de la página.
		* */
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

		element.click();
		// Dado un xpath (locator), va a localizarlo y va a hacer un click sobre este elemento
//		Find(locator).click();
	}

	public void write(String locator, String textToWrite){
		// Limpiar el campo de texto
		Find(locator).clear();
		// Enviar el texto al campo de texto
		Find(locator).sendKeys(textToWrite);
	}
}