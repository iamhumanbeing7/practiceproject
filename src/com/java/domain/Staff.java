package com.java.domain;

import org.optaplanner.examples.common.domain.AbstractPersistable;

import java.time.LocalDate;

public class Staff extends AbstractPersistable {
    private String name;
    private String staffID;
    private String specialty;
    private String pool;
    private OverseaTrip overseatrip;
    private LocalDate employedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public OverseaTrip getOverseatrip() {
        return overseatrip;
    }

    public void setOverseatrip(OverseaTrip overseatrip) {
        this.overseatrip = overseatrip;
    }

    public LocalDate getEmployedDate() {
        return employedDate;
    }

    public void setEmployedDate(LocalDate employedDate) {
        this.employedDate = employedDate;
    }
}
