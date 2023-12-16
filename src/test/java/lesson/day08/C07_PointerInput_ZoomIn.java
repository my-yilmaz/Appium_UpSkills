package lesson.day08;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import lesson.baseTest.VoadQABaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class C07_PointerInput_ZoomIn extends VoadQABaseTest {
    @Test
    public void testZoomIn() {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        wait(2);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequence1 = new Sequence(finger1, 1);
        Sequence sequence2 = new Sequence(finger2, 2);

        sequence1
                .addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 450, 1200))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(300)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), 150, 1200))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        sequence2
                .addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 620, 1200))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2, Duration.ofMillis(300)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), 840, 1200))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1, sequence2));

        wait(5);
    }
}
