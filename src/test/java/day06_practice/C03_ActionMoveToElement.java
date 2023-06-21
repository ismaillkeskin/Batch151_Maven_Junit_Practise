package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        Thread.sleep(2000);

        String sayfa1Handle = driver.getWindowHandle();


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions =new Actions(driver);

        WebElement dilMenu = driver.findElement(By.xpath("//div[text()='EN']"));

        actions.moveToElement(dilMenu).perform();
        Thread.sleep(2000);

       // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();
        Thread.sleep(2000);

       // United States dropdown'undan 'Turkey (Türkiye)' seciniz


        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));

        Select select = new Select(ddm);

        select.selectByVisibleText("Turkey (Türkiye)");

        Thread.sleep(2000);

        // Go to website butonuna tiklayiniz

        // drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
        // herhangi bir yere click yapıp dropdown option listesinin toparlanmasını sagladık
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();

        Thread.sleep(2000);

        WebElement gotoWebsite = driver.findElement(By.xpath("//input[@class='a-button-input']"));
        gotoWebsite.click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        Set<String> windowHandleSeti = driver.getWindowHandles();

        String sayfa2Handle = "";

        for (String each:windowHandleSeti) {

            if (!each.equals(sayfa1Handle)) {

                sayfa2Handle = each;
            }
        }

        driver.switchTo().window(sayfa2Handle);
        // driver'ı yeni acılan sekmeye gecirdik

        Thread.sleep(2000);

        String ikinciSayfaTitle = driver.getTitle();

        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));


    }
}
