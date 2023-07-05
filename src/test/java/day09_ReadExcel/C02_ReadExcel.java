package day09_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIdx = workbook.getSheet("Sayfa1").getLastRowNum();

        System.out.println(sonSatirIdx);
        //getLastRowNum() --> Son Satır numarasını index olarak verir

         /*
        2.YOL

        for (int i = 0; i <=sonSatirIdx ; i++) {

            String satirdakiData = C01_ReadExcel.banaDataGetir(i,1);

            System.out.println(satirdakiData);
      Not:
      - static bir methoda farklı bir class'dan ulaşabilmek için class ismi kullanılır
      -instance bir methoda farklı bir class'dan ulaşabilmek için obje oluşturulur

     }
          */



        /*
          banaDataGetir() methodunu ister statik yapip direkt cagirabiliriz
         ister instance yapip farkli class'dan obje olusturarak kullanabiliriz
         veya class isminden sonra nokta koyup methodu cagirabiliriz
         */


        for (int i = 0; i <= sonSatirIdx; i++) {

            String satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            System.out.println(satirdakiData);


        }


    }
}




