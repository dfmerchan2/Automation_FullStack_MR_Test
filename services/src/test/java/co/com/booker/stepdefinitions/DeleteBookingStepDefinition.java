package co.com.booker.stepdefinitions;

import co.com.booker.models.authentication.AuthTokenResponse;
import co.com.booker.models.create.CreateBookingResponse;
import co.com.booker.tasks.DeleteBooking;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.booker.utilities.enums.ActorNotepad.AUTH_TOKEN_RESPONSE;
import static co.com.booker.utilities.enums.ActorNotepad.CREATE_BOOKING_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteBookingStepDefinition {
    @When("delete a booking created")
    public void deleteTheReservationCreated() {
        CreateBookingResponse createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        AuthTokenResponse authTokenResponse =
                theActorInTheSpotlight().recall(AUTH_TOKEN_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                DeleteBooking.with(
                        createBookingResponse.getBookingId(),
                        authTokenResponse.getToken())
        );
    }

    @When("delete the reservation with the id {string} non-existent")
    public void deleteTheReservationNonExistent(String bookingId) {
        AuthTokenResponse authTokenResponse =
                theActorInTheSpotlight().recall(AUTH_TOKEN_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                DeleteBooking.with(bookingId, authTokenResponse.getToken())
                        .withStatusCode(SC_METHOD_NOT_ALLOWED)
        );
    }

    @Then("should see the response {string} when deleting the user")
    public void shouldSeeTheResponseWhenDeletingTheUser(String message) {
        theActorInTheSpotlight().should(seeThat(
                actorSee -> DeleteBooking.messageResponse(), equalTo(message))
        );
    }
}