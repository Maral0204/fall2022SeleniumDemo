package org.example.intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadDownloadDemo extends BaseClass {
    @Test
    public void test1 () {
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:/Users/User/OneDrive/Изображения/Снимки экрана/Screenshot (162).png");
        Helper.pause(5000);
    }
}
