package day09_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki 3.satır indexin, 3.sutunundaki indexinin "Cezayir" oldugunu test eden method olusturunuz
        int satirNoIdx = 3;
        int sutunNoIdx = 3;

      String actuelData = banaDataGetir(satirNoIdx,sutunNoIdx);
      String expectedData = "Cezayir";

        Assert.assertEquals(expectedData,actuelData);


    }

    public String banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {
      String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
      // ulkeler dosyasını bizim sistemimize getirir
        Workbook workbook = WorkbookFactory.create(fis);
      // dosyayı workbook'a atadık

      workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(satirNoIdx);

      String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();

        return istenenData;
    }
}
