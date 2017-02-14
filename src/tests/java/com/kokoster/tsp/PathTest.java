package com.kokoster.tsp;

import static org.junit.Assert.*;

/**
 * Created by kokoster on 05/02/2017.
 */
public class PathTest {

    @org.junit.Test
    public void testCalculateFitness() throws Exception {
        PathValues values =  new PathValues(3);
        values.setValue(0, 1, 1.0);
        values.setValue(0, 2, 2.0);
        values.setValue(1, 0, 3.0);
        values.setValue(1, 2, 4.0);
        values.setValue(2, 0, 5.0);
        values.setValue(2, 1, 6.0);

        Path path = new Path(1, 2, 0);
        assertEquals((Double) 10.0, values.calculateFitness(path));

        path = new Path(0, 1, 2);
        assertEquals((Double) 10.0, values.calculateFitness(path));

        path = new Path(2, 0, 1);
        assertEquals((Double) 10., values.calculateFitness(path));

        path = new Path(2, 1, 0);
        assertEquals((Double) 11.0, values.calculateFitness(path));
    }
}