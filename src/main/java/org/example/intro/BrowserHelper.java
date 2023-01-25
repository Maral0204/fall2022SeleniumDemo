package org.example.intro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;

    }

    public void openURL(String URL) {
        driver.navigate().to(URL);

    }

    public void goBack() {
        driver.navigate().back();

    }

    public void goForward() {
        driver.navigate().forward();

    }

    public void refreshThePage() {
        driver.navigate().refresh();

    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index) {
        LinkedList<String> windowsID = new LinkedList<>(getWindowHandles());
        if (index < 0 || index > windowsID.size()) {
            throw new IllegalArgumentException("invalid index: " + index);
        }
        driver.switchTo().window(windowsID.get(index));
    }

    public void switchToParents() {
        LinkedList<String> windowsID = new LinkedList<>(getWindowHandles());
        driver.switchTo().window(windowsID.get(0));
    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
//Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile = new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}

