package pages;

import static pages.BasePage.navigateTo;

public class GridPage extends BasePage {
    private String cell = "//*[@id='root']/div/div[7]/div";
//    private String cell = "//*[@id='root']/div/div[7]/div/table/tbody/tr[1]/td[1]";
    public GridPage(){
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://thefreerangetester.github.io/sandbox-automation-testing/");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }

}
