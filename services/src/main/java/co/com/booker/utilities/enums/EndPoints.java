package co.com.booker.utilities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EndPoints {
    AUTH_CREATE_TOKEN("auth"),
    BOOKING("booking"),
    BOOKING_ID("booking/{id}"),
    END_POINTS_BASE("https://restful-booker.herokuapp.com/"),
    PING("ping");

    private final String value;

}