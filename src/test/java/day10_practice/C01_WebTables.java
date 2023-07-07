package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    @Test
    public void test01() {

        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();


       // sutun sayısını yazdırın
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("SUTUN SAYISI : " + sutunBasliklariListesi.size());

       // tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

       // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir  Sayisi = " + satirlarListesi.size());

        System.out.println();

       // body'de bulunan satırları yazdırın
        for (WebElement each :satirlarListesi){
            System.out.println(each.getText());
        }
        System.out.println();

       // 4.satırdaki elementleri yazdırın
     List<WebElement> dorduncuSatirElementleri = driver.findElements(By.xpath("//tbody//tr[4]//td"));
     for (WebElement each :dorduncuSatirElementleri){
         System.out.println(each.getText());
     }

    }

    public void girisYap(){
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();//gelişmiş butonuna tıkladık
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();//aşağıdaki güvenli değil ama siteye git linkine tıklattık
        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // LOG IN

        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        actions.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }
}
