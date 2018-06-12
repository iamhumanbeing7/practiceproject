package com.java.persistence;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class Constants {

    public static final String poolA = "A";
    public static final String poolB = "B";
    public static final String dutyType_DO = "DO";
    public static final String dutyType_ORT_Lead = "ORTL";
    public static final String dutyType_ORT_Member = "ORTM";
    public static final LocalDate[] publicholidays = {
            LocalDate.of(2018,Month.JUNE,15),
            LocalDate.of(2018,Month.AUGUST,9),
            LocalDate.of(2018,Month.AUGUST,22),
            LocalDate.of(2018,Month.NOVEMBER,6),
            LocalDate.of(2018,Month.JUNE,15),
            LocalDate.of(2018,Month.DECEMBER,25),

            LocalDate.of(2019,Month.JANUARY,1),
            LocalDate.of(2019,Month.FEBRUARY,5),
            LocalDate.of(2019,Month.FEBRUARY,6),
            LocalDate.of(2019,Month.APRIL,19),
            LocalDate.of(2019,Month.MAY,1),
            LocalDate.of(2019,Month.MAY,19),
            LocalDate.of(2019,Month.JUNE,5),
            LocalDate.of(2019,Month.AUGUST,9),
            LocalDate.of(2019,Month.AUGUST,11),
            LocalDate.of(2019,Month.OCTOBER,27),
            LocalDate.of(2019,Month.DECEMBER,25)

    };


}
