package org.example.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListTestHW extends BaseClass {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    @Test
    public void testRegistration() {
        driver.navigate().to("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("31");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("3500");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Control");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Helper.pause(3000);
        WebElement newPerson = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[4]"));
        List<WebElement> group = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        //           1 способ - через If
        for (WebElement e : group) {
            System.out.println(e.getText());
            if (e.getText().contains (newPerson.getText()));
                System.out.println("Test passed");
            }

        //           2 способ - через Assert
        for (WebElement e : group) {
            Assert.assertTrue(e.getText().contains(newPerson.getText()), "The test was passed successfully");
        }
    }
}
