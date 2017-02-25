package com.kokoster.tsp.Models;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kokoster on 03/02/2017.
 */
public class Path {
    private ArrayList<Integer> path;

    public Path() {
        path = new ArrayList<Integer>();
    }

    public Path(Integer ... nodes) {
        path = new ArrayList<Integer>(Arrays.asList(nodes));
    }

    public Path(ArrayList<Integer> path) {
        this.path = path;
    }

    public void addNode(int node) {
        path.add(node);
    }

    public int getNode(int index) {
        return path.get(index);
    }

    public int size() {
        return path.size();
    }

    public boolean exists(int node) {
        return path.contains(node);
    }

    public int getNextNode(int node) {
        int index = path.indexOf(node);

        if (index == -1 || index == path.size() - 1) {
            return -1;
        }

        return path.get(index + 1);
    }

    @Override
    public String toString() {
        StringBuilder strPath = new StringBuilder();

        for (Integer node : path) {
            strPath.append(node + " ");
        }

        return strPath.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Path.class) {
            return false;
        }

        Path compared = (Path) obj;

        for (int i = 0; i < path.size(); ++i) {
            if (! path.get(i).equals(compared.path.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void swap(int firstIndex, int secondIndex) {
        int temp = path.get(firstIndex);
        path.set(firstIndex, path.get(secondIndex));
        path.set(secondIndex, temp);
    }
}
