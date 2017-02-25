package com.kokoster.tsp.UI;

import com.kokoster.tsp.*;
import com.kokoster.tsp.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kokoster on 14/02/2017.
 */
public class MapCanvas extends JPanel {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 600;

    PointSet pointSet;
    private Path path;

    double koefX;
    double koefY;

    public MapCanvas(PointSet pointSet) {
        this.pointSet = pointSet;

        koefX = (double) (WIDTH - 20) / pointSet.getMaxPointByX().x;
        koefY = (double) (HEIGHT - 20) / pointSet.getMaxPointByY().y;

        path = null;

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
        if (path != null) {
            drawPathLines(g);
        }

        drawPoints(g);
    }

    private void drawPoints(Graphics g) {
        int size = pointSet.size();

        for (int i = 0; i < size; ++i) {
            drawSinglePoint(g, pointSet.getPoint(i));
        }
    }

    private void drawSinglePoint(Graphics g, Point point) {
        g.fillOval((int) (point.x * koefX) - 3,
                   (int) (HEIGHT - point.y * koefY) - 3, 6, 6);
    }

    private void drawPathLines(Graphics g) {
        int size = path.size();

        for (int i = 0; i < size - 1; ++i) {
            Point first = pointSet.getPoint((path.getNode(i)));
            Point second = pointSet.getPoint((path.getNode(i + 1)));

            g.drawLine((int) (first.x * koefX), (int) (HEIGHT - first.y * koefY),
                       (int) (second.x * koefX), (int) (HEIGHT - second.y * koefY));
        }

        Point first = pointSet.getPoint((path.getNode(size - 1)));
        Point second = pointSet.getPoint((path.getNode(0)));

        g.drawLine((int) (first.x * koefX), (int) (HEIGHT - first.y * koefY),
                  (int) (second.x * koefX), (int) (HEIGHT - second.y * koefY));
    }

    public void setPath(Path newPath) {
        path = newPath;
        repaint();
    }
}
