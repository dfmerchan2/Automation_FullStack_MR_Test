package co.com.booker.stepdefinitions;

import co.com.booker.models.consult.ConsultBookingIdsResponse;
import co.com.booker.models.consult.ConsultBookingResponse;
import co.com.booker.models.create.CreateBookingResponse;
import co.com.booker.tasks.GetBooking;
import co.com.booker.tasks.GetBookingId;
import co.com.booker.tasks.ReviewDataBookingConsult;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static co.com.booker.utilities.enums.ActorNotepad.CREATE_BOOKING_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

public class ConsultBookingStepDefinition {

    @When("consult existing reservations on the platform")
    public void consult_the_reservations() {
        theActorInTheSpotlight().attemptsTo(
                GetBooking.ofReservations()
        );
    }

    @Then("should see that the query returns information")
    public void shouldSeeThatTheQueryReturnsInformation() {
        List<ConsultBookingIdsResponse> consultBookingIdsResponses =
                theActorInTheSpotlight()
                        .asksFor(GetBooking.getResponseBody());

        theActorInTheSpotlight().should(
                seeThat("The query is not empty",
                        actorSee -> consultBookingIdsResponses.size(),
                        not(0)
                )
        );
    }

    @When("consult the information of the created reservation")
    public void consultTheInformationOfTheReservation() {
        CreateBookingResponse createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                GetBookingId.ofReservations(createBookingResponse.getBookingId())
        );
    }

    @When("consult the reservation with the id {string} non-existent")
    public void consultTheReservationThatTheSystemExists(String bookingId) {
        theActorInTheSpotlight().attemptsTo(
                GetBookingId.ofReservations(bookingId)
                        .withStatusCode(SC_NOT_FOUND)
        );
    }

    @Then("should see the message of error {string}")
    public void shouldSeeTheMessageOfError(String message) {
        theActorInTheSpotlight().should(seeThat(
                actorSee -> GetBookingId.messageResponse(), equalTo(message))
        );
    }

    @Then("should see in the response the information of the reservation consulted")
    public void shouldSeeInTheResponseTheInformationOfTheReservationConsulted() {
        ConsultBookingResponse consultBookingResponse =
                theActorInTheSpotlight().asksFor(GetBookingId.getResponseBody());

        CreateBookingResponse createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                ReviewDataBookingConsult.with(consultBookingResponse, createBookingResponse)
        );
    }
}