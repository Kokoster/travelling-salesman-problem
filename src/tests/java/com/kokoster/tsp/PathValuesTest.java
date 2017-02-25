package com.kokoster.tsp;

import com.kokoster.tsp.Models.PathValues;
import com.kokoster.tsp.Models.Point;
import com.kokoster.tsp.Models.PointSet;
import org.junit.Test;

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

    private class TestPointSet extends PointSet {
        public TestPointSet() {
            super();

            points.add(new Point(0, 0));
            points.add(new Point(0, 4));
            points.add(new Point(3, 0));
        }

        @Override
        public Point getFarthestPointByX() {
            return new Point(3, 0);
        }

        @Override
        public Point getFarthestPointByY() {
            return new Point(0, 4);
        }
    }
}