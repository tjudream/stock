package com.tjudream.stock.util;

import com.tjudream.stock.dto.Stock;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.sql.Timestamp;

/**
 * 读取Excel
 *
 * @author zengwendong
 */
public class ReadExcelUtils {
    public static void main(String[] args) throws Exception {

        FileInputStream  fileIn = new FileInputStream("/Users/mengxiansen/job/study/stock/hushi.txt.csv.xlsx");
        //POIFSFileSystem fs = new POIFSFileSystem(fileIn);
        XSSFWorkbook wb = new XSSFWorkbook(fileIn);
        int sheetNum = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            Sheet sheet = wb.getSheetAt(i);
            int sheetStart = sheet.getFirstRowNum();
            int sheetEnt = sheet.getLastRowNum();
            for (int j = sheetStart; j < sheetEnt; j++) {
                Row row = sheet.getRow(j);
                int cellStart = row.getFirstCellNum();
                int cellEnd = row.getLastCellNum();
                Stock stock = new Stock();
                for (int k = cellStart; k < cellEnd; k++) {
                    Cell cell = row.getCell(k);

                    switch (k) {
                    case 2:
                        stock.setCode((int)(cell.getNumericCellValue()) + "");
                        break;
                    case 3:
                        stock.setName(cell.getStringCellValue());
                        break;
                    case 4:
                        Timestamp timestamp = Timestamp.valueOf(cell.getStringCellValue() + " 00:00:00");
                        stock.setIpoTime(timestamp);
                        break;
                    case 5:
                        stock.setCapitalization((int)cell.getNumericCellValue() * 10000);
                        break;
                    case 6:
                        stock.setCurrent_capital_stock((int) cell.getNumericCellValue() * 10000);
                    }
/*
                    System.out.print(k + ": ");
                    if (CellType.NUMERIC.equals(cell.getCellTypeEnum())) {
                        System.out.print(cell.getNumericCellValue() + "    ");
                    } else {
                        System.out.print(cell.getStringCellValue() + "    ");
                    }
*/
                }
  //              System.out.println("");
            }
        }
    }
}