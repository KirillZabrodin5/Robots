package view;

import java.awt.*;
import java.awt.geom.AffineTransform;
//сомнительно, но окэй
public class DrawEntity {
    private static int round(double value)
    {
        return (int)(value + 0.5);
    }

    private static void fillOval(Graphics g, double centerX, double centerY, int diam1, int diam2)
    {
        g.fillOval((int) (centerX - diam1 / 2), (int) (centerY - diam2 / 2), diam1, diam2);
    }

    private static void drawOval(Graphics g, int centerX, int centerY, int diam1, int diam2)
    {
        g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
    }

    public static void drawRobot(Graphics2D g, double x, double y, double direction)
    {
        int x1 = round(x);
        int y1 = round(y);
        AffineTransform t = AffineTransform.getRotateInstance(direction, x, y);
        g.setTransform(t);
        g.setColor(Color.MAGENTA);
        fillOval(g, x, y, 30, 10);
        g.setColor(Color.BLACK);
        drawOval(g, x1, y1, 30, 10);
        g.setColor(Color.WHITE);
        fillOval(g, x1  + 10, y, 5, 5);
        g.setColor(Color.BLACK);
        drawOval(g, x1  + 10, y1, 5, 5);
    }

    public static void drawTarget(Graphics2D g, double x, double y)
    {
        int x1 = round(x);
        int y1 = round(y);
        AffineTransform t = AffineTransform.getRotateInstance(0, 0, 0);
        g.setTransform(t);
        g.setColor(Color.GREEN);
        fillOval(g, x1, y1, 5, 5);
        g.setColor(Color.BLACK);
        drawOval(g, x1, y1, 5, 5);
    }
}