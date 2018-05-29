package com.sc.obsolete;

import com.sc.domain.Staff;
import org.optaplanner.examples.common.domain.AbstractPersistable;

import java.util.List;

public class Pool extends AbstractPersistable {
    private String type;
    private List<Staff> staffList;
}
