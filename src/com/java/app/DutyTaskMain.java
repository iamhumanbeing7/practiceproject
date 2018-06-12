package com.java.app;

import com.java.domain.DASolution;
import com.java.domain.Duty;
import com.java.domain.DutyAssignment;
import com.java.domain.Staff;
import com.java.persistence.DutyStaffGenerator;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;


public class DutyTaskMain {

    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<DASolution> solverFactory = SolverFactory.createFromXmlResource(
                "com/resources/solver/DutyAssignmentSolverConfig.xml");
        Solver<DASolution> solver = solverFactory.buildSolver();

        int iPlanningWeekSize = 26;

        // Load a problem with 400 computers and 1200 processes
        DASolution unsolvedDASolution = new DutyStaffGenerator().createDASolution(iPlanningWeekSize);

        // Solve the problem
        DASolution solvedDASolution = solver.solve(unsolvedDASolution);

        // Display the result
        System.out.println("\nSolved Duty Assignment process:\n"
                + toDisplayString(solvedDASolution));
    }

    public static String toDisplayString(DASolution solvedDASolution) {
        StringBuilder displayString = new StringBuilder();
        for (DutyAssignment dutyAssignment : solvedDASolution.getDutyAssignments()) {
            Staff staff = dutyAssignment.getStaff();
            Duty duty = dutyAssignment.getDuty();
            displayString.append("  ").append("Staff ID:" + staff.getStaffID() + " Pool:" + staff.getPool() + " Sepcialty:" + staff.getSpecialty() ).append(" -> ")
                    .append(duty == null ? null : ("Week-" + duty.getPeriod().getWeeksequence()+ " " + duty.getType() + " " + duty.getPool() + " " + duty.getPeriod().getStartDate() + " " + duty.getPeriod().getEndDate())).append("\n");
        }
        return displayString.toString();
    }

}
