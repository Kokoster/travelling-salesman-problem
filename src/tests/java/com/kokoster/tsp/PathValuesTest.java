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
        TestPointSet pointSet = new TestPointSet();
        PathValues values = new PathValues(pointSet);

        assertEquals((Double) 4.0, values.getValue(0, 1));
        assertEquals((Double) 3.0, values.getValue(0, 2));
        assertEquals((Double) 4.0, values.getValue(1, 0));
        assertEquals((Double) 5.0, values.getValue(1, 2));
        assertEquals((Double) 1e9, values.getValue(2, 2));
    }

    private class TestPointSet implements  PointSet {
        ArrayList<Point> points = new ArrayList<>();

        @Override
        public void generatePointSet(int pointsCount, int maxValue) {
            points.add(new Point(0, 0));
            points.add(new Point(0, 4));
            points.add(new Point(3, 0));
        }

        @Override
        public Point getMaxPointByX() {
            return new Point(3, 0);
        }

        @Override
        public Point getMaxPointByY() {
            return new Point(0, 4);
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Point getPoint(int i) {
            return null;
        }
    }
}