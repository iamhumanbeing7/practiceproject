package com.test;

import com.java.domain.DutyPeriod;
import com.java.persistence.Constants;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class testmain4 {
    public static void main(String[] argv) throws Exception {

        boolean returnvalue = false;
        LocalDate ld = LocalDate.of(2018,Month.AUGUST,6);
        DutyPeriod dutyPeriod = new DutyPeriod();
        dutyPeriod.setStartDate(ld);
        dutyPeriod.setEndDate(ld.plusDays(6));

        List<LocalDate> phList = Arrays.asList(Constants.publicholidays);
        for (int i = 0; i < 7; i++) {
            LocalDate tempLDate = dutyPeriod.getStartDate().plusDays(i);
            System.out.println(tempLDate.toString());
            if (phList.contains(tempLDate)) {
                returnvalue = true;
                System.out.println("Is a public holiday!!");
                break;
            }
            if(!returnvalue) System.out.println("not a public holiday");
        }
    }
}
