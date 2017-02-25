package com.kokoster.tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kokoster on 22/02/2017.
 */
public class CircledPointSet implements PointSet {
    private ArrayList<Point> points;

    @Override
    public void generatePointSet(int pointsCount, int radius) {
        double slice = 2 * Math.PI / pointsCount;

        for (int i = 0; i < pointsCount; ++i) {
            double angle = slice * i;

            double x = radius * Math.cos(angle) + radius + 2;
            double y = radius * Math.sin(angle) + radius + 2;

            points.add(new Point(x, y));
        }
    }

    @Override
    public Point getMaxPointByX() {
        return Collections.max(points, (Point a, Point b) -> (int) (a.x - b.x));
    }

    @Override
    public Point getMaxPointByY() {
        return Collections.max(points, (Point a, Point b) -> (int) (a.y - b.y));
    }

    @Override
    public int size() {
        return points.size();
    }

    @Override
    public Point getPoint(int i) {
        return points.get(i);
    }
}
