package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //ACTIONS
    public boolean menuProductsExists(){
        List<WebElement> elems = driver.findElements(By.xpath(mnuProducts));
        if (elems.size()>0){
            return true;
        }
        return false;
    }

    String mnuProducts = "//span[text()='Products']";
}
