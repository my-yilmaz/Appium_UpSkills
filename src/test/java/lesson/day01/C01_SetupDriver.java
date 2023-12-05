package lesson.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {
    @Test
    public void setupDesiredCapabilities() throws MalformedURLException {

        //! Javada bulunan File.separator methodunu kullanarak
        //! farkli isletim sistemlerinde bulunan uygulama yolu karmasasi onlenebilir.
        //! Ozellikle "/" ve "\" sembollerinin getirdigi karmasayi

        String appurl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "7c37a059");
        capabilities.setCapability("app", appurl);
        //  capabilities.setCapability("appPackage","io.appium.android.apis");
        //  capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");

        URL url = new URL("http://0.0.0.0:4723");

        AndroidDriver driver = new AndroidDriver(url, capabilities);
    }

    @Test
    public void setupUiAutomator2Options() throws MalformedURLException {
        String appurl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";


        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("7c37a059")
                .setApp(appurl)
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos");

        URL url = new URL("http://0.0.0.0:4723");

        AndroidDriver driver = new AndroidDriver(url, options);
    }
}
