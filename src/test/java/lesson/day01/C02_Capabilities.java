package lesson.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_Capabilities {
    @Test
    public void setupUiAutomator2Options() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("7c37a059") //! adb devices - Hangi cihazda testimi çalıştıracaksam onun udid bilgisini giriyorum
                // .setApp("C:\\Users\\my\\IdeaProjects\\Appium_UpSkills\\src\\test\\resources\\ApiDemos-debug.apk") //! Çalıştıracağımız uygulamayı seçmek için
                 .setAppPackage("io.appium.android.apis") //! Çalıştıracağımız uygulamayı seçmek için
                .setAppActivity("io.appium.android.apis.ApiDemos") //! Çalıştıracağımız uygulamayı seçmek için
                //.setAvd("pixel2") //! Kapalı emülatörü açmak için
               // .setAvdLaunchTimeout(Duration.ofMinutes(5)) //! Emülatörün açılışında süre tanımlaması yapmak için
                ;

        URL url = new URL("http://0.0.0.0:4723");

        AndroidDriver driver = new AndroidDriver(url,options);
    }
}
