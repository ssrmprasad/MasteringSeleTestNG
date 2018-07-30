import config.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

import static config.DriverType.FIREFOX;
import static config.DriverType.valueOf;

/**
 * Created by rmohanprasad on 04/09/17.
 */
public class WebDriverThread {

    private WebDriver webDriver;
    private DriverType selectedDriverType;

    private final DriverType defaultDriverType = FIREFOX;

    private final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private final String systemArchitecture = System.getProperty("os.arch");
    private final String browser = System.getProperty("browser").toUpperCase();

    public WebDriver getDriver() throws Exception
    {
        if(null==webDriver)
        {

            selectedDriverType = determineEffectiveDriveType();
            DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
            instantiateWebDriver(desiredCapabilities);
            //webDriver = new FirefoxDriver(DesiredCapabilities.firefox());
        }
        return webDriver;
    }

    public void quitDriver()
    {
        if(null!=webDriver)
        {
            webDriver.quit();
           // webDriver=null;
        }
    }

    private DriverType determineEffectiveDriveType()
    {
        DriverType driverType = defaultDriverType;
        try{
           driverType =  valueOf(browser);
        }catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        return driverType;
    }
    private void instantiateWebDriver(DesiredCapabilities desiredCapabilities) throws MalformedURLException
    {
        System.out.println(" ");
        System.out.println("Current Operating System: " + operatingSystem);
        System.out.println("Current Architecture: " + systemArchitecture);
        System.out.println("Current Browser Selection: " + selectedDriverType);
        System.out.println(" ");
        webDriver = selectedDriverType.getWebDriverObject(desiredCapabilities);

    }
}
