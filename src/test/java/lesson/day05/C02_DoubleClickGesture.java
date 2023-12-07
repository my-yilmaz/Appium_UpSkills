package lesson.day05;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import lesson.baseTest.CalculatorBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C02_DoubleClickGesture extends CalculatorBaseTest {
    @Test
    public void testdoubleClickGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();

        WebElement sonuc = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));
        doubleClickGesture(driver, sonuc); // double click yapmasina ragmen metni secmiyor

        Thread.sleep(2000);
    }

    @Test
    public void testclickGestureCoordinate() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();

        doubleClickGesture(driver, 885, 381);  // metni seciyor

        Thread.sleep(2000);

        clickGesture(driver, 560, 730);  // kes butonuna tikliyor

        Thread.sleep(2000);
    }
}
