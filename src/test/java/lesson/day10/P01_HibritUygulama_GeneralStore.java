package lesson.day10;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lesson.baseTest.GeneralStoreBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class P01_HibritUygulama_GeneralStore extends GeneralStoreBaseTest {
    @Test
    public void testGeneralStore() {
        // Menu Click
        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();
        //Ulke secimi
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"))"));

        WebElement barbados = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Barbados\"]"));
        barbados.click();

        // Isim Yazma
        WebElement nameBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameBox.sendKeys("Safinaz");

        // Cinsiyet
        WebElement female = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        female.click();

        //Buton
        WebElement letsShop = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        letsShop.click();

        //Ürün Seçimi
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(1).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike SFB Jungle\"))"));
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(2).click();

        //Sepet
        WebElement cart = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();

        //Fiyat Doğrulaması
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

        // CheckBox
        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        //Visit
        WebElement visitButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();

        wait(3);

        //Hibrit Uygulama
        // Sadece Web context'inin değerini alabilmek için bu kodu yazmaya ihtiyacım var.
        Set<String> contexHandels = driver.getContextHandles();
        for (String contexName : contexHandels
        ) {
            System.out.println("contexName = " + contexName);
        }

        // Hibrit web e gecis
        driver.context("WEBVIEW_com.androidsample.generalstore");

        // arama yapma
        driver.findElement(By.name("q")).sendKeys("One Piece", Keys.ENTER);

        // Telefonda geri yapma
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        // NATIVE_APP ye gecis
        driver.context("NATIVE_APP");

        //baslik dogrulama
        String title = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(title, "General Store");

        driver.quit();
    }
}
