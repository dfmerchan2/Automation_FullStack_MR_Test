package co.com.booker.tasks;

import co.com.booker.models.consult.ConsultBookingResponse;
import co.com.booker.models.create.CreateBookingResponse;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class ReviewDataBookingConsult implements Task {

    private final ConsultBookingResponse consultResponse;
    private final CreateBookingResponse createResponse;


    @Step("{0} review the reservation information")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(consultResponse.getFirstName())
                        .isEqualTo(createResponse.getBooking().getFirstName()),
                Ensure.that(consultResponse.getLastName())
                        .isEqualTo(createResponse.getBooking().getLastName()),
                Ensure.that(consultResponse.getTotalPrice())
                        .isEqualTo(createResponse.getBooking().getTotalPrice()),
                Ensure.that(consultResponse.isDepositPaid())
                        .isEqualTo(createResponse.getBooking().isDepositPaid()),
                Ensure.that(consultResponse.getBookingDates().getCheckIn())
                        .isEqualTo(createResponse.getBooking().getBookingDates().getCheckIn()),
                Ensure.that(consultResponse.getBookingDates().getCheckOut())
                        .isEqualTo(createResponse.getBooking().getBookingDates().getCheckOut()),
                Ensure.that(consultResponse.getAdditionalNeeds())
                        .isEqualTo(createResponse.getBooking().getAdditionalNeeds())
        );
    }

    public static Performable with(ConsultBookingResponse consultResponse, CreateBookingResponse createResponse) {
        return instrumented(ReviewDataBookingConsult.class, consultResponse, createResponse);
    }
}