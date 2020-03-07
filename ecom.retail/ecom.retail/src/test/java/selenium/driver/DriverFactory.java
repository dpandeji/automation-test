package selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.Helpers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class  DriverFactory {

    public DriverFactory(){PageFactory.initElements(driver,this);}
    public static WebDriver driver;
    public Helpers helper= new Helpers();

    // TODO: 2020-02-08 pass from outside
    private String browser = "firefox";

    public void openBrowser() {
        switch (browser) {
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "firfox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }


    public void navigateTo(String url){
        driver.get(url);
    }

    public void maxiBrowser(){
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.quit();
    }

    public String getUrl(){ return driver.getCurrentUrl();}

    public void time(){driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    @FindBy(css = "select[data-e2e='product-quantity']" )
    public WebElement selectQty;
    public void qtySelect(Integer arg1){
       // driver.findElement(By.cssSelector("select[data-e2e='product-quantity']"))
               selectQty.sendKeys(String.valueOf(arg1));
        }
}

