package co.com.calculator.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/calculator/mathematical_operations.feature",
        plugin = {"pretty", "summary"},
        glue = "co.com.calculator.stepdefinitions",
        snippets = CAMELCASE
)

public class MathematicalOperationRunner {
}
