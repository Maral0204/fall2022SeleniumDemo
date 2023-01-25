package org.example.intro;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Helper {
private static JavascriptExecutor js;
private static WebDriver driver;

    public static void pause(Integer milliseconds) { //пауза перед следующим действием
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void jsClick (WebDriver driver, WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }

    public static void jsScrollDownThePage(WebDriver driver) {
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public static void jsScrollDownThePage(WebDriver driver, String pixels){
        js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

    public static void waitForElementToDisplay (WebDriver driver,WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
