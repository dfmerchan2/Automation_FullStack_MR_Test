package co.com.calculator.stepdefinitions;

import co.com.calculator.exceptions.ExpectedResultExceptions;
import co.com.calculator.tasks.MakeMathOperation;
import co.com.calculator.utils.DriverManager;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.calculator.userinterface.CalculatorPage.BTN_RESULT;
import static co.com.calculator.utils.ConversionsUtil.getResult;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class MathematicalOperationsStepDefinition {

    @Given("that {string} opens the calculator application")
    public void thatOpensTheCalculatorApplication(String actor) {
        theActorCalled(actor).can(
                BrowseTheWeb.with(DriverManager.openDesktopApplication())
        );
    }

    @When("he performs the {string} operation with the values {string} and {string}")
    public void hePerformsTheOperationWithTheValuesAnd(String operator, String valueOne, String valueTwo) {
        theActorInTheSpotlight().attemptsTo(
                MakeMathOperation.onTheCalculator(operator, valueOne, valueTwo)
        );
    }

    @Then("he should observe the result equal to {string}")
    public void heShouldObserveTheResultEqualTo(String result) {

        theActorInTheSpotlight().should(
                seeThat("Validar el mensaje de error al autenticarse con credenciales invalidas",
                        actorSee ->
                                getResult(BTN_RESULT.resolveFor(theActorInTheSpotlight()).getText()), equalTo(result))
                        .orComplainWith(ExpectedResultExceptions.class, "El resultado de la operación matemática no es el esperado")
        );
    }
}