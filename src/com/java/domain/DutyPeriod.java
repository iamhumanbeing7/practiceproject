package com.java.domain;

import org.optaplanner.examples.common.domain.AbstractPersistable;

import java.time.LocalDate;

public class DutyPeriod extends AbstractPersistable {
    private int weeksequence;
    private LocalDate StartDate;
    private LocalDate EndDate;

    public LocalDate getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {
        StartDate = startDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public int getWeeksequence() {
        return weeksequence;
    }

    public void setWeeksequence(int weeksequence) {
        this.weeksequence = weeksequence;
    }
}
