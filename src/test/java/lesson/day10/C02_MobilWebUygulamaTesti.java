package lesson.day10;

import lesson.baseTest.ChromeBrowserBaseTest;
import org.testng.annotations.Test;

public class C02_MobilWebUygulamaTesti extends ChromeBrowserBaseTest {
    @Test
    public void testBrowser() {
        driver.get("https://www.amazon.com");

        wait(3);

    }
}
