package org.example.intro;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

    public class ListTestHW2 extends BaseClass{

        Faker faker = new Faker();
        String firstName = FakeDataProvider.generateFakeName();
        String lastName = FakeDataProvider.generateLastFakeName();
        String email = FakeDataProvider.generateFakeEmailAddress();
        int age = randomNumber();
        int salary = randomNumber2();
        String department = FakeDataProvider.generateFakeJob();
        String firstName2 = FakeDataProvider.generateFakeName();
        String lastName2 = FakeDataProvider.generateLastFakeName();
        String email2 = FakeDataProvider.generateFakeEmailAddress();
        int age2 = randomNumber();
        int salary2 = randomNumber2();
        String department2 = FakeDataProvider.generateFakeJob();
        public static int randomNumber() {
            int a = 0;
            int b = 100;
            return a + (int) (Math.random() * b);
        }
        public static int randomNumber2() {
            int a = 0;
            int b = 100000;
            return a + (int) (Math.random() * b);
        }

        @Test
        public void toAdd(){
            driver.get("https://demoqa.com/webtables");

            driver.findElement(By.id("addNewRecordButton")).click();
            driver.findElement(By.id("firstName")).sendKeys(firstName);
            driver.findElement(By.id("lastName")).sendKeys(lastName);
            driver.findElement(By.id("userEmail")).sendKeys(email);
            driver.findElement(By.id("age")).sendKeys(Integer.toString(age));
            driver.findElement(By.id("salary")).sendKeys(Integer.toString(salary));
            driver.findElement(By.id("department")).sendKeys(department);
            driver.findElement(By.id("submit")).click();

            driver.findElement(By.id("addNewRecordButton")).click();
            driver.findElement(By.id("firstName")).sendKeys(firstName2);
            driver.findElement(By.id("lastName")).sendKeys(lastName2);
            driver.findElement(By.id("userEmail")).sendKeys(email2);
            driver.findElement(By.id("age")).sendKeys(Integer.toString(age2));
            driver.findElement(By.id("salary")).sendKeys(Integer.toString(salary2));
            driver.findElement(By.id("department")).sendKeys(department2);
            driver.findElement(By.id("submit")).click();

        }

        @Test(dependsOnMethods = {"toAdd"})
        public void testWebTable(){

            WebElement table = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
            List<WebElement> allRows = table.findElements(By.className("rt-tr-group"));

            for (WebElement row:allRows) {
                List<WebElement> allColumns = row.findElements(By.className("rt-td"));
                for (WebElement column:allColumns) {
                    if(column.getText().equals(firstName)){
                        System.out.println(column.getText());
                        Assert.assertEquals(column.getText(),firstName);
                    }
                    if(column.getText().equals(lastName2)){
                        Assert.assertEquals(column.getText(),lastName2);
                    }
                    if(column.getText().equals(email)){
                        Assert.assertEquals(column.getText(),email);
                    }
                    if(column.getText().equals(String.valueOf(age))){
                        Assert.assertEquals(column.getText(),String.valueOf(age));
                    }
                }
            }

        }
    }
