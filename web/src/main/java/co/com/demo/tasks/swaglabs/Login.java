package co.com.demo.tasks.swaglabs;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.demo.userinterfaces.swaglabs.LoginPage.TXT_USER;
import static co.com.demo.userinterfaces.swaglabs.LoginPage.TXT_PASSWORD;
import static co.com.demo.userinterfaces.swaglabs.LoginPage.BTN_LOGIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String user;
    private final String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Step("{0} authenticates with email ******* and password *******")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(TXT_USER),
                Enter.theValue(password).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN)
        );
    }

    public static Performable inSwagLabs(String user, String password) {
        return instrumented(Login.class, user, password);
    }
}
