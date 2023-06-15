package co.com.calculator.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hook {

    @Before
    public void beforeScenario() {
        OnStage.setTheStage(new OnlineCast());
    }

}
