package lesson.baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApiDemosBaseTest {
    protected AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        String appurl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";


        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appurl);

        URL url = new URL("http://0.0.0.0:4723");

        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
