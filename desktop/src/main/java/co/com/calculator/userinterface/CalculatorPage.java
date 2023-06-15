package co.com.calculator.userinterface;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculatorPage {

    public static final Target BTN_NUMBER = Target.the("Button Number")
            .locatedBy("//*[@Name='{0}']");
    public static final Target BTN_OPERATOR = Target.the("Button Mathematical operator")
            .locatedBy("//*[@Name='{0}']");
    public static final Target BTN_SYMBOL_EQUALS = Target.the("Symbol equals")
            .located(By.name("Es igual a"));
    public static final Target BTN_RESULT = Target.the("Value result")
            .locatedBy("//*[contains(@Name, 'La pantalla muestra')]");
}