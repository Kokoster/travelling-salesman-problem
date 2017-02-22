package com.kokoster.tsp;

import java.util.ArrayList;

/**
 * Created by kokoster on 22/02/2017.
 */
public class Solution {
    private Path currentSolution = null;

    private ArrayList<PathFoundListener> listeners = new ArrayList<>();

    public void addListener(PathFoundListener listener) {
        listeners.add(listener);
    }

    public Path getCurrentSolution() {
        return currentSolution;
    }

    public void setCurrentSolution(Path currentSolution) {
        this.currentSolution = currentSolution;

        for (PathFoundListener listener : listeners) {
            listener.onNewPathFound(currentSolution);
        }
    }
}
