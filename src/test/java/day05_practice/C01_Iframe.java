package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

     // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

      // Videoyu izlemek icin Play tusuna basiniz
      WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);
        /*
         play'i dogru locate edip click yapmamiza ragmen videoyu calistirmadi.
        Bunun uzerine HTML kodlarini inceleyince Play'in aslinda bir iframe icerisinde oldugunu gorduk.
        Bu durumda once iframe'i locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */

       WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
       playButton.click();

       bekle(3);


       // videoyu durdurun
       WebElement pause = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
       pause.click();

       bekle(2);

       // videoyu tam ekran yapınız
        WebElement fullScreen = driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']"));
        fullScreen.click();
        bekle(2);

      // videoyu calıstırınız
        pause.click();
        bekle(2);

       // videoyu kucultunuz
       fullScreen.click();
       bekle(2);

       // videoyu durdurunuz
        pause.click();
        bekle(2);

       // Videoyu calistirdiginizi test ediniz
       WebElement youtubeYazi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazi.isDisplayed());

       // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();

        WebElement baslik =driver.findElement(By.xpath("//h1[text()='jQuery Flexy Plugin Demos']"));
        Assert.assertTrue(baslik.isDisplayed());

    }
}
