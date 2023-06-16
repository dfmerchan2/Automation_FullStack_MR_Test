package co.com.swaglabs.questions.swaglabs;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.swaglabs.userinterfaces.swaglabs.ProductosPage.TITULO_PAGINA;

public class ThePageTitle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return TITULO_PAGINA.resolveFor(actor).getText();
    }

    public static ThePageTitle is(){
        return new ThePageTitle();
    }
}
