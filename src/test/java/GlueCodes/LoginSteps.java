package GlueCodes;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class LoginSteps {
    WebDriver driver = null;
    WebDriverWait wait = null;
    LoginPage lp;
    HomePage hp;


    @Before
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("user already browser open")
    public void user_already_browser_open() {
        System.out.println("Start webdriver.");

    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

        lp = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOf(lp.txtUsername));

    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        lp.setTxtUsername(username);
        lp.setTxtPassword(password);

    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("user clicks on login button");

        lp.clickBtnLogin();
    }

    @Then("user is navigated to homepage")
    public void user_is_navigated_to_homepage() {

        System.out.println("user is on the homepage");
        hp = new HomePage(driver);
        Assert.assertTrue(hp.menuProductsExists());

    }




}
