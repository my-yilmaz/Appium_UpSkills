package lesson.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class C01_ScrollGesture extends ApiDemosBaseTest {
    @Test
    public void testScrollToElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy
                .androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layouts\"))"));
        Thread.sleep(5000);

        Thread.sleep(5000);
    }

    @Test
    public void testScrollGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 2.0,
                "speed", 500
        ));

        Thread.sleep(2000);

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 2.0,
                "speed", 500
        ));

        Thread.sleep(5000);
    }

    @Test
    public void testScrollGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();


        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 300, "width", 0, "height", 1000,
                    "direction", "down",
                    "percent", 1.0,
                    "speed", 500
            ));
        }

        Thread.sleep(2000);
    }
}
