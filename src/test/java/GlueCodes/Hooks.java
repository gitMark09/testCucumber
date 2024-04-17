package GlueCodes;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    WebDriver driver = null;
    WebDriverWait wait = null;

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



}
