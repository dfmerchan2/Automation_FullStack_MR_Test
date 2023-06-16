package co.com.booker.stepdefinitions;

import co.com.booker.models.builder.CreateBookingRequestBuilder;
import co.com.booker.models.create.CreateBookingRequest;
import co.com.booker.models.create.CreateBookingResponse;
import co.com.booker.tasks.PostCreateBooking;
import co.com.booker.tasks.ReviewDataBookingCreated;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.booker.utilities.enums.ActorNotepad.CREATE_BOOKING_RESPONSE;
import static co.com.booker.utilities.enums.ActorNotepad.REQUEST_CREATE_REQUEST;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateBookingStepDefinition {

    @When("create a reservation request")
    public void create_a_reservation_request() {
        CreateBookingRequest createBookingRequest =
                CreateBookingRequestBuilder.createBookingRequest();

        theActorInTheSpotlight().attemptsTo(
                PostCreateBooking.with(createBookingRequest));

        CreateBookingResponse createBookingResponse =
                theActorInTheSpotlight().asksFor(PostCreateBooking.getResponseBody());

        theActorInTheSpotlight().remember(REQUEST_CREATE_REQUEST.getKey(), createBookingRequest);
        theActorInTheSpotlight().remember(CREATE_BOOKING_RESPONSE.getKey(), createBookingResponse);
    }

    @Then("should see in the response the information of the reservation created")
    public void shouldSeeTheReservationInformationInTheResponse() {
        CreateBookingRequest request =
                theActorInTheSpotlight().recall(REQUEST_CREATE_REQUEST.getKey());

        CreateBookingResponse response =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                ReviewDataBookingCreated.onThePlatform(response, request)
        );
    }
}