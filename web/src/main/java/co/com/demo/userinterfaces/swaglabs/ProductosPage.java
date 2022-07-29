package co.com.demo.userinterfaces.swaglabs;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductosPage {

    public static final Target TITULO_PAGINA =
            Target.the("Titulo de la pagina").located(By.className("title"));
    public static final Target LST_FILTRO =
            Target.the("Lista de opciones para filtrar").located(By.className("product_sort_container"));
    public static final Target BTN_PRODUCTO =
            Target.the("Boton para adicionar producto").locatedBy("//div[@class='inventory_item_description' and contains (.,'{0}')]//button");

    private ProductosPage() {
    }
}
