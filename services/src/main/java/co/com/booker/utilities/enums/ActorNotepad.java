package co.com.booker.utilities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActorNotepad {
    AUTH_TOKEN_RESPONSE("auth token response"),
    CREATE_BOOKING_RESPONSE("create booking response"),
    REQUEST_CREATE_REQUEST("request create booking"),
    DESCRIPTION_BOOKING("description booking"),
    HOTEL_NAME("hotel name"),
    HOTEL_VALUE("hotel value"),
    USER_NAME("user name");

    private final String key;

}