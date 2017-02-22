package com.kokoster.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by kokoster on 22/02/2017.
 */
public class RandomPointSet implements PointSet {
    private ArrayList<Point> points = new ArrayList<>();

    public ArrayList<Point> getPointSet() {
        return points;
    }

    @Override
    public void generatePointSet(int pointsCount, int maxValue) {
        Random rand = new Random();
        for (int i = 0; i < pointsCount; ++i) {
            points.add(new Point(rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1)));
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
