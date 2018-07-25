package com.java.app;

import com.java.domain.DASolution;
import com.java.domain.Duty;
import com.java.domain.DutyAssignment;
import com.java.domain.Staff;
import com.java.persistence.DutyStaffGenerator;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.constraint.ConstraintMatchTotal;
import org.optaplanner.core.api.score.constraint.Indictment;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.core.impl.score.director.ScoreDirectorFactory;

import java.util.Map;


public class DutyTaskMain {

    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<DASolution> solverFactory = SolverFactory.createFromXmlResource(
                "com/resources/solver/DutyAssignmentSolverConfig.xml");
        Solver<DASolution> solver = solverFactory.buildSolver();

        int iPlanningWeekSize = 26;

        // Load a problem with 400 computers and 1200 processes
        DASolution unsolvedDASolution = new DutyStaffGenerator().createDASolution(iPlanningWeekSize);
        solver.solve(unsolvedDASolution);
        // Solve the problem
        DASolution solvedDASolution = solver.getBestSolution();



        // Display the result
        System.out.println("\nSolved Duty Assignment process:\n"
                + toDisplayString(solvedDASolution));

        ScoreDirectorFactory<DASolution> scoreDirectorFactory = solver.getScoreDirectorFactory();
        ScoreDirector<DASolution> guiScoreDirector = scoreDirectorFactory.buildScoreDirector();
        guiScoreDirector.setWorkingSolution(solver.getBestSolution());
        for (ConstraintMatchTotal constraintMatchTotal : guiScoreDirector.getConstraintMatchTotals()) {
            String constraintName = constraintMatchTotal.getConstraintName();
            Score<?> scoreTotal = constraintMatchTotal.getScoreTotal();
            System.out.println(constraintName + ": " + scoreTotal.toString());
        }


        Map<Object, Indictment> indictmentMap = guiScoreDirector.getIndictmentMap();
        for (DutyAssignment taskAssignment : solver.getBestSolution().getDutyAssignments()) {
            Indictment indictment = indictmentMap.get(taskAssignment);
            if (indictment == null) {
                continue;
            }
            // The score impact of that planning entity
            Score<?> scoreTotal = indictment.getScoreTotal();
            System.out.println(taskAssignment.getDuty().getPk() + " / " + taskAssignment.getStaff()+ " - " + taskAssignment.getStaff().getSpecialty()+ " / " + taskAssignment.getId()+ " / " + scoreTotal.toString());
        }


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
