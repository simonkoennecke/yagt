package de.farbtrommel.yagt;

import de.farbtrommel.yagt.geometry.GrahamScan;
import de.farbtrommel.yagt.geometry.Point2D;
import de.farbtrommel.yagt.geometry.Polygon;
import processing.core.PApplet;

public class Chart extends PApplet {
    public static final int SCREEN_WIDTH = 400, SCREEN_HEIGHT = 400;

    private static final Polygon polygon = new Polygon();

    public void setup() {
        size(SCREEN_WIDTH, SCREEN_HEIGHT);

        polygon.add(new Point2D(1, 1));
        polygon.add(new Point2D(0, 5));
        polygon.add(new Point2D(4, 12));
        polygon.add(new Point2D(6, 8));
        polygon.add(new Point2D(7, 2));
        polygon.add(new Point2D(4, 1));

        polygon.calcAntipodal();
        System.out.println(polygon);
        GrahamScan grahamScan = new GrahamScan(polygon);
        //polygon.sortByPolarCoordinates();
        //polygon.sortLexicographical();
        //System.out.println(grahamScan.getPolygon());
        System.out.println(polygon);

        System.out.println("List all Antipodal Pairs:");
        System.out.println(polygon.getAntipodalPairs());
        System.out.println("Diameter of Polygon: " + polygon.getDiameter());

        background(255);
        loop();
        draw();
    }

    public void draw() {
        stroke(255);
        if (mousePressed) {
            line(mouseX, mouseY, pmouseX, pmouseY);
        }
        if (polygon.getAllPoints().size() > 0) {
            polygon.draw(this);
        }
    }
}
