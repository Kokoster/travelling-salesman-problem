package com.kokoster.tsp.UI;

import com.kokoster.tsp.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by kokoster on 14/02/2017.
 */
public class TSPVisualiser {
    private JFrame frame;
    private MapCanvas canvas;
    private ArrayList<com.kokoster.tsp.Point> map;

    public TSPVisualiser(ArrayList<com.kokoster.tsp.Point> map) {
        frame = new JFrame("Path drawer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.map = map;
        canvas = new MapCanvas(map);
        frame.getContentPane().add(canvas, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void render() throws InterruptedException {
        TSPSolver solver = new TSPSolver();
        ArrayList<Path> history = solver.findPath(0, new PathValues(map), 2, map.size());

        for (Path child : history) {
//            System.out.println(child);

            canvas.drawPath(child);

            Thread.sleep(70);
        }

        System.out.println("FINISHED");
    }
}
