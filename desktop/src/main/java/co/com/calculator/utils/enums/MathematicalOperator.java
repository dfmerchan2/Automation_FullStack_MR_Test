package co.com.calculator.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum MathematicalOperator {

    SYMBOL_DIVISION("Division", "Dividir por"),
    SYMBOL_MINUS("Subtraction", "Menos"),
    SYMBOL_MULTIPLICATION("Multiplication", "Multiplicar por"),
    SYMBOL_PLUS("sum", "Más");

    private final String operator;
    private final String value;

    public static MathematicalOperator option(String typeOperator) {
        return Arrays.stream(MathematicalOperator.values())
                .filter(number -> number.getOperator().equalsIgnoreCase(typeOperator))
                .findFirst()
                .orElse(null);
    }
}
