package co.com.demo.userinterfaces.swaglabs;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target TXT_USER =
            Target.the("user text box").located(By.id("user-name"));
    public static final Target TXT_PASSWORD =
            Target.the("Password text box").located(By.id("password"));
    public static final Target BTN_LOGIN =
            Target.the("Login button").located(By.id("login-button"));
    public static final Target LBL_ERROR_MESSAGE =
            Target.the("Incorrect credentials message").located(By.xpath("//h3[@data-test='error']"));

    private LoginPage() {
    }
}
