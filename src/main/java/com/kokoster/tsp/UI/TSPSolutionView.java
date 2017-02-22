package com.kokoster.tsp.UI;

import com.kokoster.tsp.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kokoster on 14/02/2017.
 */
public class TSPSolutionView {
    private MapCanvas canvas;

    public TSPSolutionView(PointSet pointSet, TSPSolver solver) {
        JFrame frame = new JFrame("Path drawer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        canvas = new MapCanvas(pointSet);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);

        solver.getCurrentSolution().addListener(path -> canvas.setPath(path));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
