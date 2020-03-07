package selenium.steps_defination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.pages.HomePage;
import selenium.pages.ProductDescriptionPage;
import selenium.pages.ResultsPage;
import selenium.pages.TrolleyPage;

import java.lang.reflect.Array;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class AddToBasketSteps {
    private ResultsPage resultsPage= new ResultsPage();
    private HomePage homePage= new HomePage();
    private TrolleyPage trolleyPage =new TrolleyPage();
    private ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();

    @Given("^I am on result page of \"([^\"]*)\" product$")
    public void i_am_on_result_page_of_product(String arg1) {
        // Write code here that turns the phrase above into concrete actions
     String searchResult= resultsPage.getSearchTitle();
    assertThat(searchResult,is(equalToIgnoringCase(arg1)));

    }

    @When("^I click on \"([^\"]*)\" product$")
    public void i_click_on_product(String arg1)  {
        // Write code here that turns the phrase above into concrete actions
        resultsPage.selectAnyProduct();
        }

    @When("^I see \"([^\"]*)\" product description$")
    public void i_see_product_description(String arg1)  {
        // Write code here that turns the phrase above into concrete actions
        String actualDetails=productDescriptionPage.getProductTitle();
        assertThat(actualDetails,containsString(arg1));
    }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String arg1)  {
    productDescriptionPage.addToTrolley();
            }

    @When("^I select qty of \"([^\"]*)\" or more.$")
    public void i_select_qty_of_or_more(int arg1)  {
        // Write code here that turns the phrase above into concrete actions
        trolleyPage.qtySupply(arg1);}

    @Then("^I should able to see \"([^\"]*)\" product in my trolley$")
    public void i_should_able_to_see_product_in_my_trolley(String arg1)  {
        // Write code here that turns the phrase above into concrete actions
        String actualProduct = trolleyPage.getProductInTrolley();
        assertThat(actualProduct,containsString(arg1));
        String basketUrl= trolleyPage.getTrolleyUrl();
        assertThat(basketUrl,containsString("/basket"));
    }

}
