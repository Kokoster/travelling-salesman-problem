package com.kokoster.tsp.Models;

import com.kokoster.tsp.Models.Point;
import com.kokoster.tsp.Models.PointSet;

import java.util.Random;

/**
 * Created by kokoster on 22/02/2017.
 */
public class RandomPointSet extends PointSet {
    public RandomPointSet(int pointsCount, int maxValue) {
        super();

        Random rand = new Random();
        for (int i = 0; i < pointsCount; ++i) {
            points.add(new Point(rand.nextInt(maxValue + 1), rand.nextInt(maxValue + 1)));
        }
    }
}
