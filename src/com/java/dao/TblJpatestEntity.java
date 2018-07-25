package com.java.dao;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

public class TblJpatestEntity {
    private int id;
    private String name;
    private LocalDate rdate;
    private double ramount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRdate() {
        return rdate;
    }

    public void setRdate(LocalDate rdate) {
        this.rdate = rdate;
    }

    public double getRamount() {
        return ramount;
    }

    public void setRamount(double ramount) {
        this.ramount = ramount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblJpatestEntity that = (TblJpatestEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(rdate, that.rdate) &&
                Objects.equals(ramount, that.ramount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, rdate, ramount);
    }
}
