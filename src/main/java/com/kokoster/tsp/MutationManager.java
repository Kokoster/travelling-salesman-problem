package com.kokoster.tsp;

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

        int firstIndex = rand.nextInt(size);
        int secondIndex = rand.nextInt(size);

        path.swap(firstIndex, secondIndex);
    }
}
