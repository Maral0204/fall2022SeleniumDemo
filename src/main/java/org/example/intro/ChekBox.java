package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class ChekBox extends BaseClass {

    @Test
    public void checkBox() {
        driver.get("https://demoqa.com/checkbox");

        WebElement commands = driver.findElement(By.xpath("(//button[@title='Toggle'])[1]"));
        commands.click();

        driver.findElement(By.xpath(("(.//button[@title='Toggle'])[2]"))).click();
        WebElement CommandsCheckBox = driver.findElement(By.xpath("(.//span[@class='rct-checkbox'])[4]"));
        CommandsCheckBox.click();

        Assert.assertTrue(CommandsCheckBox.isEnabled());
    }

    @Test
    public void testRightClickMe () {
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickMe).perform();
//        Assert.assertTrue();

        }
        @Test
    public void testClickBtn() {
        driver.get("https://demoqa.com/buttons");
        WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        Actions action = new Actions(driver);
        action.contextClick(clickMeBtn).perform();
        WebElement clickMessage = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(clickMessage.getText(),"You have done a dynamic click");
        }


    }

