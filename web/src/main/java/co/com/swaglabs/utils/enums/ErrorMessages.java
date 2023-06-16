package co.com.swaglabs.utils.enums;

public enum ErrorMessages {
    ERROR_VALIDATING_MESSAGE("Error validating the message")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
