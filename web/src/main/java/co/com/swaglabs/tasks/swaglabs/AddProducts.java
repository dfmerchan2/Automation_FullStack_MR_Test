package co.com.swaglabs.tasks.swaglabs;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.List;
import java.util.Map;

import static co.com.swaglabs.userinterfaces.swaglabs.ProductosPage.BTN_PRODUCTO;
import static co.com.swaglabs.userinterfaces.swaglabs.ProductosPage.LST_FILTRO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    private final String filtro;
    private final List<Map<String, String>> producto;

    public AddProducts(String filtro, List<Map<String, String>> producto) {
        this.filtro = filtro;
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(filtro).from(LST_FILTRO)

        );

        producto.forEach(
                i -> actor.attemptsTo(
                        Scroll.to(BTN_PRODUCTO.of(i.get("producto"))),
                        Click.on(BTN_PRODUCTO.of(i.get("producto")))
                )
        );
    }

    public static Performable toShoppingCart(String filtro, List<Map<String, String>> producto) {
        return instrumented(AddProducts.class, filtro, producto);
    }
}
