package co.com.calculator.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverManager {

    @SneakyThrows
    public static WebDriver openDesktopApplication() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        capabilities.setCapability("platformName", "windows");
        return new RemoteWebDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
}
