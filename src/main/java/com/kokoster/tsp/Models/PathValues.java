package com.kokoster.tsp.Models;

import com.kokoster.tsp.Models.Path;
import com.kokoster.tsp.Models.PointSet;

import java.util.ArrayList;

/**
 * Created by kokoster on 04/02/2017.
 */
public class PathValues {
    ArrayList<ArrayList<Double>> values;

    public PathValues(int nodesCount) {
        values = new ArrayList<>();

        for (int i = 0; i < nodesCount; ++i) {
            values.add(new ArrayList<>());
            for (int j = 0; j < nodesCount; ++j) {
                values.get(i).add(null);
            }
        }
    }

    public PathValues(PointSet pointSet) {
        values = new ArrayList<>();
        int size = pointSet.size();

        for (int i = 0; i < size; ++i) {
            values.add(new ArrayList<>());

            for (int j = 0; j < size; ++j) {
                if (i == j) {
                    values.get(i).add(1e9);
                } else {
                    double value = Math.sqrt((pointSet.getPoint(i).x - pointSet.getPoint(j).x) *
                            ((pointSet.getPoint(i).x - pointSet.getPoint(j).x)) +
                                             (pointSet.getPoint(i).y - pointSet.getPoint(j).y) *
                                                     (pointSet.getPoint(i).y - pointSet.getPoint(j).y));
                    values.get(i).add(value);
                }
            }
        }
    }

    public void setValues(ArrayList<ArrayList<Double>> values) {
        this.values = values;
    }

    public Double getValue(int fromNode, int toNode) {
        return values.get(fromNode).get(toNode);
    }

    public void setValue(int fromNode, int toNode, Double value) {
        values.get(fromNode).set(toNode, value);
    }

    public Double calculateFitness(Path path) {
        Double sum = 0.00;

        for (int i = 0; i < path.size() - 1; ++i) {
            sum += getValue(path.getNode(i), path.getNode(i + 1));
        }

        sum += getValue(path.getNode(path.size() - 1), path.getNode(0));

        return sum;
    }
}
