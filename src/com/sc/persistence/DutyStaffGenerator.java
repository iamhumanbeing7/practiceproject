package com.sc.persistence;

import com.sc.domain.DASolution;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

public class DutyStaffGenerator {

    public DASolution createDASolution(int staffSize, int planningWeekSize){
        DASolution dasolution = new DASolution();

        return dasolution;
    }

    private void createDutyList(DASolution dasolution, int planningWeekSize){}

    private void createStaffList(DASolution dasolution, int staffSize){
        try {
            File excelFile = new File("Staff_List.xlsx");
            FileInputStream fis = new FileInputStream(excelFile);
            XSSFWorkbook xWorkBook = new XSSFWorkbook(fis);
            XSSFSheet xSheet = xWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = xSheet.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
