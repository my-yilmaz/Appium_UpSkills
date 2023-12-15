package lesson.day07;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.TelefonBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class P01_Telefon_LongClickGesture extends TelefonBaseTest {
    /*
   Uygulama: Telefon
       Telefon uygulamasına gir
       +90 530 486 1275 numarasını ara
       Mesajda, Arama başarısız oldu. metnini doğrula
       Tamam butonuna bas
    */
    @Test
    public void testLongCLick() {
        By keyPad = AppiumBy.accessibilityId("key pad");
        By one = AppiumBy.accessibilityId("1,");
        By two = AppiumBy.accessibilityId("2,ABC");
        By tree = AppiumBy.accessibilityId("3,DEF");
        By four = AppiumBy.accessibilityId("4,GHI");
        By five = AppiumBy.accessibilityId("5,JKL");
        By six = AppiumBy.accessibilityId("6,MNO");
        By seven = AppiumBy.accessibilityId("7,PQRS");
        By eight = AppiumBy.accessibilityId("8,TUV");
        By nine = AppiumBy.accessibilityId("9,WXYZ");
        By zero = AppiumBy.accessibilityId("0");
        By call = AppiumBy.accessibilityId("dial");
        By endCall = AppiumBy.accessibilityId("End call");

        clickGesture(driver, driver.findElement(keyPad));

        longClickGesture(driver, driver.findElement(zero), 1000);
        clickGesture(driver, driver.findElement(nine));
        clickGesture(driver, driver.findElement(zero));
        clickGesture(driver, driver.findElement(five));
        clickGesture(driver, driver.findElement(tree));
        clickGesture(driver, driver.findElement(zero));
        clickGesture(driver, driver.findElement(four));
        clickGesture(driver, driver.findElement(eight));
        clickGesture(driver, driver.findElement(six));
        clickGesture(driver, driver.findElement(one));
        clickGesture(driver, driver.findElement(two));
        clickGesture(driver, driver.findElement(seven));
        clickGesture(driver, driver.findElement(five));

        clickGesture(driver, driver.findElement(call));

        wait(10);

        clickGesture(driver, driver.findElement(endCall));

        driver.quit();

    }
}
