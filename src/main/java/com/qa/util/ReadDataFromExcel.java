package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataFromExcel {

    private String dateFromExcel=null;

    public String getDailyCoronaUpdateByDate(String dateValue){


        try
        {
            FileInputStream file = new FileInputStream(new File("src/main/java/com/qa/testdata/APITestData.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook  workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.rowIterator();

            int rowSize = sheet.getLastRowNum();
            for(int i=1;i<=rowSize;i++)
            {
                Row row = rowIterator.next().getSheet().getRow(i);
                //For each row, iterate through all the columns
               Iterator<Cell> cellIterator = row.cellIterator();

                dateFromExcel = row.getCell(0).toString();

                System.out.println("dateFromExcel : "+dateFromExcel);

                System.out.println("dateValue : "+dateValue);

                if(dateFromExcel.equalsIgnoreCase(dateValue)){

                    return String.format("%.0f", row.getCell(4).getNumericCellValue());

                }

                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
