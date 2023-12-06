package lesson.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lesson.baseTest.ApiDemosBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class C02_TemelEylemler extends ApiDemosBaseTest {

    @Test
    public void testTemelEylemler() throws InterruptedException {
        By app = AppiumBy.accessibilityId("App");
        By activity = AppiumBy.accessibilityId("Activity");
        By customTitle = AppiumBy.accessibilityId("Custom Title");
        By leftTextBox = AppiumBy.id("io.appium.android.apis:id/left_text_edit");
        By rightTextBox = AppiumBy.id("io.appium.android.apis:id/right_text_edit");
        By leftButton = AppiumBy.accessibilityId("Change Left");
        By rightButton = AppiumBy.accessibilityId("Change Right");

        driver.findElement(app).click();
        driver.findElement(activity).click();
        driver.findElement(customTitle).click();

        driver.findElement(leftTextBox).clear(); //! clear() methodu kutuda var olan metni siler
        driver.findElement(leftTextBox).sendKeys("Hello");
        driver.findElement(leftButton).click();

        driver.findElement(rightTextBox).clear();
        driver.setClipboardText("Hi, man!"); //! ctrl+c Komutunun işlevini görür
        driver.findElement(rightTextBox).sendKeys(driver.getClipboardText());
        driver.findElement(rightButton).click();

        KeyEvent back = new KeyEvent(AndroidKey.BACK);
        KeyEvent home = new KeyEvent(AndroidKey.HOME);

        driver.pressKey(back);
        sleep(2000);
        driver.pressKey(home);


    }
}
