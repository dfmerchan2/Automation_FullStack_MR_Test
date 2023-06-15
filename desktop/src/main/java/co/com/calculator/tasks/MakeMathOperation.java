package co.com.calculator.tasks;

import co.com.calculator.interaction.TypeNumber;
import co.com.calculator.utils.enums.MathematicalOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.calculator.userinterface.CalculatorPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
@Getter
public class MakeMathOperation implements Task {

    private final String operator;
    private final String valueOne;
    private final String valueTwo;


    @Override
    @Step("{0} realiza el proceso de #operator con los valores #valueOne y #valueTwo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TypeNumber.onTheCalculator(valueOne),
                Click.on(BTN_OPERATOR.of(MathematicalOperator.option(operator).getValue())),
                TypeNumber.onTheCalculator(valueTwo),
                Click.on(BTN_SYMBOL_EQUALS)
        );
    }

    public static Performable onTheCalculator(String operator, String valueOne, String valueTwo) {
        return instrumented(MakeMathOperation.class, operator, valueOne, valueTwo);
    }
}
