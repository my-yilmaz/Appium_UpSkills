package lesson.day07;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lesson.baseTest.HaritalarBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
public class P03_Harita_PinchOpenAndClose extends HaritalarBaseTest {
    /*
    Uygulama: Haritalar
        Haritalar uygulamasına gir
        Harita türü olarak Uydu seçeneğini seç
        Arama motorunda Taj Mahal kelimelerini arat
        Haritada Taj Mahal bölgesine zoom in ve zoom out işlemlerini yap
    */
    @Test
    public void test01() {
        wait(5);
        WebElement katmanlar = driver.findElement(AppiumBy.accessibilityId("Layers"));
        clickGesture(driver, katmanlar);

        WebElement satellite = driver.findElement(AppiumBy.accessibilityId("Satellite"));
        clickGesture(driver, satellite);

        WebElement closeMenu = driver.findElement(AppiumBy.accessibilityId("Close menu"));
        clickGesture(driver, closeMenu);

        WebElement searchHere = driver.findElement(AppiumBy.accessibilityId("Search here"));
        clickGesture(driver, searchHere);

        WebElement searchText = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/search_omnibox_edit_text"));
        searchText.sendKeys("Taj Mahal");

        KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        driver.pressKey(enter);

        wait(10);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 330,
                "top", 560,
                "width", 430,
                "height", 500,
                "percent", 0.75,
                "speed", 300
        ));
        wait(10);
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 330,
                "top", 560,
                "width", 430,
                "height", 500,
                "percent", 0.75,
                "speed", 300
        ));
        wait(10);
    }
}
