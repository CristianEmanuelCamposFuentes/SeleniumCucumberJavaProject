package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

import java.util.List;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListPage(){
        list.navigateToListPage();
    }

    @When("^I search (.+) in the list$")
    public void searchTheList(String state) throws InterruptedException{
        list.enterSearchCriteria(state);
    }

    @Then("^I can find (.+) in the list$")
    public void theTableIsThere(String city) {
        List<String> lista = list.getAllSearchResults();
        boolean textIsThere = lista.contains(city);

        if (textIsThere){
            System.out.println("The text is on the list: PASSED.");
        } else {
            throw new Error("The text is not on the list: FAILED!");
        }
    }
}
