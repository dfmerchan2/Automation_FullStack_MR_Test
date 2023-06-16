package co.com.swaglabs.interactions.transversal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPlatform implements Interaction {

    private final String platformUrl;

    public OpenPlatform(String platformUrl) {
        this.platformUrl = platformUrl;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(platformUrl)
        );
    }

    public static Performable of(String platformUrl){
        return instrumented(OpenPlatform.class, platformUrl);
    }
}
