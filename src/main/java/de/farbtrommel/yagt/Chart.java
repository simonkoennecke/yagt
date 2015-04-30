package de.farbtrommel.yagt;

import de.farbtrommel.yagt.geometry.Point;
import de.farbtrommel.yagt.geometry.Point2D;
import de.farbtrommel.yagt.geometry.Polygon;
import processing.core.PApplet;

import java.util.ArrayList;

public class Chart extends PApplet {
    public static final int SCREEN_WIDTH = 400, SCREEN_HEIGHT = 400;
    private Polygon polygon;

    public void setup() {
        ArrayList<Point> pts = new ArrayList<Point>();
        pts.add(new Point2D(1, 1));
        pts.add(new Point2D(0, 5));
        pts.add(new Point2D(4, 12));
        pts.add(new Point2D(6, 8));
        pts.add(new Point2D(7, 2));
        pts.add(new Point2D(4, 0));


        polygon = new Polygon(pts);
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
        background(0);
    }

    public void draw() {
        stroke(255);
        if (mousePressed) {
            line(mouseX, mouseY, pmouseX, pmouseY);
        }
        polygon.draw(this);
    }
}
