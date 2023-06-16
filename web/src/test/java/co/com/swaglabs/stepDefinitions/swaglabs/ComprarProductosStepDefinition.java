package co.com.swaglabs.stepDefinitions.swaglabs;

import co.com.swaglabs.tasks.swaglabs.AddProducts;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ComprarProductosStepDefinition {

    @Cuando("realiza el filtro por {string} para adiciona los productos al carrito de compras")
    public void realizaElFiltroPorParaAdicionaLosProductosAlCarritoDeCompras(String filtro, List<Map<String, String>> producto) {
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toShoppingCart(filtro, producto)
        );
    }


    @Y("observa los productos agragdos al carrito de compras")
    public void observaLosProductosAgragdosAlCarritoDeCompras() {

    }

    @Entonces("ingresa su informacion personal")
    public void ingresaSuInformacionPersonal() {

    }

    @Y("observa la factura para finalizar el pedido")
    public void observaLaFacturaParaFinalizarElPedido() {

    }

}
