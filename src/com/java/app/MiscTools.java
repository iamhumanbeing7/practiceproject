package com.java.app;

import com.java.domain.DutyPeriod;
import com.java.persistence.Constants;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class MiscTools {

    public static int differenceOfDates(LocalDate ldate1, LocalDate ldate2){
        Period inveralPeriod = Period.between(ldate1, ldate2);
        int differenceOfDates = Math.abs(inveralPeriod.getDays());
        return differenceOfDates;
    }

    public static boolean isContainPH(DutyPeriod dutyPeriod){
        boolean returnvalue = false;
        Period inveralPeriod = Period.between(dutyPeriod.getStartDate(), dutyPeriod.getEndDate());
        int differenceOfDates = Math.abs(inveralPeriod.getDays())+1;
        if(dutyPeriod == null){
            returnvalue = false;
        } else {
            List<LocalDate> phList = Arrays.asList(Constants.publicholidays);

            for(int i = 0; i<((differenceOfDates<7)? 7 : differenceOfDates); i++){
                LocalDate tempLDate = dutyPeriod.getStartDate().plusDays(i);
                if(phList.contains(tempLDate)){
                    returnvalue = true;
                    break;
                }
            }
        }
        return returnvalue;
    }
}
