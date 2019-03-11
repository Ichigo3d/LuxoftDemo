package support;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Configure {

        private static WebDriver driver;

        public static void initialize() {
            setDriver("chrome"); //chrome
        } // constructor for initialization chrome browser

        public static void close() {
            closeDriver();
        }//constructor for closing of browser

        public static WebDriver getDriver() {
            return driver;
        }//getter which return variable driver

        public static void setDriver(String browser) {
            driver = initializeDriver(browser);
        }//setter, which set method initializeDriver(browser) in variable driver
        //This method defines which browser's driver will execute
        private static WebDriver initializeDriver(String browser) {
            try {
                WebDriver driver;
                String osName = System.getProperty("os.name");//defines which Operative System is able
                switch (browser) {
                    case "chrome":// in case if it is chrome browser, will start this piece of code
                        String chromeDriverName = "chromedriver.exe";// define Windows OS, because variable contains .exe
                        if (osName != null && osName.contains("Mac")) {//define MacOS, because this OS doesn't contain any extensions
                            chromeDriverName = "chromedriver";
                        }
                        System.setProperty("webdriver.chrome.driver", getDriversDirPath() + chromeDriverName);// define path to driver
                        Map<String, Object> chromePreferences = new HashMap<>();// make like a table for changing settings of Chrome
                        chromePreferences.put("profile.default_content_settings.geolocation", 2);// turn off feature gpslocation 2 is means disabled, for enable - 1
                        chromePreferences.put("download.prompt_for_download", false);//function for downloading any file from browser. in this case is disabled
                        chromePreferences.put("download.directory_upgrade", true);// function for updating browser, in this case is able
                        chromePreferences.put("credentials_enable_service", false);//turn off function autorization user
                        chromePreferences.put("password_manager_enabled", false);// turn off manager of passwords
                        chromePreferences.put("safebrowsing.enabled", "true");//turn on function of automatic management of browser
                        ChromeOptions chromeOptions = new ChromeOptions();// creating new object, which getting chromePreferences
                        chromeOptions.addArguments("--start-maximized");
                        chromeOptions.setExperimentalOption("prefs", chromePreferences);
                        driver = new ChromeDriver(chromeOptions);
                        break;


                    default:
                        throw new RuntimeException("Driver is not implemented for: " + browser);//if scripts can't find any drivers, it will get error message
                }
                return driver;
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }

        private static void closeDriver() {
            driver.quit();
        }//closing browser

        private static String getDriversDirPath() {
            return System.getProperty("user.dir") + String.format("/src/main/java/support/drivers/", File.separator);
        }



    }


