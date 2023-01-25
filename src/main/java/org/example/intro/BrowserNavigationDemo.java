package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationDemo extends BaseClass {
    @Test
    public void test1() {
        driver.navigate().to("https://www.imoving.com/");
        WebElement houseTypeSelectionMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectionMenu);
        select.selectByIndex(2);  // вариант по индексу

        WebElement typeMovieSize = driver.findElement(By.id("hp-nav-select-house"));
        Select select1 = new Select(typeMovieSize);
        select1.selectByValue("9509");
        driver.findElement(By.xpath(".//button[@class='btn btn-white quickQuoteLink']")).click();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/");
        driver.navigate().back();      // вернуться на предыдущую страницу
        Helper.pause(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/");
        driver.navigate().refresh();   //обновить страницу
        driver.navigate().forward();   //вперед на след страницу
        Helper.pause(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/");

    }
}
