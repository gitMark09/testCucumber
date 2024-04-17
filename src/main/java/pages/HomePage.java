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

    public void click_BurgerIconBtn(){
        btn_BurigerIcon.click();
    }

    public void click_LogoutNBtn(){
        btn_Logout.click();
    }

    String mnuProducts = "//span[text()='Products']";

    @FindBy (xpath = "//button[text()='Open Menu']")
    public WebElement btn_BurigerIcon;

    @FindBy (id = "logout_sidebar_link")
    public WebElement btn_Logout;

    public String inventoryItem = "//div[@class='inventory_item_name ' and text()='"+"{0}"+"']";

}
