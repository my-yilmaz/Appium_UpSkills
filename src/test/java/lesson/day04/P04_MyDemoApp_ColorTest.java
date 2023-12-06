package lesson.day04;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.MyDemoBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class P04_MyDemoApp_ColorTest extends MyDemoBaseTest {
    /*
    Uygulama: MyDemoApp
        MyDemoApp uygulamasına gir
        Menüyü aç
        Login ol (bob@example.com, 10203040)
        Login butonuna tıkla
        İlk ürünü seç
        Renk olarak mavi seç
        Add To Cart butonuna tıkla
        Renk olarak kırmızı seç
        Add To Cart butonuna tıkla
        Sepete git
        Listede iki ürün olduğunu doğrula
        Listedeki ürünlerin mavi ve kırmızı olduğunu doğrula
     */

    @Test
    public void test01() {
        WebElement menu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        menu.click();

        WebElement menuLogin = driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        menuLogin.click();

        WebElement username = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        username.sendKeys("bob@example.com");

        WebElement password = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        password.sendKeys("10203040");
        driver.hideKeyboard();

        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("Login button"));
        loginButton.click();

        WebElement ilkUrun = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        ilkUrun.click();

        By blue = AppiumBy.accessibilityId("blue circle");
        driver.findElement(blue).click();

        WebElement addToCartButton = driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        addToCartButton.click();

        By red = AppiumBy.accessibilityId("red circle");
        driver.findElement(red).click();
        addToCartButton.click();

        WebElement cartBadge = driver.findElement(AppiumBy.accessibilityId("cart badge"));
        cartBadge.click();

        List<WebElement> urunler = driver.findElements(AppiumBy.accessibilityId("product row"));
        Assert.assertEquals(urunler.size(), 2);

        Assert.assertTrue(driver.findElement(blue).isDisplayed());
        Assert.assertTrue(driver.findElement(red).isDisplayed());

        List<WebElement> blueCircle2 = driver.findElements
                (AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"product row\"])[1]" +
                        "//android.view.ViewGroup[contains(@content-desc, 'blue circle')]"));
        Assert.assertFalse(blueCircle2.isEmpty());


    }
}
