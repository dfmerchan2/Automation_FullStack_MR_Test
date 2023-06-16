package co.com.booker.tasks;

import io.restassured.http.ContentType;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static co.com.booker.utilities.enums.EndPoints.PING;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_CREATED;

@RequiredArgsConstructor
public class GetHealthCheck implements Task {

    private int statusCode = SC_CREATED;
    private final String message;

    @Step("{0} validate the state of the service")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PING.getValue())
                        .with(
                                request -> request
                                        .contentType(ContentType.JSON)
                                        .log()
                                        .all()
                        )
        );
        SerenityRest.lastResponse().print();
        actor.should(seeThatResponse(response -> response.statusCode(statusCode)));
    }

    public static GetHealthCheck fromService(String message) {
        return instrumented(GetHealthCheck.class, message);
    }

    public GetHealthCheck withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public static String messageResponse() {
        return SerenityRest.lastResponse().body().asString();
    }
}