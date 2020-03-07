package selenium.steps_defination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.core.Is;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.openqa.selenium.WebElement;
import selenium.pages.TrolleyPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.StringContains.containsString;

public class QuantityChangeTest {

    TrolleyPage trolleyPage=new TrolleyPage();

    @Given("^I am on trolley page$")
    public void i_am_on_trolley_page()  {
        // Write code here that turns the phrase above into concrete actions
      String actual= trolleyPage.getTrolleyUrl();
      assertThat(actual,containsString("basket"));
    }
    @When("^I select qty of \"([^\"]*)\" or more$")
    public void i_select_qty_of_or_more(int arg1)  {
        // Write code here that turns the phrase above into concrete actions
       trolleyPage.qtySupply(arg1);
    }

    @Then("^I should be able to see price for \"([^\"]*)\"$")
    public void i_should_be_able_to_see_price_for(int arg1) {
        // Write code here that turns the phrase above into concrete actions
      int p= trolleyPage.pricePerUnit(arg1);
      int q= arg1;
      int totalPrice= p*q;
      int total= trolleyPage.finalPrice();
      assertThat(totalPrice,is((total)));

    }

}
