package org.example.intro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenScreenshots extends BaseClass {


    @Test
    public void screenScreenshotsTest() throws Exception {
        browserHelper.openURL("https://www.amazon.com/");
        this.takeSnapShot(driver, "C:\\Users\\User\\IdeaProjects\\UI_framework_Practice\\src\\main\\resources\\amazonHomePage.png");

    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
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
