package co.com.booker.models.consult;

import co.com.booker.models.create.BookingDates;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultBookingResponse {

    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("totalprice")
    private int totalPrice;
    @JsonProperty("depositpaid")
    private boolean depositPaid;
    @JsonProperty("bookingdates")
    private BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    private String additionalNeeds;
}