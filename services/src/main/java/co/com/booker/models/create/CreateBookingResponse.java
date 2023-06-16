package co.com.booker.models.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookingResponse {
    @JsonProperty("bookingid")
    private String bookingId;
    private CreateBookingRequest booking;
}