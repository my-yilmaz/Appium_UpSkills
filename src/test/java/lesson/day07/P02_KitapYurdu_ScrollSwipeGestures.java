package lesson.day07;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.KitapYurduBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class P02_KitapYurdu_ScrollSwipeGestures extends KitapYurduBaseTest {
  /*
    Uygulama: Kitap Yurdu
        Kitap Yurdu uygulamasına gir
        İlgi Görenler bölümündeki 5. kitaba tıkla
        Kitap adı, Yazar adı ve Yayınevi adı bilgilerini yazdır
        Künye başlıklarını ve bilgilerini yazdır
    */

    @Test
    public void test01() {
        WebElement swipeElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/recyclerViewList"));
        swipeGesture(driver, swipeElement, "left", 1, 1000);
        wait(3);
        By besinciKitap = AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"com.mobisoft.kitapyurdu:id/mainLayout\"])[3]");
        clickGesture(driver, driver.findElement(besinciKitap));
        wait(3);
        List<WebElement> kitapBilgileri = driver.findElements(AppiumBy.xpath(
                "//android.widget.ScrollView[@resource-id=" +
                        "\"com.mobisoft.kitapyurdu:id/productDetailScrollView\"]" +
                        "//android.widget.TextView"));

        System.out.println("Kitap adi = " + kitapBilgileri.get(0).getText());
        System.out.println("Yazar = " + kitapBilgileri.get(1).getText());
        System.out.println("Yayinevi = " + kitapBilgileri.get(2).getText());

        System.out.println(" Kunye Bilgileri");

        WebElement scroElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView"));
        scrollGesture(driver, scroElement, "down", 3, 1000);

        List<WebElement> baslik = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeTitle"));
        List<WebElement> icerik = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeName"));
        for (int i = 0; i < baslik.size(); i++) {
            System.out.print(baslik.get(i).getText() + "\t");
            System.out.println(icerik.get(i).getText());
        }


    }
}
