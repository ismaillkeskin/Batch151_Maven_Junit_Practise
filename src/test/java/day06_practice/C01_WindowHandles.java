package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() throws InterruptedException {
       // 'https://www.n11.com' adresine gidin
       driver.get("https://www.n11.com");

       // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);

        String  sayfa1Handle = driver.getWindowHandle();

        Thread.sleep(2000);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        Thread.sleep(2000);

        Set<String> windowHandleSeti = driver.getWindowHandles();

        String sayfa2Handle="";

        for (String each:windowHandleSeti) {

            if(!each.equals((sayfa1Handle))){
                sayfa2Handle = each;
            }
        }
        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle); // driver'ı yeni acılan sekmeye gecirdik

        Thread.sleep(2000);





        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.

        String ikinciSayfaTitle = driver.getTitle();

        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        Thread.sleep(2000);

        // ilk sayfaya donun ve Title'ını yazdırın

        driver.switchTo().window(sayfa1Handle);
        // driver'ı ilk sayfaya gecirdik


        String ilkSayfaTitle = driver.getTitle();
        System.out.println("İLKSAYFATİTLE: " + ilkSayfaTitle);
    }
}
