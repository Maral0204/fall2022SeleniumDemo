package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseClass{
    @Test
    public void testExplicitWait () {
        driver.navigate().to("https://demoqa.com/dynamic-properties");
        WebElement enableAfter=driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click(); //ждем когда элемент станет кликабельным и после кликаем
        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class", "text-danger"));
        WebElement colorChange = driver.findElement(By.id("colorChange"));
        colorChange.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter"))).click();


    }
}
