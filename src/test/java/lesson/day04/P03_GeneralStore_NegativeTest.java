package lesson.day04;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.GeneralStoreBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class P03_GeneralStore_NegativeTest extends GeneralStoreBaseTest {
    /*
    Uygulama: GeneralStore
        GeneralStore uygulamasına gir
        Menüden Angola seçeneğini seç
        Your Name kutusunu boş bırak
        Let’s Shop butonuna tıkla
        Hata mesajını doğrula (Toast Message)
     */

    @Test
    public void test01() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}