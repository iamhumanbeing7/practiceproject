package com.java.obsolete;

import com.java.domain.Staff;
import org.optaplanner.examples.common.domain.AbstractPersistable;

import java.util.List;

public class Specialty extends AbstractPersistable {
  /*
  FO - Flight Ops
  CA - Continuing AirWorthiness
  AE - AirWorthiness Engineering
  CS/DG - Dangerous Goods
  */
    private String typeCode;
    private List<Staff> staffList;

}
