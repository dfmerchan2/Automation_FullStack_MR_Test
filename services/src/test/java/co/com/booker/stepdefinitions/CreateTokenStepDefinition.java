package co.com.booker.stepdefinitions;

import co.com.booker.models.authentication.AuthTokenRequest;
import co.com.booker.models.authentication.AuthTokenResponse;
import co.com.booker.models.builder.AuthTokenRequestBuilder;
import co.com.booker.tasks.PostAuthCreateToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static co.com.booker.utilities.enums.ActorNotepad.AUTH_TOKEN_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;

public class CreateTokenStepDefinition {
    @Given("{string} authenticates with user {string} and password {string}")
    public void thatAuthenticatesSuccessfullyWithUserAndPassword(String actor, String username, String password) {

        AuthTokenRequest authTokenRequest =
                AuthTokenRequestBuilder.authTokenRequest(username, password);

        theActorCalled(actor).attemptsTo(
                PostAuthCreateToken.with(authTokenRequest));

        AuthTokenResponse authTokenResponse =
                theActorCalled(actor).asksFor(PostAuthCreateToken.getResponseBody());

        theActorCalled(actor).remember(AUTH_TOKEN_RESPONSE.getKey(), authTokenResponse);
    }

    @Then("should see the token generated successfully")
    public void shouldSeeTheTokenGeneratedSuccessfully() {
        AuthTokenResponse authTokenResponse =
                theActorInTheSpotlight().recall(AUTH_TOKEN_RESPONSE.getKey());

        theActorInTheSpotlight().should(
                seeThat("Validate incorrect credentials",
                        actorSee -> authTokenResponse.getToken(), notNullValue()),
                seeThat("Validate incorrect credentials",
                        actorSee -> authTokenResponse.getReason(), nullValue()
                )
        );
    }

    @Then("should see the error message {string}")
    public void shouldSeeTheErrorMessage(String message) {
        AuthTokenResponse authTokenResponse =
                theActorInTheSpotlight().recall(AUTH_TOKEN_RESPONSE.getKey());

        theActorInTheSpotlight().should(
                seeThat("Validate incorrect credentials",
                        actorSee -> authTokenResponse.getToken(), nullValue()),
                seeThat("Validate incorrect credentials",
                        actorSee -> authTokenResponse.getReason(), equalTo(message)
                )
        );
    }
}