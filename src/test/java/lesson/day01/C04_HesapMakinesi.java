package lesson.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class C04_HesapMakinesi {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.google.android.calculator")
                .setAppActivity("com.android.calculator2.Calculator");
        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

        WebElement num1 = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        WebElement num2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        WebElement num3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        WebElement num4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        WebElement num5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        WebElement num6 = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        WebElement num7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        WebElement num8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        WebElement num9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        WebElement num0 = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));

        WebElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        WebElement minus = driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
        WebElement multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
        WebElement divide = driver.findElement(By.id("com.google.android.calculator:id/op_div"));
        WebElement equal = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        num4.click();
        multiply.click();
        num5.click();

        WebElement preResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
        String preResultText = preResult.getText();
        System.out.println(preResult.getText());

        equal.click();

        sleep(2);

        WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        System.out.println(result.getText());

        Assert.assertEquals(result.getText(), preResultText);
        
    }
}
