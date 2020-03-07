package selenium.pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.DriverFactory;
import selenium.utils.Helpers;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverFactory {

    @FindBy(css ="a[data-test='component-product-card-title']" )
    private List<WebElement> listOfSearchProduct;
        public List<WebElement> isProductsAvailable(){
        List<WebElement> productWebElements = listOfSearchProduct;
        new WebDriverWait(driver, 30);
        if(productWebElements.size()==0){
            // fail("Zero products found .....");
            throw new RuntimeException("Zero products found .....");
        }
        return productWebElements;
    }
    @FindBy(css = "h1[class='search-title__term']")
    private WebElement searchTitle;

    public String getSearchTitle(){
        return searchTitle.getText();
    }

    public List<String> getAllProductNames(){
        List<String> productNamesList = new ArrayList<>();

        List<WebElement> productWebElements = isProductsAvailable();

        for (WebElement indProduct : productWebElements) {
            String actual = indProduct.getText();
            productNamesList.add(actual);
        }
        return productNamesList;
    }
       public String selectAnyProduct(){
        List<WebElement> productWebElements = isProductsAvailable();
        int productSize = productWebElements.size();
        int randomNumber = new Helpers().randomNumberGenerator(productSize);
        WebElement selectedElement = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();
        return selectedProductName;
    }



}
