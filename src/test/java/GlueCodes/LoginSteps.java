package GlueCodes;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
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

    //<<<<<<<<<<<<<<<<  HOOKS
    @Before(value = "@loginSteps", order = 1)   // THIS IS A TAGGED HOOK with ORDER. THESE HOOKS ARE CALLED ONLY WITH MATCHING TAGS IN FEATURE FILE
    public void browserSetup(){
        System.out.println("This is inside @Before HOOK");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Before(value = "@loginSteps", order = 0)      // THIS IS EXECUTED FIRST
    public void bSetup2(){
        System.out.println("This is inside @Before HOOK order=0");

    }

    @Before(value = "@Tag1")      // THIS IS EXECUTED ONLY IF SCENARIO IS TAGGED "@Tag1"
    public void conditional_Hooks(){
        System.out.println("This is inside CONDITIONAL HOOK value = \"@loginSteps\"");

    }

    @After(value = "@loginSteps", order = 1)
    public void teardown(){
        System.out.println("This is inside @After HOOK");
        driver.close();
        driver.quit();
    }

    @After(value = "@loginSteps", order = 2)       //THIS IS EXECUTED FIRST BECAUSE IN @AFTER TAGS, HIGHER ORDER COMES FIRST
    public void teardown2(){
        System.out.println("This is inside @After HOOK order=2");
    }

    @BeforeStep(value = "@loginSteps")
    public void beforeSteps(){
        System.out.println(" Inside BEFORESTEPS ");
    }

    @AfterStep(value = "@loginSteps")
    public void afterSteps(){
        System.out.println(" Inside AFTERSTEPS ");
    }
    //>>>>>>>>>>>>>>>>     HOOKS







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



    //    SAMPLE 1

    @Given("user sample1 given")
    public void user_sample1_given() {
        System.out.println(" This is inside given sample 1");
    }
    @When("user sample1 when")
    public void user_sample1_when() {
        System.out.println("This is inside when sample 1");
    }
    @Then("user sample1 then")
    public void user_sample1_then() {
        System.out.println("This is inside then sample 1");
    }




}
