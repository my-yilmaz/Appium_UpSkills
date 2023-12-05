package lesson.day01;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C03_Locators {
    @Test
    public void setupUiAutomator2Options() throws MalformedURLException {
        String appurl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";


        UiAutomator2Options options = new UiAutomator2Options()
                //.setUdid("7c37a059")
                //.setApp(appurl)
                .setAppPackage("io.appium.android.apis")
                .setAppActivity("io.appium.android.apis.ApiDemos");

        URL url = new URL("http://0.0.0.0:4723");

        AndroidDriver driver = new AndroidDriver(url, options);
        // 1 - accessibilityId:
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID: " + element.getText());

        // 2 - id:
        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("ID : " + element.getText());

        // 3 - className:
        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("ClassName : " + element.getText());

        // 4 - androidUIAutomator:
        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("Android UI Automator : " + element.getText());

        // 5 - xpath:
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Accessibility\"]"));
        System.out.println("XPath : " + element.getText());

        driver.quit();
    }
}
