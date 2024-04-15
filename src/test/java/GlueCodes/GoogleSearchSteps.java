package GlueCodes;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    WebDriver driver = null;
    WebDriverWait wait =null;

    @Given("user has browser open")
    public void user_has_browser_open() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @And("user opens google webpage")
    public void user_opens_google_webpage() {

        driver.navigate().to("https://www.google.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@title='Search']")));

    }
    @When("^user enters a search (.*) in search box$")
    public void user_enters_a_search_text_in_search_box(String text) {
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys(text);
    }
    @And("presses Enter")
    public void presses_enter() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }
    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result-stats']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result-stats']")).isDisplayed());

    }

}
