package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GridPage extends BasePage {

    public GridPage(WebDriver driver) {
        super(driver);
    }

    public String getValueFromCell(int row, int column) {
        // Construir el XPath para acceder a una celda específica en el cuerpo de la tabla
        String cellXPath = String.format("//*[@id='root']/div/div[8]/div/table/tbody/tr[%d]/td[%d]", row, column);
        WebElement cell = driver.findElement(By.xpath(cellXPath));
        return cell.getText();
    }

    public String getHeaderValue(int column) {
        // Construir el XPath para acceder a una celda específica en la fila de encabezados
        String headerXPath = String.format("//*[@id='root']/div/div[8]/div/table/thead/tr/th[%d]", column);
        WebElement header = driver.findElement(By.xpath(headerXPath));
        return header.getText();
    }
}
