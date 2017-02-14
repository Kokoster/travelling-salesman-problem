package com.kokoster.tsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kokoster on 13/02/2017.
 */
public class TSPSolverTest {
    @Test
    public void testFindPath() throws Exception {
        ArrayList<ArrayList<Double>> valuesArray = new ArrayList<>();
        valuesArray.add(new ArrayList<>(Arrays.asList(999.0, 8.0, 5.0, 11.0, 12.0, 7.0)));
        valuesArray.add(new ArrayList<>(Arrays.asList(8.0, 999.0, 4.0, 7.0, 13.0, 11.0)));
        valuesArray.add(new ArrayList<>(Arrays.asList(5.0, 4.0, 999.0, 6.0, 10.0, 8.0)));
        valuesArray.add(new ArrayList<>(Arrays.asList(11.0, 8.0, 6.0, 999.0, 8.0, 10.0)));
        valuesArray.add(new ArrayList<>(Arrays.asList(12.0, 13.0, 10.0, 8.0, 999.0, 6.0)));
        valuesArray.add(new ArrayList<>(Arrays.asList(7.0, 11.0, 8.0, 10.0, 6.0, 999.0)));

        PathValues values = new PathValues(6);
        values.setValues(valuesArray);

        TSPSolver solver = new TSPSolver();
        ArrayList<Path> history = solver.findPath(values, 2, 6);
        Path child = history.get(history.size() - 1);

        System.out.println("Child: " + child + " : "  + values.calculateFitness(child));
    }
}