package com.sc.domain;

import org.optaplanner.examples.common.domain.AbstractPersistable;

public class Staff extends AbstractPersistable {
    private String name;
    private String ID;
    private String specialty;
    private String pool;
    private OverseaTrip overseatrip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
}
