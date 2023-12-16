package lesson.day08;

import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class C01_PointerInput_Tap extends ApiDemosBaseTest {
    @Test
    public void testTap() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                //! Parmak, ekran üzerindeki tap yapılacak koordinata hareket ettirilir.
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 350))
                //! Parmak ile, farenin sol tuşuna basar gibi, ekranda belirlediğimiz koordinata bastık.
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                //! Ekranda parmağın basılı olarak duracağı süreyi belirledik.
                .addAction(new Pause(finger, Duration.ofMillis(300)))
                //! Parmağı ekranda bastığımız koordinattan kaldırdık.
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        //! Sıralı adımları topluca eyleme dönüştürdük.
        driver.perform(Collections.singletonList(sequence));

        wait(3);
    }
}
