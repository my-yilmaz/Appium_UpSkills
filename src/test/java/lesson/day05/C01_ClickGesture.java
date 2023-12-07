package lesson.day05;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class C01_ClickGesture extends ApiDemosBaseTest {
    @Test
    public void testclickGestureElement() throws InterruptedException {
        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));

//        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//                "elementId", ((RemoteWebElement) os).getId()
//        ));


        clickGesture(driver, os);
        Thread.sleep(3000);
    }

    @Test
    public void testclickGestureCoordinate() throws InterruptedException {
//        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//                "x", 720,
//                "y", 1000
//        ));

        clickGesture(driver, 720, 1000);
        Thread.sleep(3000);
    }
}
