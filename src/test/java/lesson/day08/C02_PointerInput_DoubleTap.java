package lesson.day08;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.CalculatorBaseTest;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class C02_PointerInput_DoubleTap extends CalculatorBaseTest {

    @Test
    public void testDoubleTap() {
        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                // first click
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 885, 381))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                // second click
                .addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(), 880, 386))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        wait(3);
    }

}
