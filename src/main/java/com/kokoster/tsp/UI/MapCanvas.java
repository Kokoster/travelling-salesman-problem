package com.kokoster.tsp.UI;

import com.kokoster.tsp.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kokoster on 14/02/2017.
 */
public class MapCanvas extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;

    PointSet pointSet;
    private Path currentPath;

    double koefX;
    double koefY;

    public MapCanvas(PointSet pointSet) {
        this.pointSet = pointSet;

        koefX = (double) (WIDTH - 20) / pointSet.getMaxPointByX().x;
        koefY = (double) (HEIGHT - 20) / pointSet.getMaxPointByY().y;

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
        int size = pointSet.size();

        for (int i = 0; i < size; ++i) {
            g.fillOval((int) (pointSet.getPoint(i).x * koefX) - 3, (int) (HEIGHT - pointSet.getPoint(i).y * koefY) - 3, 6, 6);
        }
    }

    private void drawPathLines(Graphics g) {
        int size = currentPath.size();

        for (int i = 0; i < size - 1; ++i) {
            com.kokoster.tsp.Point first = pointSet.getPoint((currentPath.getNode(i)));
            com.kokoster.tsp.Point second = pointSet.getPoint((currentPath.getNode(i + 1)));

            g.drawLine((int) (first.x * koefX), (int) (HEIGHT - first.y * koefY),
                       (int) (second.x * koefX), (int) (HEIGHT - second.y * koefY));
        }

        com.kokoster.tsp.Point first = pointSet.getPoint((currentPath.getNode(size - 1)));
        com.kokoster.tsp.Point second = pointSet.getPoint((currentPath.getNode(0)));

        g.drawLine((int) (first.x * koefX), (int) (HEIGHT - first.y * koefY),
                  (int) (second.x * koefX), (int) (HEIGHT - second.y * koefY));
    }

    public void setPath(Path newPath) {
        currentPath = newPath;
        repaint();
    }
}
