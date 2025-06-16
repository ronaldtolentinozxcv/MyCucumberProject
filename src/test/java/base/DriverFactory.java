package base;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static ThreadLocal<Properties> tlProperties = new ThreadLocal<>();

    // Load config.properties per thread
    public static void loadConfig() throws IOException {
        Properties prop = new Properties();
        FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop.load(file);
        tlProperties.set(prop);
    }

    public static void setDriver() throws IOException {
        Properties p = tlProperties.get();  // get properties for current thread

        if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (p.getProperty("browser").toLowerCase()) {
                case "chrome":
                    tlDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    tlDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    tlDriver.set(new EdgeDriver());
                    break;
                default:
                    System.out.println("No matching browser");
            }
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static Properties getProperties() {
        return tlProperties.get();
    }

    public static void closeDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
            tlProperties.remove();
        }
    }
}