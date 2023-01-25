package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
/* виды локаторов https://drive.google.com/file/d/1c15kEQO-NnT8qhWyb5hd9Az74_LnVrpQ/view
чаще всего исп-ся id, xpath, css selector

<div ...> - контейнера, на которые поделена страница сайта (левая колонка, правая колонка и тд). Внутри div могут быть еще div
 div class --> div ID ...*/

public class XPathDemo {
    WebDriver driver;

    @BeforeClass
    public void GetUp () {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }
    @Test
    public void xPathTest () {

        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label\n"));
        String expectedEmailText = "Email";

        Assert.assertEquals(nameText.getText(),expectedEmailText);

        // absolute xpath - когда начинаем поиск с нуля /html/body ... - неудобно при добавлении разработчиками каких-то новых элементов
        /* relative xpath - выделяем сам элемент, пишем в поисковик //+ [@ + название атрибута к чему можем привязать = 'название атрибута' - название элемента закрывающего]
          https://drive.google.com/file/d/10W0UNgwV9OcBXxQHzn-jmXX3ioln2odx/view
          например //input [@id='userName'] или //button ([@type='button'])[2], где [2] это второй из нескольких вариантов
          например //*[text()='Full Name'] поиск по названию текста  https://drive.google.com/file/d/1YO1bnAtJRQtiTd4moARWaF0mA-P4xusG/view */

        WebElement nameText2= driver.findElement(By.xpath("//label[@id='userEmail-label']"));
        Assert.assertTrue(expectedEmailText.contains(nameText2.getText()));
    }

    @Test
    public void xPathTest2 () {

        WebElement userName = driver.findElement(By.xpath("//input [@id='userName']"));
        userName.sendKeys("Test123");
        Assert.assertEquals(userName.getAttribute("value"),userName.getText());
    }


    @AfterClass
    public void Close () throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
}
