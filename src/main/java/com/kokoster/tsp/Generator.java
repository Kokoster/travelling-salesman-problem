package com.kokoster.tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kokoster on 03/02/2017.
 */
public class Generator {
    public ArrayList<Path> generatePopulation(int startPoint, int populationSize, int nodesCount, PathValues values) {
        ArrayList<Path> paths = new ArrayList<Path>();

        for (int i = 0; i < populationSize; ++i) {
            ArrayList<Integer> orderedPath = new ArrayList<Integer>();
            orderedPath.add(startPoint);
            for (int j = 0; j < nodesCount; ++j) {
                if (j != startPoint){
                    orderedPath.add(j);
                }
            }

            Collections.shuffle(orderedPath);
            paths.add(new Path(orderedPath));
        }

        Collections.sort(paths,
                (Path a, Path b) -> (int) (values.calculateFitness(a) - values.calculateFitness(b))
        );

        return paths;
    }
}
