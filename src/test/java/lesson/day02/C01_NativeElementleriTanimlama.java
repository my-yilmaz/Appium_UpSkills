package lesson.day02;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C01_NativeElementleriTanimlama extends ApiDemosBaseTest {
    @Test
    public void testWebElement() {
        WebElement app = driver.findElement(AppiumBy.accessibilityId("App"));
        app.click();

        WebElement alarm = driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarm.click();

        WebElement alarmController = driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));
        alarmController.click();
    }

    @Test
    public void testBy() {
        By app = AppiumBy.accessibilityId("App");
        By alarm = AppiumBy.accessibilityId("Alarm");
        By alarmController = AppiumBy.accessibilityId("Alarm Controller");

        driver.findElement(app).click();
        driver.findElement(alarm).click();
        driver.findElement(alarmController).click();
    }
}
