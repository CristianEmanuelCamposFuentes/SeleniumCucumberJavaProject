package pages;

public class TestSandBox extends BasePage{
	private String categoryDropdown = "//select[@id='testingDropdown']";

	// Constructor
	public TestSandBox(){
		super(driver);
	}

	public void navigateToSandBox(){
		navigateTo("https://www.testandquiz.com/selenium/testing.html");
	}

	public void selectCategory(String category){
		selectFromDropdownByValue(categoryDropdown, category);
	}
}
