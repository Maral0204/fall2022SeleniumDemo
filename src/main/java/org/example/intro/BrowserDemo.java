package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo extends BaseClass {

    @Test
    public void test(){
        browserHelper.openURL("https://demoqa.com/browser-windows");
        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();
        Helper.pause(3000);
        browserHelper.switchToWindow(0);
        Helper.pause(3000);
        browserHelper.switchToParents();
        Helper.pause(3000);
    }
    }

