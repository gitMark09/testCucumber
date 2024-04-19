package GlueCodes;


import io.cucumber.java.After;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginWithBackgroundSteps {

    WebDriver driver = null;
    WebDriverWait wait = null;

    LoginPage lp = null;
    HomePage hp = null;

    // >>>>>>>>>>>>>>>>> BACKGROUND
    @Given("user is on login webpage")
    public void user_is_on_login_webpage() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        lp = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.visibilityOf(lp.txtUsername));

    }

    @When("valid username and password is entered by user")
    public void valid_username_and_password_is_entered_by_user() {
        lp.setTxtUsername("standard_user");
        lp.setTxtPassword("secret_sauce");
        lp.clickBtnLogin();

    }

    @Then("user is taken to the homepage")
    public void user_is_taken_to_the_homepage() {
        hp = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOf(hp.btn_BurigerIcon));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // <<<<<<<< HOOKS
    @After(value = "@HomepageTests")
    public void teardown(){
        System.out.println("This is inside @After HOOK");
        driver.close();
        driver.quit();
    }
    //>>>>>>>>>> HOOKS



    @When("user clicks burger icon")
    public void user_clicks_burger_icon() {
        hp.click_BurgerIconBtn();
    }

    @Then("logout link is displayed")
    public void logout_link_is_displayed() {
        wait.until(ExpectedConditions.visibilityOf(hp.btn_Logout));
    }


    @When("user enters homepage")
    public void user_enters_homepage() {
        Assert.assertTrue(hp.menuProductsExists());

    }

    @Then("^item (.*) is in inventory$")
    public void item_itemName_is_in_inventory(String itemName) {
        Ensure.that(driver.findElement(By.xpath(hp.inventoryItem.replace("{0}", itemName))).isDisplayed()).isTrue();

    }

}
