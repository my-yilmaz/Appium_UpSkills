package lesson.day09;

import lesson.baseTest.DeviceBaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_EkranKilidi extends DeviceBaseTest {
    @Test
    public void testLockDevice() {
        driver.lockDevice(Duration.ofMillis(5000));
        wait(3);
    }

    @Test
    public void testUnLockDevice() {
        driver.lockDevice();
        wait(3);
        driver.unlockDevice();
    }

    @Test
    public void testIsDeviceLocked() {
        System.out.println(driver.isDeviceLocked()); //false
        driver.lockDevice();
        wait(3);
        System.out.println(driver.isDeviceLocked()); //true
        driver.unlockDevice();
        wait(2);
        System.out.println(driver.isDeviceLocked());//false
    }
}
