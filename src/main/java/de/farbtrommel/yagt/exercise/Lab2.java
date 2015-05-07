package de.farbtrommel.yagt.exercise;

import de.farbtrommel.yagt.geometry.Point2D;
import de.farbtrommel.yagt.geometry.Polygon;
import de.farbtrommel.yagt.geometry.abstraction.Point;

import java.util.ArrayList;


public class Lab2 {
    public static void main() {
        ArrayList<Point> pts = new ArrayList<Point>();
        pts.add(new Point2D(1, 1));
        pts.add(new Point2D(-3, 5));
        pts.add(new Point2D(4, 12));
        pts.add(new Point2D(6, 8));
        pts.add(new Point2D(7, 2));
        pts.add(new Point2D(4, 0));


        Polygon polygon = new Polygon(pts);
        polygon.calcAntipodal();
        System.out.println("All antipodal Pairs:");
        System.out.println(polygon.getAntipodalPairs());
        System.out.println("Diameter of Polygon: " + polygon.getDiameter());
    }
}
