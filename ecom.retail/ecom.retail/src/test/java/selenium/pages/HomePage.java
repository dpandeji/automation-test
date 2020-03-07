package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.driver.DriverFactory;

public class HomePage extends DriverFactory {

    @FindBy(id = "searchTerm")
    private WebElement searchBox;
    public void doSearch(String searchTerm) {
       searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);
          }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();

    }
}
