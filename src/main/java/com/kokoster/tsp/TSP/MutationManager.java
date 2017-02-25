package com.kokoster.tsp.TSP;

import com.kokoster.tsp.Models.Path;

import java.util.Random;

/**
 * Created by kokoster on 12/02/2017.
 */
public class MutationManager {
    private final Random rand;

    public MutationManager(Random rand) {
        this.rand = rand;
    }

    public void mutate(Path path) {
        int size = path.size();

        int firstIndex = rand.nextInt(size - 1) + 1;
        int secondIndex = rand.nextInt(size - 1) + 1;

        path.swap(firstIndex, secondIndex);
    }
}
