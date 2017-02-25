package com.kokoster.tsp.Models;

import com.kokoster.tsp.Models.Point;
import com.kokoster.tsp.Models.PointSet;

/**
 * Created by kokoster on 22/02/2017.
 */
public class CircledPointSet extends PointSet {
    public CircledPointSet(int pointsCount, int radius) {
        super();

        double slice = 2 * Math.PI / pointsCount;

        for (int i = 0; i < pointsCount; ++i) {
            double angle = slice * i;

            double x = radius * Math.cos(angle) + radius + 2;
            double y = radius * Math.sin(angle) + radius + 2;

            points.add(new Point(x, y));
        }
    }
}
