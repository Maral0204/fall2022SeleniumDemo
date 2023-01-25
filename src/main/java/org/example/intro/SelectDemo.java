package org.example.intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectDemo extends BaseClass{
    @Test
    public void testSelect() {
        driver.navigate().to("https://demoqa.com/select-menu");
        driver.findElement(By.id("react-select-2-input")).sendKeys();
    }
}
