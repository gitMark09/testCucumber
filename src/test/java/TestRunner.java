import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/Features/loginWithBackground.feature",
        glue={"GlueCodes"},
        //monochrome = true,
        plugin = {"pretty", "html:target/HTMLReports/reports.html",
                "json:target/JSONReports/reports.json",
                "junit:target/JUnitReports/reports.xml"},
        tags = "@HomepageTests"
        //tags = {@loginSteps or @Tag2}
        //tags = {@loginSteps and @Tag2}
        //tags = {(@loginSteps or @Tag2) and Tag1}
        //tags = {@Tag1 and not @Tag2}
)
public class TestRunner {
}
