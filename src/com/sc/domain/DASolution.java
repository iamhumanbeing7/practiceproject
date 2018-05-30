package com.sc.domain;

import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;

import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import java.util.List;

@PlanningSolution
public class DASolution extends AbstractPersistable{

    private List<Duty> duties;

    @ValueRangeProvider(id = "staffRange")
    @ProblemFactCollectionProperty
    private List<Staff> staffs;

    @PlanningEntityCollectionProperty
    private List<DutyAssignment> dutyAssignments;

    private HardSoftScore score;


    public List<Duty> getDuties() {
        return duties;
    }

    public void setDuties(List<Duty> duties) {
        this.duties = duties;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }


    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    public List<DutyAssignment> getDutyAssignments() {
        return dutyAssignments;
    }

    public void setDutyAssignments(List<DutyAssignment> dutyAssignments) {
        this.dutyAssignments = dutyAssignments;
    }


}
