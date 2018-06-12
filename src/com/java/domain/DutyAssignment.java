package com.java.domain;

import org.drools.core.rule.QueryArgument;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;

@PlanningEntity
public class DutyAssignment extends AbstractPersistable {
    private Duty duty;

    @PlanningVariable(valueRangeProviderRefs = {"staffRange"})
    private Staff staff;

    public Duty getDuty() {
        return duty;
    }

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public boolean isAssgined() {
        boolean flag = false;
        if (staff != null) flag = true;
        return flag;
    }
}
