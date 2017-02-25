package com.kokoster.tsp.UI;

import com.kokoster.tsp.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kokoster on 14/02/2017.
 */
public class SolutionView {
    private MapCanvas canvas;

    public SolutionView(PointSet pointSet, Solution solution) {
        JFrame frame = new JFrame("Path drawer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        canvas = new MapCanvas(pointSet);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);

        solution.addListener(path -> canvas.setPath(path));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
