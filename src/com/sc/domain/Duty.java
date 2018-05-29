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
    private Period period;
    private int requiredStaffSize;
}
