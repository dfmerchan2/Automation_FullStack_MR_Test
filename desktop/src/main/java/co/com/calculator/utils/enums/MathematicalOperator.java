package co.com.calculator.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum MathematicalOperator {

    SYMBOL_DIVISION("División", "Dividir por"),
    SYMBOL_MINUS("Resta", "Menos"),
    SYMBOL_MULTIPLICATION("Multiplicación", "Multiplicar por"),
    SYMBOL_PLUS("Suma", "Más");

    private final String operator;
    private final String value;

    public static MathematicalOperator option(String typeOperator) {
        return Arrays.stream(MathematicalOperator.values())
                .filter(number -> number.getOperator().equalsIgnoreCase(typeOperator))
                .findFirst()
                .orElse(null);
    }
}
