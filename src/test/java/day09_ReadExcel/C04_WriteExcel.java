package day09_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki 0. satır index'in, 4.hücre index'ine yeni bir cell olusturalım.
        // olusturdugumuz hücreye "Nufus" yazdıralım.

       String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");


        /*
        1.satır index'in, 4.hücre index'ine yeni bir cell olusturun
        olusturdugunuz hücreye "15000" yazdırın
         */

        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("15000");







        /*
        2.satır index'in, 4.hücre index'ine yeni bir cell olusturun
        olusturdugunuz hücreye "25000" yazdırın
         */

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(25000);





        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // dataları bizim class'ımızdan ulkeler dosyasına gonderecegiz.


        workbook.write(fos);
        // workbook'daki dataları fos'a yazdık

    }
}
