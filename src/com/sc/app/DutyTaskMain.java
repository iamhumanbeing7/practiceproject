package com.sc.app;

import com.sc.domain.DASolution;
import com.sc.persistence.DutyStaffGenerator;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;


public class DutyTaskMain {

    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<DASolution> solverFactory = SolverFactory.createFromXmlResource(
                "com/sc/solver/DutyAssignmentSolverConfig.xml");
        Solver<DASolution> solver = solverFactory.buildSolver();

        int iPlanningWeekSize = 26;

        // Load a problem with 400 computers and 1200 processes
        DASolution unsolvedDASolution = new DutyStaffGenerator().createDASolution(iPlanningWeekSize);

        // Solve the problem
        DASolution solvedDASolution = solver.solve(unsolvedDASolution);

        // Display the result
//        System.out.println("\nSolved cloudBalance with 400 computers and 1200 processes:\n"
//                + toDisplayString(solvedCloudBalance));
    }

}
