package co.com.swaglabs.runners.swaglabs;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/web/swaglabs/comprarProductos.feature",
        glue = "co.com.demo.stepDefinitions.web",
        plugin = {"rerun:target/rerunFailed/comprarProductosRerun", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class ComprarProductosRunner {
}
