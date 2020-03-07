package selenium.pages;
import org.openqa.selenium.By;
import selenium.driver.DriverFactory;

public class TrolleyPage extends DriverFactory {


    public String getProductInTrolley() {
        return driver.findElement(By.cssSelector(".ProductCard__content__9U9b1.xsHidden.lgFlex")).getText();
    }
    public String getTrolleyUrl(){
     return getUrl();
        }
      public void qtySupply(int arg1){
          qtySelect(arg1);
      }
      public int pricePerUnit(int P){
       String price= driver.findElement(By.cssSelector("div[class='ProductCard__unitPrice__rTWTs']")).getCssValue(String.valueOf(P));
          return 0;
      }
      public int finalPrice(){
          int i = driver.findElement(By.cssSelector("span[class='ProductCard__productLinePrice__3QC7V']")).hashCode();
          return 0;
      }
}
