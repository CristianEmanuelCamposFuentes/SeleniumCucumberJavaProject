package pages;


public class ListPage extends BasePage {
    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage() {
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://twitter.github.io/typeahead.js/examples/");
    }

    public void enterSearchCriteria() throws InterruptedException {
        Thread.sleep(600);
        write(searchField, "Washington");
    }



}
