package com.sc.persistence;

import com.sc.domain.DASolution;
import com.sc.domain.Duty;
import com.sc.domain.DutyPeriod;
import com.sc.domain.Staff;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DutyStaffGenerator {

    public DASolution createDASolution(int planningWeekSize){
        DASolution dasolution = new DASolution();
        dasolution.setId(0L);

        createDutyList(dasolution, LocalDate.now(),52);
        createStaffList(dasolution);

        return dasolution;
    }

    private void createDutyList(DASolution dasolution, LocalDate planningStartDate , int iPlanningWeekSize){

        List<Duty> duties = new ArrayList<>();
        Duty duty;
        int counter =0;
        /*
        DO
        ORTL - ORT Lead X 1
        ORTM - ORT Member X 2
         */
        String[] dutyTypes = {"DO", "ORTL", "ORTM", "ORTM"};
        LocalDate nextStartDate = lastMonDate(planningStartDate);
        while(counter < iPlanningWeekSize){
            for(String dutyType : dutyTypes) {
                duty = new Duty();
                duty.setPk(counter);
                duty.setType(dutyType);
                DutyPeriod dutyPeriod = new DutyPeriod();
                dutyPeriod.setWeeksequence(counter);
                dutyPeriod.setStartDate(nextStartDate);
                dutyPeriod.setEndDate(nextStartDate.plusDays(6));
                duty.setPeriod(dutyPeriod);
                duties.add(duty);
            }
            counter++;
            nextStartDate = nextStartDate.plusDays(7);
        }
        dasolution.setDuties(duties);
    }

    private void createStaffList(DASolution dasolution){
        Date dateCellValue;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<Staff> staffs = new ArrayList<>();
        try {
            File excelFile = new File("D:\\Data\\CAAS_UC3\\Staff_List.xlsx");
            FileInputStream fis = new FileInputStream(excelFile);
            XSSFWorkbook xWorkBook = new XSSFWorkbook(fis);
            XSSFSheet xSheet = xWorkBook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
//            FormulaEvaluator evaluator = xWorkBook.getCreationHelper().createFormulaEvaluator();
            String cellValue = null;
            Iterator<Row> rowIterator = xSheet.rowIterator();
            Row row;
            Staff staff;
            int counter = 0;
            while(rowIterator.hasNext()){
                row = rowIterator.next();
                if (counter == 0) {
                    System.out.print("Ignore header line... \r\n");
                    counter++;
                    continue;
                }
                /*
                0	ID
                1	Salutation
                2	FirstName
                3	LastName
                4	Designation
                5	Section
                6	DateEmployed
                7	Pool
                 */
                staff = new Staff();
                staff.setID(dataFormatter.formatCellValue(row.getCell(0)));
                staff.setName(dataFormatter.formatCellValue(row.getCell(2)) + " " + dataFormatter.formatCellValue(row.getCell(3)));
                staff.setSpecialty(dataFormatter.formatCellValue(row.getCell(5)));
                staff.setEmployedDate(dateToldate(row.getCell(6).getDateCellValue()));
                staff.setPool(dataFormatter.formatCellValue(row.getCell(7)));
                staffs.add(staff);
                counter++;
            }
            dasolution.setStaffs(staffs);
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

//to convert Date instance to LocalDate instance
    private LocalDate dateToldate (Date date){

        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }

    private LocalDate lastMonDate (LocalDate ldate){

        DayOfWeek dow = ldate.getDayOfWeek();
        if(dow != DayOfWeek.MONDAY){
            ldate = ldate.minusDays(dow.ordinal() - DayOfWeek.MONDAY.ordinal());
        }

        return ldate;
    }

}
