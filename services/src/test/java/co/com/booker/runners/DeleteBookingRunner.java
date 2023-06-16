package co.com.booker.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/booker/DeleteBooking.feature",
        plugin = {"pretty", "summary"},
        glue = "co.com.booker.stepdefinitions",
        snippets = CAMELCASE
)

public class DeleteBookingRunner {

}