package day09_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

     // Ulkeler dosyasindaki tum datalari Map'e aliniz ve yazdiriniz
        Map<String,String> ulkelerMap = new TreeMap<>();

        String dosyaYolu = "src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);


        int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();
        // getLastRowNum() son satır numarasını index olarak verir.



        for (int i = 0; i <=sonSatirIndex ; i++) {

            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value =  workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

            // System.out.println(key + " /" + value);

        }

        System.out.println(ulkelerMap);



    }
}
