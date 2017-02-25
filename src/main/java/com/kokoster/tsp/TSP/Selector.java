package com.kokoster.tsp.TSP;

import com.kokoster.tsp.Models.Path;
import com.kokoster.tsp.Models.PathValues;

import java.util.ArrayList;
import java.util.Collections;

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
