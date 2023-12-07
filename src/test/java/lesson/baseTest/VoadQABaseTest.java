package lesson.baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lesson.utilities.ReusableMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class VoadQABaseTest extends ReusableMethods {
    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + ("src")
                + File.separator + ("test")
                + File.separator + ("resources")
                + File.separator + ("VodQA.apk");

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("7c37a059")
                .setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
