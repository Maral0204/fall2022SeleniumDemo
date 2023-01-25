package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {

    @Test
    public void testDemo1() {

        WebDriverManager.edgedriver().setup(); // configure Edge driver to connect browser
        WebDriver driver = new EdgeDriver();  // creating instance of EdgeDriver
        driver.manage().window().maximize(); // making maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // driver will wait 20 sec
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys("Maral Dyushekeeva");

        WebElement EmailInputField = driver.findElement(By.id("userEmail"));
        EmailInputField.sendKeys("arni200815@gmail.com");

        WebElement AddressInputField = driver.findElement(By.id("currentAddress"));
        AddressInputField.sendKeys("Djal-29, 12-30");

        WebElement PermanentAddressInputField = driver.findElement(By.id("permanentAddress"));
        PermanentAddressInputField.sendKeys("Djal-29, 12-30");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }
}
