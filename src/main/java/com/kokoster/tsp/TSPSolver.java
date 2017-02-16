package com.kokoster.tsp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kokoster on 13/02/2017.
 */
public class TSPSolver {
    private static final int MAX_RETRIES_COUNT = 100;

    public ArrayList<Path> findPath(int startPoint, PathValues values, int populationSize, int nodesCount) {
        ArrayList<Path> history = new ArrayList<>();

        Generator populationGenerator = new Generator();
        ArrayList<Path> population =
                populationGenerator.generatePopulation(startPoint, populationSize, nodesCount, values);
        history.add(population.get(0));

        Random rand = new Random();
        Selector selector = new Selector();
        CrossoverManager crossoverManager = new CrossoverManager(rand);
        MutationManager mutationManager = new MutationManager(rand);

        int retriesCount = 0;
        while (retriesCount < MAX_RETRIES_COUNT) {
            ArrayList<Path> parents = selector.selectParents(population, values);

            Path child = crossoverManager.doCrossover(startPoint, parents.get(0), parents.get(1), values);
            mutationManager.mutate(child);

            population.add(child);
            population = selector.selectSurvived(population, values, populationSize);

            if (parents.get(0) == population.get(0) &&
                    parents.get(1) == population.get(1)) {
                retriesCount++;
            } else {
                retriesCount = 0;
            }

            if (! population.get(0).equals(history.get(history.size() - 1))) {
                history.add(population.get(0));
            }
        }

        return history;
    }
}
