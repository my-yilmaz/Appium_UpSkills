package lesson.day03;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.GeneralStoreBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P02_GeneralStore extends GeneralStoreBaseTest {
    /*
    Uygulama: GeneralStore
        GeneralStore uygulamasına gir
        Menüden Angola seçeneğini seç
        Your Name kutusuna Safinaz yaz
        Gender bölümünden Female seçeneğini seç
        Let’s Shop butonuna tıkla
        Ürün listesindeki iki ürünü sepete ekle
        Sepete gir
        Sepette iki ürün olduğunu doğrula
        Ürün fiyatlarını topla
        Total Purchase Amount bölümündeki tutarın doğru olduğunu doğrula
        Send me e-mails.. kutusunu seç
        Visit to the website.. butonuna tıkla
     */

    @Test
    public void test01() {
        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();

        WebElement angola = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Angola\"]"));
        angola.click();

        WebElement nameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameBox.sendKeys("Safinaz");


        WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        female.click();

        WebElement letsShop = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        letsShop.click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();

        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();
        List<WebElement> products = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        Assert.assertEquals(products.size(), 2);

        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            String priceText = products.get(i).getText(); // $160.97 --> $120.0
            double price = Double.parseDouble(priceText.substring(1)); // 160.97  --> 120.0
            total += price;
        }

        double totalAmount = Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(total, totalAmount);

        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();

    }
}
