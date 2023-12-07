package lesson.day05;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C03_LongClickGesture extends ApiDemosBaseTest {
    @Test
    public void testLongClickGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
        WebElement longPressMe = driver.findElement(AppiumBy.accessibilityId("Long press me"));

//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) longPressMe).getId(),
//                "duration", 1000
//        ));

        longClickGesture(driver, longPressMe, 1000);
        Thread.sleep(3000);
    }
    @Test
    public void testLongClickGestureCooredinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

//        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
//                "x", 464,
//                "y", 500,
//                "duration", 1000
//        ));

        longClickGesture(driver, 500, 444, 1000);
        Thread.sleep(5000);
    }
}
