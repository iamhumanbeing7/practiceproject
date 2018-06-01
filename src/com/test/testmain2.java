package com.test;

import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

public class testmain2 {
    public static void main(String[] argv) throws Exception {

        try {
            LocalDate ldate = LocalDate.now();
            System.out.println(ldate.toString() + ", " + ldate.getDayOfWeek().toString());
            DayOfWeek dow = ldate.getDayOfWeek();
            if(dow != DayOfWeek.MONDAY){
                ldate = ldate.minusDays(dow.ordinal() - DayOfWeek.MONDAY.ordinal());
            }
            System.out.println(ldate.toString() + ", " + ldate.getDayOfWeek().toString());


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("completed finally!");
        }
    }
}
