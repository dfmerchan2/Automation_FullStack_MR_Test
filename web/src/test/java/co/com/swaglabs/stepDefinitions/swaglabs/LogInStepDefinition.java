package co.com.swaglabs.stepDefinitions.swaglabs;

import co.com.swaglabs.exceptions.swaglabs.ExceptionValidatingTitle;
import co.com.swaglabs.interactions.transversal.OpenPlatform;
import co.com.swaglabs.questions.swaglabs.ThePageTitle;
import co.com.swaglabs.tasks.swaglabs.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.swaglabs.userinterfaces.swaglabs.LoginPage.LBL_ERROR_MESSAGE;
import static co.com.swaglabs.utils.enums.ErrorMessages.ERROR_VALIDATING_MESSAGE;
import static co.com.swaglabs.utils.enums.PlatformUrl.PLATFORM_SWAG_LABS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LogInStepDefinition {

    @Given("{string} go to the SauceDemo page")
    public void goToTheSauceDemoPage(String actor) {
        theActorCalled(actor).attemptsTo(
                OpenPlatform.of(PLATFORM_SWAG_LABS.getUrl())
        );
    }

    @When("he enter username {string} and password {string}")
    public void heEnterUsernameAndPassword(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.inSwagLabs(user, password)
        );
    }

    @Then("he should see the title of {string}")
    public void heShouldSeeTheTitleOf(String Title) {
        theActorInTheSpotlight()
                .should(
                        seeThat(
                                ThePageTitle.is(), equalToIgnoringCase(Title)
                        ).orComplainWith(
                                ExceptionValidatingTitle.class, ERROR_VALIDATING_MESSAGE.getMessage()
                        )
                );
    }

    @And("he should see the alert with the message {string}")
    public void heShouldSeeTheAlertWithTheMessage(String message) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LBL_ERROR_MESSAGE).text().isEqualToIgnoringCase(message)
        );
    }

}
