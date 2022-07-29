package co.com.demo.runners.swaglabs;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/swaglabs/LogIn.feature",
        glue = "co.com.demo.stepDefinitions",
        plugin = {"rerun:/target/rerunFailed/LogInRerun", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class LogInRunner {
}
