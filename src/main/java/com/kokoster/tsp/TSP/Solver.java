package com.kokoster.tsp.TSP;

import com.kokoster.tsp.Models.Path;
import com.kokoster.tsp.Models.PathValues;
import com.kokoster.tsp.Models.Solution;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kokoster on 13/02/2017.
 */

public class Solver {
    private static final int MAX_RETRIES_COUNT = (int) 1e5;

    private Solution solution;

    private int startPoint;
    private PathValues values;
    private int populationSize;
    private int nodesCount;

    public Solver(int startPoint, PathValues values, int populationSize, int nodesCount) {
        solution = new Solution();

        this.startPoint = startPoint;
        this.values = values;
        this.populationSize = populationSize;
        this.nodesCount = nodesCount;
    }

    public void solve() {
        ArrayList<Path> population = generatePopulation();
        solution.setCurrentSolution(population.get(0));

//        package private methods ?
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

            if (!population.get(0).equals(solution.getCurrentSolution())) {
                solution.setCurrentSolution(population.get(0));
            }
        }

        System.out.println("FINISHED");
    }

    public Solution getSolution() {
        return solution;
    }

    private ArrayList<Path> generatePopulation() {
        Generator populationGenerator = new Generator();
        return populationGenerator.generatePopulation(startPoint, populationSize, nodesCount, values);
    }
}
