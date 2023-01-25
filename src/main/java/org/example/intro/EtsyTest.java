package org.example.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class EtsyTest extends BaseClass{
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String pass = faker.internet().password();
    @Test
    public void testEtsy () {
        driver.navigate().to("https://www.etsy.com/");
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='wt-grid__item-xs-12']")));
        driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys(email);
        driver.findElement((By.xpath("//input[@id='join_neu_password_field']"))).sendKeys(pass);
    }
}
