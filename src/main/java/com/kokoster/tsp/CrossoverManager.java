package com.kokoster.tsp;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by kokoster on 04/02/2017.
 */
public class CrossoverManager {
    private final Random rand;

    public CrossoverManager(Random rand) {
        this. rand = rand;
    }

    public Path doCrossover(Path firstParent, Path secondParent, PathValues values) {
        Path child = new Path();
        int pathSize = firstParent.size();

        boolean[] visited = new boolean[pathSize];
        Arrays.fill(visited, false);

        int firstNode = rand.nextInt(pathSize);
        child.addNode(firstNode);
        visited[firstNode] = true;
        int node = firstNode;

        for (int i = 1; i < pathSize; ++i) {
            int firstNextNode = getNextNode(firstParent, visited, node);
            int secondNextNode = getNextNode(secondParent, visited, node);

            double firstValue = values.getValue(node, firstNextNode);
            double secondValue = values.getValue(node, secondNextNode);

//            System.out.println("current node: " + node);
//            System.out.println("first next node: " +  firstNextNode + ": " + firstValue);
//            System.out.println("second next node: " +  secondNextNode + ": " + secondValue);

            if (firstValue <= secondValue) {
                child.addNode(firstNextNode);
                node = firstNextNode;
            } else {
                child.addNode(secondNextNode);
                node = secondNextNode;
            }

            visited[node] = true;
        }

        return child;
    }

    private int getNextNode(Path parent, boolean[] visited, int node) {
        int pathSize = parent.size();

        int nextNode = parent.getNextNode(node);
        while (nextNode == -1 || visited[nextNode]) {
            nextNode = rand.nextInt(pathSize);
        }

        return nextNode;
    }
}
