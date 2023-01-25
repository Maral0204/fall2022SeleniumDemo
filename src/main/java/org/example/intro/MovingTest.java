package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovingTest extends BaseClass{

    @Test
    public void movingTest () {
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

        //Add Dresser
        Actions action = new Actions(driver);
        WebElement pictureDresser = driver.findElement(By.xpath("//div[@class='14']//figure"));
        action.moveToElement(pictureDresser).perform();
        driver.findElement(By.xpath("//a[contains(text(),'Add to Inventory')]")).click();

        WebElement plusDresser = driver.findElement(By.xpath("//span[@class='quantityCounterBlock']//button[@class='quantity-plus']"));
        action.doubleClick(plusDresser).perform();

        //Add Bed

        WebElement pictureBed = driver.findElement(By.xpath("//div[@class='13']//figure"));
        action.moveToElement(pictureBed).build().perform();
        driver.findElement(By.xpath("//div[@class='13']//a[@class='btn btn-blue'][normalize-space()='Add to Inventory']")).click();
        Helper.pause(3000);
        WebElement plusBoxBed = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[3]"));
        action.doubleClick(plusBoxBed).perform();

        //Add TV

        WebElement tvImageContainer = driver.findElement(By.xpath("//div[@class='12']//figure"));
        action.moveToElement(tvImageContainer).build().perform();
        driver.findElement(By.cssSelector("div[class='12'] div[class='add-item-mob visible-xs-block visible-sm-block'] a[class='btn btn-blue']")).click();
        Helper.pause(3000);
        WebElement plusBoxTv = driver.findElement(By.xpath("(//button[@class='quantity-plus'])[5]"));
        action.doubleClick(plusBoxTv).perform();

        WebElement boxItem = driver.findElement(By.xpath("(//div[@class='arrowOpenRightNavigation leftArrowNavi'])[2]"));
        boxItem.click();
        driver.findElement(By.xpath("(//span[@class='roomPanelIcon quantity-plus1'])[1]")).click();

        WebElement expectedItems = driver.findElement(By.xpath("//span[@class='room-counter']"));
        Assert.assertEquals(expectedItems.getText(),"9 items");

        WebElement dresser = driver.findElement(By.xpath("//h3[text()='Dresser']"));
        Assert.assertEquals(dresser.getText(),"Dresser");

        driver.findElement(By.xpath("(//a[@class='action-box'])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add and Continue')]")).click();
        driver.findElement(By.xpath("(//input[@name='addressInput'])[1]")).sendKeys("56328 North Carolina Highway 12, Hatteras, NC, 27953");
        driver.findElement(By.xpath("(//input[@name='addressInput'])[2]")).sendKeys("5869 Broadway, The Bronx, NY 10463, USA");
        Helper.pause(2000);
        driver.findElement(By.xpath("//input[@id='promo']")).sendKeys("502");




    }
}
