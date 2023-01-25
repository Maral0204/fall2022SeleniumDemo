package org.example.autotest_video_tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class MyFirstTest {
    WebDriver driver = new EdgeDriver();

    @Test
    public void firstTest () {




      //  Thread.sleep(3000);  ожидание после последнего действия

        // open page
        driver.get("https://glovoapp.com/kg/ru/bishkek/");

        // set both field empty

        // press submit button
        driver.findElement(By.id("//*[@id=\"user-register\"]")).click();
        driver.findElement(By.className("helio-button__content"));

        // check validation message


//        driver.quit();  // close the browser
//        driver.close(); // close the current tab
    }
}
