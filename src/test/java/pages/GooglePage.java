package pages;

public class GooglePage extends BasePage{

	// Defino los selectores de elementos

	private String searchButton = "body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf.emcav > div.UUbT9.EyBRub > div.aajZCb > div.lJ9FBc > center > input.gNO89b";
	private String searchTextField = "//textarea[@name='q']";
	private String firstResult = "//*[@id=\"rso\"]/div[1]/div/div/div[2]/g-section-with-header/div[1]/title-with-lhs-icon/a/div[3]/h3";

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
