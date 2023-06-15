package co.com.calculator.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum NumberValue {

    CERO("0", "Cero"),
    ONE("1", "Uno"),
    TWO("2", "Dos"),
    THREE("3", "Tres"),
    FOUR("4", "Cuatro"),
    FIVE("5", "Cinco"),
    SIX("6", "Seis"),
    SEVEN("7", "Siete"),
    EIGHT("8", "Ocho"),
    NINE("9", "Nueve");

    private final String valueInteger;
    private final String valueString;

    public static NumberValue option(String numberOption) {
        return Arrays.stream(NumberValue.values())
                .filter(number -> number.getValueInteger().equals(numberOption))
                .findFirst()
                .orElse(null);
    }
}