package com.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class testmain3 {
    public static void main(String[] argv) throws Exception {

        try {

            LocalDate date1 = LocalDate.now();
            LocalDate date2 = date1.plusDays(new Random().nextInt(8));
            Period intervalPeriod = Period.between(date2, date1);

            System.out.println(" absolute interval " + Math.abs(intervalPeriod.getDays()));

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("completed finally!");
        }
    }
}

