package com.tjudream.stock.service.impl;

import com.alibaba.fastjson.JSON;
import com.tjudream.stock.dto.Stock;
import com.tjudream.stock.repositories.StockRepository;
import com.tjudream.stock.service.StockService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengxiansen on 2018/9/19.
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> list() throws Exception {
        return stockRepository.findAll();
    }
    @Override
    public Stock addsh() throws Exception {

        /*
        Stock stock = new Stock();
        stock.setCode("6000000");
        stock.setName("平安银行");
        Timestamp timestamp = Timestamp.valueOf("1997-01-10 00:00:00");
        stock.setIpoTime(timestamp);

        //readXls("");
        Stock newStock = stockRepository.save(stock);
        return newStock;
        */
        insertSh();
        return new Stock();
    }

    @Override
    public Stock addsz() throws Exception {
        insertSz();
        return new Stock();
    }
    public void insertSz() throws Exception {
        String path = "/Users/mengxiansen/job/study/stock/shenshi.xlsx";
        FileInputStream  fileIn = new FileInputStream(path);
        //POIFSFileSystem fs = new POIFSFileSystem(fileIn);
        XSSFWorkbook wb = new XSSFWorkbook(fileIn);
        int sheetNum = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            System.out.println(Integer.MAX_VALUE);
            Sheet sheet = wb.getSheetAt(i);
            int sheetStart = sheet.getFirstRowNum();
            int sheetEnt = sheet.getLastRowNum();
            for (int j = sheetStart; j <= sheetEnt; j++) {
                Row row = sheet.getRow(j);
                int cellStart = row.getFirstCellNum();
                int cellEnd = row.getLastCellNum();
                Stock stock = new Stock();
                for (int k = cellStart; k < cellEnd; k++) {

                    Cell cell = row.getCell(k);
                    //System.out.print( k + " : " );

                    switch (k) {
                    case 5:
                        //System.out.print((int)(cell.getNumericCellValue()) + "");
                        //stock.setCode((int)(cell.getNumericCellValue()) + "");
                        String code = cell.getStringCellValue().trim();
                        System.out.println(code);
                        stock.setCode(code);
                        break;
                    case 6:
                        System.out.print(cell.getStringCellValue().trim());
                        stock.setName(cell.getStringCellValue().trim());
                        break;
                    case 7:
                        String timeStr = cell.getStringCellValue().trim() + " 00:00:00";
                        System.out.print(timeStr);
                        Timestamp timestamp = Timestamp.valueOf(timeStr);
                        stock.setIpoTime(timestamp);
                        break;
                    case 8:
                        //System.out.println(cell.getNumericCellValue());
                        //System.out.print((long) (cell.getNumericCellValue() * 10000));
                        //stock.setCapitalization((long) (cell.getNumericCellValue() * 10000));
                        String capStr = cell.getStringCellValue();
                        capStr = capStr.replace(",", "");
                        System.out.println(capStr);
                        stock.setCapitalization(Long.parseLong(capStr));
                        break;
                    case 9:
                        //System.out.println(cell.getNumericCellValue());
                        //System.out.print((long) (cell.getNumericCellValue() * 10000));
                        //stock.setCurrent_capital_stock((long) (cell.getNumericCellValue() * 10000));
                        String curCapStr = cell.getStringCellValue();
                        curCapStr = curCapStr.replace(",", "");
                        System.out.println(curCapStr);
                        stock.setCurrent_capital_stock(Long.parseLong(curCapStr));
                        break;
                    }
                    stock.setType(1);
                    //System.out.println();

/*
                    System.out.print(k + ": ");
                    if (CellType.NUMERIC.equals(cell.getCellTypeEnum())) {
                        System.out.print(cell.getNumericCellValue() + "    ");
                    } else {
                        System.out.print(cell.getStringCellValue() + "    ");
                    }
*/
                }

                System.out.println(JSON.toJSONString(stock));
                Timestamp ts = stock.getIpoTime();
                String tsStr = "";
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
//方法一
                    tsStr = sdf.format(ts);
                    System.out.println(tsStr);
//方法二
                    tsStr = ts.toString();
                    System.out.println(tsStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                stockRepository.save(stock);

                //              System.out.println("");
            }
        }
    }

    public void insertSh() throws Exception {

        FileInputStream  fileIn = new FileInputStream("/Users/mengxiansen/job/study/stock/hushi.txt.csv.xlsx");
        //POIFSFileSystem fs = new POIFSFileSystem(fileIn);
        XSSFWorkbook wb = new XSSFWorkbook(fileIn);
        int sheetNum = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            System.out.println(Integer.MAX_VALUE);
            Sheet sheet = wb.getSheetAt(i);
            int sheetStart = sheet.getFirstRowNum();
            int sheetEnt = sheet.getLastRowNum();
            for (int j = sheetStart; j <= sheetEnt; j++) {
                Row row = sheet.getRow(j);
                int cellStart = row.getFirstCellNum();
                int cellEnd = row.getLastCellNum();
                Stock stock = new Stock();
                for (int k = cellStart; k < cellEnd; k++) {

                    Cell cell = row.getCell(k);
                    System.out.print( k + " : " );
                    switch (k) {
                    case 2:
                        System.out.print((int)(cell.getNumericCellValue()) + "");
                        stock.setCode((int)(cell.getNumericCellValue()) + "");
                        break;
                    case 3:
                        System.out.print(cell.getStringCellValue().trim());
                        stock.setName(cell.getStringCellValue().trim());
                        break;
                    case 4:
                        String timeStr = cell.getStringCellValue().trim() + " 00:00:00";
                        System.out.print(timeStr);
                        Timestamp timestamp = Timestamp.valueOf(timeStr);
                        stock.setIpoTime(timestamp);
                        break;
                    case 5:
                        System.out.println(cell.getNumericCellValue());
                        System.out.print((long) (cell.getNumericCellValue() * 10000));
                        stock.setCapitalization((long) (cell.getNumericCellValue() * 10000));
                        break;
                    case 6:
                        System.out.println(cell.getNumericCellValue());
                        System.out.print((long) (cell.getNumericCellValue() * 10000));
                        stock.setCurrent_capital_stock((long) (cell.getNumericCellValue() * 10000));
                        break;
                    }
                    System.out.println();
/*
                    System.out.print(k + ": ");
                    if (CellType.NUMERIC.equals(cell.getCellTypeEnum())) {
                        System.out.print(cell.getNumericCellValue() + "    ");
                    } else {
                        System.out.print(cell.getStringCellValue() + "    ");
                    }
*/
                }
                System.out.println(JSON.toJSONString(stock));
                Timestamp ts = stock.getIpoTime();
                String tsStr = "";
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
//方法一
                    tsStr = sdf.format(ts);
                    System.out.println(tsStr);
//方法二
                    tsStr = ts.toString();
                    System.out.println(tsStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                stockRepository.save(stock);
                //              System.out.println("");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //readExcel();
        readshenshi();
    }
    public static void readshenshi() throws Exception {
        String path = "/Users/mengxiansen/job/study/stock/shenshi.xlsx";
        FileInputStream  fileIn = new FileInputStream(path);
        //POIFSFileSystem fs = new POIFSFileSystem(fileIn);
        XSSFWorkbook wb = new XSSFWorkbook(fileIn);
        int sheetNum = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNum; i++) {
            System.out.println(Integer.MAX_VALUE);
            Sheet sheet = wb.getSheetAt(i);
            int sheetStart = sheet.getFirstRowNum();
            int sheetEnt = sheet.getLastRowNum();
            for (int j = sheetStart; j <= sheetEnt; j++) {
                Row row = sheet.getRow(j);
                int cellStart = row.getFirstCellNum();
                int cellEnd = row.getLastCellNum();
                Stock stock = new Stock();
                for (int k = cellStart; k < cellEnd; k++) {

                    Cell cell = row.getCell(k);
                    //System.out.print( k + " : " );

                    switch (k) {
                    case 5:
                        //System.out.print((int)(cell.getNumericCellValue()) + "");
                        //stock.setCode((int)(cell.getNumericCellValue()) + "");
                        String code = cell.getStringCellValue().trim();
                        System.out.println(code);
                        stock.setCode(code);
                        break;
                    case 6:
                        System.out.print(cell.getStringCellValue().trim());
                        stock.setName(cell.getStringCellValue().trim());
                        break;
                    case 7:
                        String timeStr = cell.getStringCellValue().trim() + " 00:00:00";
                        System.out.print(timeStr);
                        Timestamp timestamp = Timestamp.valueOf(timeStr);
                        stock.setIpoTime(timestamp);
                        break;
                    case 8:
                        //System.out.println(cell.getNumericCellValue());
                        //System.out.print((long) (cell.getNumericCellValue() * 10000));
                        //stock.setCapitalization((long) (cell.getNumericCellValue() * 10000));
                        String capStr = cell.getStringCellValue();
                        capStr = capStr.replace(",", "");
                        System.out.println(capStr);
                        stock.setCapitalization(Long.parseLong(capStr));
                        break;
                    case 9:
                        //System.out.println(cell.getNumericCellValue());
                        //System.out.print((long) (cell.getNumericCellValue() * 10000));
                        //stock.setCurrent_capital_stock((long) (cell.getNumericCellValue() * 10000));
                        String curCapStr = cell.getStringCellValue();
                        curCapStr = curCapStr.replace(",", "");
                        System.out.println(curCapStr);
                        stock.setCurrent_capital_stock(Long.parseLong(curCapStr));
                        break;
                    }
                    stock.setType(1);
                    //System.out.println();

/*
                    System.out.print(k + ": ");
                    if (CellType.NUMERIC.equals(cell.getCellTypeEnum())) {
                        System.out.print(cell.getNumericCellValue() + "    ");
                    } else {
                        System.out.print(cell.getStringCellValue() + "    ");
                    }
*/
                }

                System.out.println(JSON.toJSONString(stock));
                Timestamp ts = stock.getIpoTime();
                String tsStr = "";
                DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
//方法一
                    tsStr = sdf.format(ts);
                    System.out.println(tsStr);
//方法二
                    tsStr = ts.toString();
                    System.out.println(tsStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }



                //              System.out.println("");
            }
        }
    }
    public static void readExcel() {
        String path = "/Users/mengxiansen/job/study/stock/hushi.xls";
        try {
            List<List<String>> result = readXls(path);
            System.out.println(result.size());
            for (int i = 0; i < result.size(); i++) {
                List<String> model = result.get(i);
                System.out.println("orderNum:" + model.get(0) + "--> orderAmount:" + model.get(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<List<String>> readXls(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        // HSSFWorkbook 标识整个excel
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<List<String>> result = new ArrayList<List<String>>();
        int size = hssfWorkbook.getNumberOfSheets();
        // 循环每一页，并处理当前循环页
        for (int numSheet = 0; numSheet < size; numSheet++) {
            // HSSFSheet 标识某一页
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 处理当前页，循环读取每一行
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                // HSSFRow表示行
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                int minColIx = hssfRow.getFirstCellNum();
                int maxColIx = hssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<String>();
                // 遍历改行，获取处理每个cell元素
                for (int colIx = minColIx; colIx < maxColIx; colIx++) {
                    // HSSFCell 表示单元格
                    HSSFCell cell = hssfRow.getCell(colIx);
                    if (cell == null) {
                        continue;
                    }
                    rowList.add(getStringVal(cell));
                }
                result.add(rowList);
            }
        }
        return result;
    }

    public static String getStringVal(HSSFCell cell) {
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_BOOLEAN:
            return cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        case Cell.CELL_TYPE_FORMULA:
            return cell.getCellFormula();
        case Cell.CELL_TYPE_NUMERIC:
            cell.setCellType(Cell.CELL_TYPE_STRING);
            return cell.getStringCellValue();
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
        default:
            return "";
        }
    }
}
