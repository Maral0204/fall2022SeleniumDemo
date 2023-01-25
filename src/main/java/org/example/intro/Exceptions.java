package org.example.intro;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Exceptions extends BaseClass {

    @Test
    public void NoSuchElementExceptionTest() {

        // нет такого элемента (чаще всего неверно указан локатор)
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello world");
    }

    @Test
    public void noSuchWindowExceptionTest() {
        // нет такого окна
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.switchTo().window("id");
    }

    @Test
    public void noSuchFrameExceptionTest() {
        // нет такого фрейма
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.switchTo().frame(5);
    }

    @Test
    public void noSuchAlertPresentExceptionTest() {
        // нет такой кнопки
        browserHelper.openURL("http://demoqa.com/text-box");
        alertHelper.acceptAlert();
    }

    @Test
    public void invalidSelectorExceptionTest() {
        // некорректный селектор
        browserHelper.openURL("http://demoqa.com/text-box");
        driver.findElement(By.xpath("//(*[@id='userName'])[12]"));

    }

    @Test
    public void noSuchSessionExceptionTest() {
        // сначала закрыли сессию через quit потом просим открыть
        driver.quit();
        browserHelper.openURL("http://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceExceptionTest() {
        // устаревшая ссылка на элемент
        browserHelper.openURL("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
            }
        }
    }
    @Test
    public void timeOutExceptionTest() {
        // истекло время ожидания
        browserHelper.openURL("http://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();

    }

    @Test
    public void elementNotInteractableTest() {
//     если кнопка неактивная вследствие неправильного взаимодействия
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).sendKeys("saas");
    }

    @Test
    public void elementNotInteractableExceptionTest1() {
        driver.get("https://www.etsy.com/");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
        loginButton.click();
        Helper.pause(2000);
        WebElement careersLink = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        careersLink.click(); //org.openqa.selenium.ElementNotInteractableException: element not interactable
    }

    @Test
    public void elementClickInterceptedExceptionTest(){
//    ошибка когда один элемент перекрывает второй или кнопки не видно, также если кнопка/элемент неактивные
        browserHelper.openURL("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
//        Helper.pause(3000);
//        driver.findElement(By.xpath("//a[text()='GOT IT']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }
}
