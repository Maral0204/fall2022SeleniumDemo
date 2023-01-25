package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSexecutor extends BaseClass{
    @Test
    public void test1 () {
        browserHelper.openURL("https://www.etsy.com/");
        WebElement careersLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        Helper.jsClick(driver,careersLink);
        Helper.pause(5000);
        Helper.jsScrollDownThePage(driver);
        Helper.pause(5000);
    }
}
