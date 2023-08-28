package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
	// El WebDriver es la instancia del navegador que utilizamos para usar Selenium a nuestro gusto
	// Creamos un objeto estatico para el driver
	protected static WebDriver driver;
	//Creamos un objeto estatico para el wait
	protected static WebDriverWait wait;
	protected static Actions action;

	// Creamos un bloque estatico a donde creamos el driver una vez para todas las instancias que creemos en las otras clases de pagina
	// Y agregamos una espera de 10 segundos
	static {
		ChromeOptions chromeOptions = new ChromeOptions();
		//Esta línea permite a las páginas web solicitar recursos de otros orígenes (dominios) usando XMLHttpRequest
		// y Fetch API a través de la política de origen cruzado (CORS). El * indica que cualquier origen está permitido.
		// Esto puede ser útil durante el desarrollo para evitar restricciones CORS al acceder a recursos externos./**/
//		chromeOptions.addArguments("--remote-allow-origins=*");

		// Utiliza la configuracion de datos (perfil, extensiones, marcadores) de Chrome que existe en la ruta indicada
		// Donde dice "taba_" reemplazar por tu usuario en Windows
//		chromeOptions.addArguments("user-data-dir=C:\\Users\\crist\\AppData\\Local\\Google\\Chrome\\User Data");

		// Instancia del navegador
		driver = new ChromeDriver(chromeOptions);
		// La instancia de la espera, en caso de que no conecte agregar una excepcion
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		action = new Actions(driver);
	}

	// Constructor
	public BasePage(WebDriver driver){
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
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

	public void selectFromDropdownByValue(String locator, String valueToSelect){
		// Creamos el dropdown
		Select dropdown = new Select(Find(locator));
		// Seleccionar por valor
		dropdown.selectByValue(valueToSelect);
	}

	public void selectFromDropdownByIndex(String locator, int valueToSelect){
		// Creamos el dropdown
		Select dropdown = new Select(Find(locator));
		// Seleccionar por index
		dropdown.selectByIndex(valueToSelect);
	}

	public void selectFromDropdownByText(String locator, String valueToSelect){
		// Creamos el dropdown
		Select dropdown = new Select(Find(locator));
		// Seleccionar por index
		dropdown.selectByVisibleText(valueToSelect);
	}

	public void verTypeFile(){
		String change_visibility = "$(\"#fileField\").css(\"visibility,\"visible\");";
		String change_display = "$(\"#fileField\").css(\"display, \"block\");";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(change_display);
		js.executeScript(change_visibility);

		/* ALGUNOS COMANDOS QUE PUEDEN SERVIR EN LA BUSQUEDA DE MOSTRAR LOS WEB ELEMENTS
		*
		* ("#fileField").style.visibility="visible";
		("#fileField").style.display="block";
		("#fileField").style.width="200px";
		("#fileField").style.height="200px";
		("#fileField").style.position="fixed";
		("#fileField").style.overflow="visible";
		("#fileField").style.zIndex="999999";
		("#fileField").style.top="500px";
		("#fileField").style.bottom="500px";
		("#fileField").style.left="500px";
		("#fileField").style.right="500px";
		("#fileField").style.marginBottom="100px";
		* */
	}

	public void hoverOverElement(String locator){
		action.moveToElement(Find(locator));
	}

	public void doubleClick(String locator){
		action.doubleClick(Find(locator));
	}

	public void rightClick(String locator){
		action.contextClick(Find(locator));
	}

	public String getValueFromTable(String locator, int row, int column){
		String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
		return Find(cellINeed).getText();
	}

	public void switchToiFrame(int iFrameIndex){
		driver.switchTo().frame(iFrameIndex);
	}

	public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

	public void dismissAlert(){
		driver.switchTo().alert().dismiss();
	}

	public String textFromElement(String locator){
		return Find(locator).getText();
	}


	public boolean elementIsDisplayed(String locator){
		// Devuelve un booleano si es mostrado o no
		return Find(locator).isDisplayed();
	}

	public boolean elementIsSelected(String locator){
        // Devuelve un booleano si es seleccionado o no
        return Find(locator).isSelected();
    }

	public boolean elementIsEnabled(String locator){
		// Devuelve un booleano si esta habilitado o no
		return Find(locator).isEnabled();
	}

	public List<WebElement> bringMeAllElements(String locator){
		return driver.findElements(By.className(locator));
	}
}

