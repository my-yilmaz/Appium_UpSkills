package lesson.day02;

import io.appium.java_client.AppiumBy;
import lesson.baseTest.ApiDemosBaseTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class C03_ElementDegerleriniCekme extends ApiDemosBaseTest {

    @Test
    public void testElementDegerleriniCekme() {
        By accessibility = AppiumBy.accessibilityId("Accessibility");

        System.out.println("Get Text: " + driver.findElement(accessibility).getText()); // Get Text: Accessibility
        System.out.println("Get Attribute: " + driver.findElement(accessibility).getAttribute("package")); // Get Attribute: io.appium.android.apis
        System.out.println("Get Attribute: " + driver.findElement(accessibility).getAttribute("checkable")); // Get Attribute: false

        System.out.println("isSelected: " + driver.findElement(accessibility).isSelected()); // isSelected: false
        System.out.println("isEnabled: " + driver.findElement(accessibility).isEnabled()); // isEnabled: true
        System.out.println("isDisplayed: " + driver.findElement(accessibility).isDisplayed()); // isDisplayed: true

        System.out.println("Get Size: " + driver.findElement(accessibility).getSize()); // Get Size: (1080, 132)
        System.out.println("Get Location: " + driver.findElement(accessibility).getLocation()); // Get Location: (0, 382)
    }
}
