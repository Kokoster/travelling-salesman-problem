package com.kokoster.tsp.UI;

import com.kokoster.tsp.Models.PathValues;
import com.kokoster.tsp.Models.PointSet;
import com.kokoster.tsp.Models.Solution;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kokoster on 14/02/2017.
 */
public class SolutionView {
    private MapCanvas canvas;
    private JLabel fitnessLabel;
    private JLabel fitnessValue;

    public SolutionView(PointSet pointSet, PathValues values, Solution solution) {
        JFrame frame = new JFrame("Path drawer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        canvas = new MapCanvas(pointSet);
        solution.addListener(path -> canvas.setPath(path));
        solution.addListener(path -> updateFitnessTextField(values.calculateFitness(path)));

        fitnessLabel = new JLabel("Fitness: ");
        fitnessValue = new JLabel();
        fitnessLabel.setLabelFor(fitnessValue);

        setLayout(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setLayout(Container panel) {
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 4;
        panel.add(canvas, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        panel.add(fitnessLabel, c);

        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        panel.add(fitnessValue, c);
    }

    private void updateFitnessTextField(Double fitnessFunction) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                fitnessValue.setText(fitnessFunction.toString());
            }
        });
    }
}
