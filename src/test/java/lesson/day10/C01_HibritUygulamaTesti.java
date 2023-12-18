package lesson.day10;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class C01_HibritUygulamaTesti extends ApiDemosBaseTest {

    //? Asagidaki komut ile appimu server calistirirken ihtiyac duyarsa driver'i indiriyor.
    //! appium --allow-insecure chromedriver_autodownload
    @Test
    public void testHibrit() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        wait(3);

//        Set<String> contexHandels = driver.getContextHandles();
//        for (String w : contexHandels
//        ) {
//            System.out.println(w);
//        }

        /*
         Test çalıştırdığımızda eğer "ChromeDriver bulunamadı" şeklinde bir hata mesajı alırsak, server'ı aşağıdaki
         komut ile çalıştırıp, testi tekrar çalıştırırız. Böylece chromedriver bilgisayarımıza otomatik olarak yüklenir.
         appium --allow-insecure chromedriver_autodownload
         */

        driver.context("WEBVIEW_io.appium.android.apis");

        System.out.println("URL: " + driver.getCurrentUrl());

        System.out.println("Başlık: " + driver.findElement(By.tagName("h1")).getText());

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        driver.context("NATIVE_APP");

        driver.findElement(AppiumBy.accessibilityId("Visibility")).click();

        wait(2);
    }
}
