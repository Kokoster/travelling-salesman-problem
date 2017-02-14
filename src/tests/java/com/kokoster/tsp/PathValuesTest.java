package com.kokoster.tsp;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by kokoster on 13/02/2017.
 */
public class PathValuesTest {

    @Test
    public void testPathValuesByPoints() throws Exception {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(0, 4));
        points.add(new Point(3, 0));

        PathValues values = new PathValues(points);

        assertEquals((Double) 4.0, values.getValue(0, 1));
        assertEquals((Double) 3.0, values.getValue(0, 2));
        assertEquals((Double) 4.0, values.getValue(1, 0));
        assertEquals((Double) 5.0, values.getValue(1, 2));
        assertEquals((Double) 1e9, values.getValue(2, 2));
    }
}