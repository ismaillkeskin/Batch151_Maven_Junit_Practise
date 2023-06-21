package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class c02_ActionsDragAndDrop extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");


        Thread.sleep(2000);

        // 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz

        Actions actions = new Actions(driver);


        WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,hedefElement).perform();
        // dragAndDrop() ==> sürükle bırak



        Thread.sleep(2000);

        // 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz

        WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actuelYazi = dropped.getText();

        String expectedYazi = "Dropped!";


        Assert.assertEquals(expectedYazi,actuelYazi);


    }
    }

