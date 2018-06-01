package com.sc.domain;

import org.optaplanner.examples.common.domain.AbstractPersistable;

public class Duty extends AbstractPersistable {
    /*
    DO
    ORT Lead X 1
    ORT Member X 2
     */
    private int pk;
    private String type;
    private DutyPeriod period;
    private int requiredNOofStaff;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DutyPeriod getPeriod() {
        return period;
    }

    public void setPeriod(DutyPeriod period) {
        this.period = period;
    }

    public int getRequiredNOofStaff() {
        return requiredNOofStaff;
    }

    public void setRequiredNOofStaff(int requiredNOofStaff) {
        this.requiredNOofStaff = requiredNOofStaff;
    }
}
