package selenium.steps_defination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import selenium.pages.HomePage;
import selenium.pages.ResultsPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.text.IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace;

public class SearchSteps {
    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual = homePage.getCurrentUrl();
        assertThat(actual, endsWith("co.uk/"));
    }

    @When("^I search for product nike$")
    public void i_search_for_product_nike(String searchTerm) {
        homePage.doSearch(searchTerm);
    }

    @Then("^I should be able to see Nike product$")
    public void i_should_be_able_to_see_Nike_product() {
        String actualTitle = resultsPage.getSearchTitle();
        assertThat(actualTitle, is(equalToIgnoringCase("nike")));
        List<String> allProductNames = resultsPage.getAllProductNames();
        for (String item : allProductNames) {
            assertThat(item, equalToIgnoringCase("Nike"));
        }
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void iSearchForProduct(String item){
        homePage.doSearch(item);
    }
    @Then("^I should be able to see \"([^\"]*)\" product$")
    public void i_should_be_able_to_see_product(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        String actualTitle = resultsPage.getSearchTitle();
        List<String> allProductNames = resultsPage.getAllProductNames();

        assertThat(actualTitle, is(Matchers.equalToIgnoringCase(arg1)));
        for (String item : allProductNames) {
            assertThat(item,containsString(arg1));
        }
    }
}
