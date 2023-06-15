package co.com.calculator.stepdefinitions;

import co.com.calculator.exceptions.ExpectedResultExceptions;
import co.com.calculator.tasks.MakeMathOperation;
import co.com.calculator.utils.DriverManager;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.calculator.userinterface.CalculatorPage.BTN_RESULT;
import static co.com.calculator.utils.ConversionsUtil.getResult;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class MathematicalOperationsStepDefinition {

    @Dado("que {string} abre la aplicación de la calculadora")
    public void openTheCalculatorApp(String actor) {
        theActorCalled(actor).can(
                BrowseTheWeb.with(DriverManager.openDesktopApplication())
        );
    }

    @Cuando("realiza la operación de {string} con los valores {string} y {string}")
    public void performsTheMathematicalOperationWithTheValues(String operator, String valueOne, String valueTwo) {
        theActorInTheSpotlight().attemptsTo(
                MakeMathOperation.onTheCalculator(operator, valueOne, valueTwo)
        );
    }

    @Entonces("debería de observar el resultado igual a {string}")
    public void ObserveTheEqualsResult(String result) {

        theActorInTheSpotlight().should(
                seeThat("Validar el mensaje de error al autenticarse con credenciales invalidas",
                        actorSee ->
                                getResult(BTN_RESULT.resolveFor(theActorInTheSpotlight()).getText()), equalTo(result))
                        .orComplainWith(ExpectedResultExceptions.class, "El resultado de la operación matemática no es el esperado")
        );
    }
}