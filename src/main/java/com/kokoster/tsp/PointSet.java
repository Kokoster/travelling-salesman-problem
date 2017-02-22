package com.kokoster.tsp;

import java.util.ArrayList;

/**
 * Created by kokoster on 22/02/2017.
 */
public interface PointSet {
    void generatePointSet(int pointsCount, int maxValue);

    Point getMaxPointByX();
    Point getMaxPointByY();

    int size();
    Point getPoint(int i);
}
