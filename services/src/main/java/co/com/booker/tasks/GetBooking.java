package co.com.booker.tasks;

import co.com.booker.models.consult.ConsultBookingIdsResponse;
import co.com.booker.questions.ResponseBodyList;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static co.com.booker.utilities.enums.EndPoints.BOOKING;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;

public class GetBooking implements Task {

    private int statusCode = SC_OK;

    @Step("{0} consult all the reservations")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(BOOKING.getValue())
                        .with(
                                request -> request
                                        .contentType(ContentType.JSON)
                                        .log()
                                        .all()
                        )
        );
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(statusCode)));
    }

    public static GetBooking ofReservations() {
        return instrumented(GetBooking.class);
    }

    public GetBooking withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public static Question<List<ConsultBookingIdsResponse>> getResponseBody() {
        return new ResponseBodyList<>(ConsultBookingIdsResponse.class, "");
    }
}