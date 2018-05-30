package com.test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class testmain {
    public static void main(String[] argv) throws Exception {
        Date dateCellValue;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            File excelFile = new File("D:\\IntellijIdea_space\\practiceproject\\src\\com\\sc\\persistence\\Staff_List.xlsx");
            FileInputStream fis = new FileInputStream(excelFile);
            XSSFWorkbook xWorkBook = new XSSFWorkbook(fis);
            XSSFSheet xSheet = xWorkBook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
//            FormulaEvaluator evaluator = xWorkBook.getCreationHelper().createFormulaEvaluator();
            String cellValue = null;
            Iterator<Row> rowIterator = xSheet.rowIterator();
            int counter = 0;
            while(rowIterator.hasNext()){
                if (counter == 0) {
                    System.out.print("ignore headers \r\n");
                    rowIterator.next();
                    counter++;
                    continue;
                } else if (counter >3) break;
                counter++;
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    if (cell.getCellTypeEnum() == CellType.NUMERIC){
                        if (DateUtil.isCellDateFormatted(cell)) {
                            cellValue = "Date Type: \r\n  " + simpleDateFormat.format(cell.getDateCellValue());
                        } else {
                            cellValue = "Numeric Type: \r\n  " + (int)cell.getNumericCellValue();
                        }
                    } else {
                        cellValue = "String Type: \r\n  " + dataFormatter.formatCellValue(cell);
                    }
//                    cellValue = dataFormatter.formatCellValue(cell, evaluator);
                    System.out.println(cellValue);
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NotImplementedException exception){
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("completed finally!");
        }
    }
}
