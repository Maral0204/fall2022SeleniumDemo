package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Practics extends BaseClass {
    @Test
    public void test11() {
        driver.navigate().to("https://www.imoving.com/");
        // driver.get("https://www.imoving.com/")   2 вариант зайти на нужную страницу
        WebElement houseTypeSelectionMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectionMenu);
        select.selectByIndex(2);  // вариант по индексу
//        select.selectByValue("1079"); вариант по значению
//        select.deselectByVisibleText("My Apartment");
        Helper.pause(3000);

        WebElement typeMovieSize = driver.findElement(By.id("hp-nav-select-house"));
        Select select1 = new Select(typeMovieSize);
        select1.selectByValue("9509");
        Helper.pause(3000);

        driver.findElement(By.xpath(".//button[@class='btn btn-white quickQuoteLink']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
        Helper.pause(10000);

        driver.findElement(By.xpath("(//button[@class='icn-remove icn-close'])[1]")).click();
        driver.findElement(By.id("closeTutorial")).click();
        driver.findElement(By.xpath("(//button[@id='closeSaveModal'])[1]")).click();

        //Add Lamp
        Actions action = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//figure[@xpath='1']"));
//        action.moveToElement(pictureDresser).perform();
//        driver.findElement(By.xpath("//a[contains(text(),'Add to Inventory')]")).click();
//
//        WebElement plusDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
//        action.doubleClick(plusDresser).perform();

    }
}
