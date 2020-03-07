package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.driver.DriverFactory;

public class ProductDescriptionPage extends DriverFactory {
@FindBy(css = "span[data-test='product-title']")
    private WebElement selectedProductInfo;
    public String getProductTitle(){return selectedProductInfo.getText(); }
    @FindBy(css ="button[data-test='component-att-button']" )
    private WebElement clickToAdd;
    @FindBy(css = ".xs-row a[data-test='component-att-button-basket']")
    private WebElement getClickToAdd;
    public void addToTrolley() {
        clickToAdd.click();
        time();
        getClickToAdd.click();
    }
}
