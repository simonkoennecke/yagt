package de.farbtrommel.yagt;

import de.farbtrommel.yagt.geometry.Point2D;
import de.farbtrommel.yagt.geometry.Polygon;
import de.farbtrommel.yagt.geometry.abstraction.Drawable;
import de.farbtrommel.yagt.geometry.abstraction.Point;
import de.farbtrommel.yagt.geometry.helper.DrawSettings;
import processing.core.PApplet;

import java.util.LinkedList;
import java.util.List;

public class Chart extends PApplet {
    public static final int SCREEN_WIDTH = 400, SCREEN_HEIGHT = 400;

    private static final Polygon polygon = new Polygon();

    private static final DrawSettings sDrawSettings = new DrawSettings();

    private final List<Drawable> mDrawables = new LinkedList<Drawable>();

    public void add(Drawable obj) {
        mDrawables.add(obj);
        computeExtrema();
    }

    private void computeExtrema() {
        Point[] extrema = new Point[]{new Point2D(Double.MAX_VALUE, Double.MAX_VALUE),
                new Point2D(Double.MIN_VALUE, Double.MIN_VALUE)};
        for (Drawable d: mDrawables) {
            Point[] pts = d.getExtrema();
            for (Point pt: pts) {
                if (Double.isNaN(pt.getX()) && Double.isNaN(pt.getY())) {
                    continue;
                }

                if (extrema[0].getY() > pt.getY()) {
                    extrema[0].setY(pt.getY());
                } else if (extrema[1].getY() < pt.getY()) {
                    extrema[1].setY(pt.getY());
                }

                if (extrema[0].getX() > pt.getX()) {
                    extrema[0].setX(pt.getX());
                } else if (extrema[1].getX() < pt.getX()) {
                    extrema[1].setX(pt.getX());
                }
            }
        }
        extrema[0] = extrema[0].multiply(0.9);
        extrema[1] = extrema[1].multiply(1.1);
        sDrawSettings.setMin(extrema[0]);
        sDrawSettings.setMax(extrema[1]);
        sDrawSettings.setMove(new Point2D(0, 0
                //(extrema[1].getX() + extrema[0].getX()) / 2,
                //(extrema[1].getY() + extrema[0].getY()) / 2
        ));
        System.out.println(sDrawSettings);
    }

    public void setup() {
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
        background(255);
        loop();
    }

    public void draw() {
        stroke(255);
        if (mousePressed) {
            line(mouseX, mouseY, pmouseX, pmouseY);
        }

        for (Drawable d: mDrawables) {
            d.draw(this);
        }
    }

    public void setChartBackgroundColor(int color) {
        background(color);
    }

    public static DrawSettings getDrawSettings() {
        return sDrawSettings;
    }
}
