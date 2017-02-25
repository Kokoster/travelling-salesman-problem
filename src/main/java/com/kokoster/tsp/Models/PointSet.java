package com.kokoster.tsp.Models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kokoster on 22/02/2017.
 */
public abstract class PointSet {
    protected ArrayList<Point> points;

//    protected constructor ?
    protected PointSet() {
        points = new ArrayList<>();
    }

    public Point getFarthestPointByX() {
        return Collections.max(points, (Point a, Point b) -> (int) (a.x - b.x));
    }

    public Point getFarthestPointByY() {
        return Collections.max(points, (Point a, Point b) -> (int) (a.y - b.y));
    }

    public int size() {
        return points.size();
    }

    public Point getPoint(int i) {
        return points.get(i);
    }
}
