package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends  BaseClass {
    @Test
    public void testAlert1() {
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(3000);
    }

    @Test
    public void testExplicitWaitAndAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept(); // принять
    }

    @Test
    public void testConfirmBoxAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("confirmButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();  //отклонить
        WebElement text = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(text.getText(),"You selected Cancel");
    }

    @Test
    public void testBoxWillAppearAlert() {
        driver.get("https://demoqa.com/alerts");
        WebElement boxAlertButton = driver.findElement(By.id("promtButton"));
        boxAlertButton.click();
        Alert alert = driver.switchTo().alert();
        String name = "Maral";
        alert.sendKeys(name);
        alert.accept();
        WebElement inputText = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(inputText.getText(),"You entered "+name);

    }
}
