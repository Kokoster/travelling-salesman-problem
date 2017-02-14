package com.kokoster.tsp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kokoster on 13/02/2017.
 */
public class TSPSolver {
    private static final int MAX_RETRIES_COUNT = 50;

    public ArrayList<Path> findPath(PathValues values, int populationSize, int nodesCount) {
        ArrayList<Path> history = new ArrayList<>();

        Generator populationGenerator = new Generator();
        ArrayList<Path> population =
                populationGenerator.generatePopulation(populationSize, nodesCount, values);
        history.add(population.get(0));

        Random rand = new Random();
        Selector selector = new Selector();
        CrossoverManager crossoverManager = new CrossoverManager(rand);
        MutationManager mutationManager = new MutationManager(rand);

        int retriesCount = 0;
        while (retriesCount < MAX_RETRIES_COUNT) {
            ArrayList<Path> parents = selector.selectParents(population, values);

            Path child = crossoverManager.doCrossover(parents.get(0), parents.get(1), values);
            mutationManager.mutate(child);

            population.add(child);
            selector.selectSurvived(population, values, populationSize);

            if (parents.get(0) == population.get(0) &&
                    parents.get(1) == population.get(1)) {
                retriesCount++;
            } else {
                retriesCount = 0;
            }

            history.add(population.get(0));
        }

        return history;
    }
}
