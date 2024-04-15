import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features",
        glue={"GlueCodes"},
        monochrome = true,
        plugin = {"pretty", "html:target/HTMLReports/reports.html",
                "json:target/JSONReports/reports.json",
                "junit:target/JUnitReports/reports.xml"},
        tags = "@loginTests"
        //tags = {@loginSteps or @Tag2}
        //tags = {@loginSteps and @Tag2}
        //tags = {(@loginSteps or @Tag2) and Tag1}
        //tags = {@Tag1 and not @Tag2}
)
public class FeatureRunner {
}
