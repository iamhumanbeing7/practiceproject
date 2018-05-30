package com.sc.domain;

import org.optaplanner.examples.common.domain.AbstractPersistable;

import java.time.LocalDate;

public class Period extends AbstractPersistable {
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
}
