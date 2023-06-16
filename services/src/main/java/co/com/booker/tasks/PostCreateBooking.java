package co.com.booker.tasks;

import co.com.booker.models.create.CreateBookingRequest;
import co.com.booker.models.create.CreateBookingResponse;
import co.com.booker.questions.ResponseBody;
import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static co.com.booker.utilities.enums.EndPoints.BOOKING;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;

@RequiredArgsConstructor
public class PostCreateBooking implements Task {

    private int statusCode = SC_OK;
    private final CreateBookingRequest createBookingRequest;

    @Step("{0} create a new reservation")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(BOOKING.getValue())
                        .with(
                                request -> request
                                        .contentType(ContentType.JSON)
                                        .body(createBookingRequest)
                                        .log().all()
                        )
        );
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(statusCode)));
    }

    public static PostCreateBooking with(CreateBookingRequest booking) {
        return instrumented(PostCreateBooking.class, booking);
    }

    public PostCreateBooking withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public static Question<CreateBookingResponse> getResponseBody() {
        return new ResponseBody<>(CreateBookingResponse.class, "");
    }
}