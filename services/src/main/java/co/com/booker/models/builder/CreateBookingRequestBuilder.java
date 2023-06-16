package co.com.booker.models.builder;

import co.com.booker.models.create.BookingDates;
import co.com.booker.models.create.CreateBookingRequest;
import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import static co.com.booker.utilities.Constants.FORMAT_DATE;
import static co.com.booker.utilities.ConversionUtility.getCurrentDate;
import static co.com.booker.utilities.ConversionUtility.getFutureOrPastDate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateBookingRequestBuilder {

    public static CreateBookingRequest createBookingRequest() {
        return CreateBookingRequest.builder()
                .firstName(Faker.instance().name().firstName())
                .lastName(Faker.instance().name().lastName())
                .totalPrice(Integer.parseInt(Faker.instance().number().digits(3)))
                .depositPaid(true)
                .bookingDates(
                        BookingDates.builder()
                                .checkIn(getCurrentDate(FORMAT_DATE))
                                .checkOut(getFutureOrPastDate(FORMAT_DATE, 5))
                                .build())
                .additionalNeeds("Breakfast")
                .build();
    }
}