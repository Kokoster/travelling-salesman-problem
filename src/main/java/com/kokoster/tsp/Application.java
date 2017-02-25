package com.kokoster.tsp;

import com.kokoster.tsp.Models.PathValues;
import com.kokoster.tsp.Models.PointSet;
import com.kokoster.tsp.TSP.Solver;
import com.kokoster.tsp.UI.SolutionView;

/**
 * Created by kokoster on 25/02/2017.
 */
public class Application {
    private PointSet pointSet;

    public Application(PointSet pointSet) {
        this.pointSet = pointSet;
    }

    public void run() {
        Solver solver = new Solver(0, new PathValues(pointSet), 2, pointSet.size());

        new SolutionView(pointSet, solver.getSolution());

        new Thread(solver::solve).start();
    }
}
