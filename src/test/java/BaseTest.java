//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
///**
// * Created by rmohanprasad on 04/09/17.
// */
//public class BaseTest {
//
//    private void googleExampleThatSearchFor(final String searchString)
//    {
//        DesiredCapabilities capabilities =DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        System.setProperty("webdriver.gecko.driver", "/Users/rmohanprasad/git/Mastering Selenium TestNG/src/resources/browserexes/geckodriver");
//        //System.setProperty("webdriver.chrome.driver","/Users/rmohanprasad/Downloads/chromedriver");
//       // WebDriver driver = new ChromeDriver();
//
//        WebDriver driver = new FirefoxDriver(capabilities);
//        driver.get("http://www.google.com");
//        WebElement searchField = driver.findElement(By.name("q"));
//        searchField.clear();
//        searchField.sendKeys(searchString);
//        System.out.println("Page title is: " + driver.getTitle());
//        searchField.submit();
//        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driverObject)
//            {
//                return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
//            }
//        });
//        System.out.println("Page title is: " + driver.getTitle());
//        driver.quit();
//    }
//
//    @Test
//    public void googleCheeseExample()
//    {
//        googleExampleThatSearchFor("Cheese!");
//    }
//
//    @Test
//    public void googleMilkExample()
//    {
//        googleExampleThatSearchFor("Milk!");
//    }
//}
