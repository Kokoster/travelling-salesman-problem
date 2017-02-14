package com.kokoster.tsp.UI;

import com.kokoster.tsp.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kokoster on 14/02/2017.
 */
public class MapCanvas extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;

    private ArrayList<com.kokoster.tsp.Point> map;
    private Path currentPath;

    double koefX;
    double koefY;

    public MapCanvas(ArrayList<com.kokoster.tsp.Point> map) {
        this.map = map;

        koefX = (double) (WIDTH - 20) / Collections.max(map, (com.kokoster.tsp.Point a, com.kokoster.tsp.Point b) -> (int) (a.x - b.x)).x;
        koefY = (double) (HEIGHT - 20) / Collections.max(map, (com.kokoster.tsp.Point a, com.kokoster.tsp.Point b) -> (int) (a.y - b.y)).y;

        currentPath = null;

        setBackground(Color.white);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        if (currentPath == null) {
            drawPoints(g);
        } else {
            drawPathLines(g);
            drawPoints(g);
        }
    }

    private void drawPoints(Graphics g) {
        int size = map.size();

        for (int i = 0; i < size; ++i) {
            g.fillOval((int) (map.get(i).x * koefX) - 3, (int) (HEIGHT - map.get(i).y * koefY) - 3, 6, 6);
        }
    }

    private void drawPathLines(Graphics g) {
        int size = currentPath.size();

        for (int i = 0; i < size - 1; ++i) {
            com.kokoster.tsp.Point first = map.get(currentPath.getNode(i));
            com.kokoster.tsp.Point second = map.get(currentPath.getNode(i + 1));

            g.drawLine((int) (first.x * koefX), (int) (HEIGHT - first.y * koefY),
                       (int) (second.x * koefX), (int) (HEIGHT - second.y * koefY));
        }

        com.kokoster.tsp.Point first = map.get(currentPath.getNode(size - 1));
        com.kokoster.tsp.Point second = map.get(currentPath.getNode(0));

        g.drawLine((int) (first.x * koefX), (int) (HEIGHT - first.y * koefY),
                  (int) (second.x * koefX), (int) (HEIGHT - second.y * koefY));
    }

    public void drawPath(Path newPath) {
        currentPath = newPath;
        repaint();
    }
}
