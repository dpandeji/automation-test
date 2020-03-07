package selenium;


import org.junit.Test;
import selenium.pages.HomePage;
import selenium.pages.ProductDescriptionPage;
import selenium.pages.ResultsPage;
import selenium.pages.TrolleyPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SmokeTest {

    private HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    private TrolleyPage trolleyPage= new TrolleyPage();
    private ProductDescriptionPage productDescriptionPage= new ProductDescriptionPage();

    public void searchTest() {
        String searchTerm="puma";
        homePage.doSearch(searchTerm);
        assertThat(homePage.getCurrentUrl(), endsWith(searchTerm));
        List<String> actualProductList = resultsPage.getAllProductNames();
        for (String product: actualProductList){
            assertThat(product,containsString(searchTerm));
        }
        String actualTitle = resultsPage.getSearchTitle();
        assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
    }

    public void basketTest() {
        homePage.doSearch("puma");
        String selectedProductName =resultsPage.selectAnyProduct();
        productDescriptionPage.addToTrolley();
       // productDescriptionPage.goToTrolley();
        String actual = trolleyPage.getProductInTrolley();
        assertThat(actual, is(equalToIgnoringCase(selectedProductName)));
    }
}
