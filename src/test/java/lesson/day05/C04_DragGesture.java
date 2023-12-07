package lesson.day05;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class C04_DragGesture extends ApiDemosBaseTest {
    @Test
    public void testDragGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 650,
                "endY", 550,
                "speed", 500
        ));

        Thread.sleep(5000);
    }

    @Test
    public void testDragGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

//        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
//                "startX", 200,
//                "startY", 550,
//                "endX", 650,
//                "endY", 550,
//                "speed", 500
//        ));

        dragGesture(driver, 200, 550, 650, 550);

        Thread.sleep(5000);
    }
}