package lesson.day09;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class C01_UygulamaEtkilesimleri extends ApiDemosBaseTest {
    @Test
    public void testTerminateApp() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        wait(2);
        driver.terminateApp("io.appium.android.apis");
        wait(4);
    }

    @Test
    public void testActivateApp() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        wait(2);
        driver.terminateApp("io.appium.android.apis");
        wait(2);
        driver.activateApp("com.google.android.calculator");
        wait(3);
        driver.activateApp("io.appium.android.apis");
        wait(3);
    }

    @Test
    public void testRunAppInBackground() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        wait(2);

        driver.runAppInBackground(Duration.ofSeconds(5));

        wait(3);
    }

    @Test
    public void testInstallApp() {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";

        driver.installApp(appUrl);

        wait(5);
    }

    @Test
    public void testIsInstallApp() {
        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));

        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
        driver.installApp(appUrl);

        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));
    }

    @Test
    public void testQueryAppState() {
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        wait(3);

        driver.terminateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        wait(3);

        driver.activateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        wait(3);

        driver.activateApp("com.google.android.calculator");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        wait(3);
    }
}


