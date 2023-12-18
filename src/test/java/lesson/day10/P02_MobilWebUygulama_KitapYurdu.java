package lesson.day10;

import lesson.baseTest.ChromeBrowserBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class P02_MobilWebUygulama_KitapYurdu extends ChromeBrowserBaseTest {
    @Test
    public void testRegister() {
        //URL
        driver.get("https://www.kitapyurdu.com/");


        //Çerez
        WebElement cookiescriptAccept = driver.findElement(By.id("cookiescript_accept"));
        visibleWait(driver, cookiescriptAccept, 15);
        cookiescriptAccept.click();

        //Giriş
        driver.findElement(By.xpath("//a[@href=\"index.php?route=account/account\"]")).click();

        // Üye Ol
        driver.findElement(By.partialLinkText("Ücretsiz Üye Ol")).click();

        // Ad Kutusu
        driver.findElement(By.id("firstname")).sendKeys("One");

        // Soyad Kutusu
        driver.findElement(By.id("lastname")).sendKeys("Murata");

        // Eposta Kutusu
        driver.findElement(By.id("email")).sendKeys("oneMurata@godzilla.com");

        // Şifre Kutusu
        driver.findElement(By.id("password")).sendKeys("12345678");

        // Şifre Tekrarı Kutusu
        driver.findElement(By.id("confirm")).sendKeys("12345678");
        driver.hideKeyboard();

        // Kontrol Kutusu
        driver.findElement(By.id("form-check-input")).click();

        // Üye Ol Butonu
        driver.executeScript("arguments[0].click();", driver.findElement(By.id("register-button")));

        // Doğrulama
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Hesabınız Oluşturuldu!']")).getText(),
                "Hesabınız Oluşturuldu!");

    }
}
