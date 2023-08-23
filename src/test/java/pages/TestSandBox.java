package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestSandBox extends BasePage{
	private String tableLocator = "//table[@class='table table-striped table-bordered table-hover']";

	// Constructor
	public TestSandBox(WebDriver driver) {
		super(driver);
	}

	public void navigateToSandBox() {
		navigateTo("https://thefreerangetester.github.io/sandbox-automation-testing/");
	}

	public String getValueFromTable(int row, int column) {
		String cellLocator = tableLocator + "/tbody/tr[" + row + "]/td[" + column + "]";
		WebElement cellElement = driver.findElement(By.xpath(cellLocator));
		return cellElement.getText();
	}
}
