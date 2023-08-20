package pages;

public class TestSandBox extends BasePage{
	private String categoryDropdown = "/html/body/div[1]/div/div[7]/div/table/tbody/tr[1]/td[2]";
	

	// Constructor
	public TestSandBox(){
		super(driver);
	}

	public void navigateToSandBox(){
		navigateTo("https://thefreerangetester.github.io/sandbox-automation-testing/");
	}

	public void selectCategory(String category){
		// Al ser un button, le hago click y despues elijo la opcion
		clickElement(categoryDropdown);

		// Construyo el selector y despues ofrezco la opcion en base al texto
		String optionSelector = "//a[contains(text(), '" + category + "')]";
		// Click a la opcion elegida
		clickElement(optionSelector);
	}
}
