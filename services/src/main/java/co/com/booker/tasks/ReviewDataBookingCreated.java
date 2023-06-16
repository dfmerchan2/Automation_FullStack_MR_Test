package co.com.booker.tasks;

import co.com.booker.models.create.CreateBookingRequest;
import co.com.booker.models.create.CreateBookingResponse;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ReviewDataBookingCreated implements Task {

    private final CreateBookingResponse response;
    private final CreateBookingRequest request;

    @Step("{0} validates the response from the build service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(response.getBookingId()).isNotNull(),
                Ensure.that(response.getBooking().getFirstName())
                        .isEqualTo(request.getFirstName()),
                Ensure.that(response.getBooking().getLastName())
                        .isEqualTo(request.getLastName()),
                Ensure.that(response.getBooking().getTotalPrice())
                        .isEqualTo(request.getTotalPrice()),
                Ensure.that(response.getBooking().isDepositPaid())
                        .isEqualTo(request.isDepositPaid()),
                Ensure.that(response.getBooking().getBookingDates().getCheckIn())
                        .isEqualTo(request.getBookingDates().getCheckIn()),
                Ensure.that(response.getBooking().getBookingDates().getCheckOut())
                        .isEqualTo(request.getBookingDates().getCheckOut()),
                Ensure.that(response.getBooking().getAdditionalNeeds())
                        .isEqualTo(request.getAdditionalNeeds())
        );
    }

    public static Performable onThePlatform(CreateBookingResponse response, CreateBookingRequest request) {
        return instrumented(ReviewDataBookingCreated.class, response, request);
    }
}