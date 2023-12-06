package lesson.day03;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P01_ApiDemos extends ApiDemosBaseTest {
    @Test
    public void test01() {

         /*
    Uygulama: ApiDemos
        API Demos uygulamasına gir
        Preference seçeneğine tıkla
        3. Preference dependencies seçeneğine tıkla
        WiFi kontrol kutusunu seç
        WiFi settings seçeneğine tıkla
        Açılan ekrandaki başlığın WiFi settings olduğunu doğrula
        Metin kutusuna adını yaz
        Tamam butonuna tıkla
     */

        By preference = AppiumBy.accessibilityId("Preference");
        By ucPreDep = AppiumBy.accessibilityId("3. Preference dependencies");
        By wifiCheckBox = AppiumBy.id("android:id/checkbox");
        By wiFiSettings = AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By alertTitle = AppiumBy.id("android:id/alertTitle");
        By metinKutusu = AppiumBy.id("android:id/edit");
        By tamam = AppiumBy.id("android:id/button1");

        driver.findElement(preference).click();
        driver.findElement(ucPreDep).click();
        driver.findElement(wifiCheckBox).click();
        driver.findElement(wiFiSettings).click();

        String actualTitle = driver.findElement(alertTitle).getText();
        String expectedTitle = "WiFi settings";
        Assert.assertEquals(actualTitle, expectedTitle);

        driver.findElement(metinKutusu).sendKeys("Muhammed");
        driver.findElement(tamam).click();
    }
}
