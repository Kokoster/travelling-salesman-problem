package com.kokoster.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

/**
 * Created by kokoster on 04/02/2017.
 */
public class Selector {
    public ArrayList<Path> selectParents(ArrayList<Path> paths, PathValues values) {
        Collections.sort(paths,
                (Path a, Path b) -> (int) (values.calculateFitness(a) - values.calculateFitness(b))
        );

        ArrayList<Path> parents = new ArrayList<>();
        parents.add(paths.get(0));
        parents.add(paths.get(1));

        return parents;
    }

    public ArrayList<Path> selectSurvived(ArrayList<Path> paths, PathValues values, int m) {
        Collections.sort(paths,
                (Path a, Path b) -> (int) (values.calculateFitness(a) - values.calculateFitness(b))
        );

        ArrayList<Path> survived = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            survived.add(paths.get(i));
        }

        return survived;
    }
}
