package co.com.calculator.interaction;

import co.com.calculator.utils.enums.NumberValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;

import static co.com.calculator.userinterface.CalculatorPage.BTN_NUMBER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
@Getter
public class TypeNumber implements Interaction {

    private final String number;

    @Override
    @Step("{0} digita el numero #number en la calculadora")
    public <T extends Actor> void performAs(T actor) {
        List<String> listNumber = Arrays.stream(number.split("")).toList();

        listNumber.forEach(
                value ->
                        actor.attemptsTo(
                                Click.on(BTN_NUMBER.of(NumberValue.option(value).getValueString()))
                        )
        );
    }

    public static Performable onTheCalculator(String number) {
        return instrumented(TypeNumber.class, number);
    }
}
