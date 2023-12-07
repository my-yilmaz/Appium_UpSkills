package lesson.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import lesson.baseTest.VoadQABaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class C04_PinchOpenAndCloseGestures extends VoadQABaseTest {
    @Test
    public void testPinchOpenAndCloseGesturesElement() throws InterruptedException {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        WebElement element = driver.findElement(AppiumBy.className("android.widget.ImageView"));

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75,
                "speed", 500
        ));

       wait(2);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75,
                "speed", 500
        ));

       wait(5);

    }

    @Test
    public void testPinchOpenAndCloseGesturesCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        wait(1);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200, "top", 1000, "width", 700, "height", 500,
                "percent", 0.75,
                "speed", 500
        ));

        wait(2);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 200, "top", 1000, "width", 700, "height", 500,
                "percent", 0.75,
                "speed", 500
        ));

        wait(5);

    }
}

