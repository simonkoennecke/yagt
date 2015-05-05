package de.farbtrommel.yagt;

import processing.core.PApplet;

import java.awt.*;

public class Main extends Frame {

    public static void main(String[] args){

        /*
        int i = 0;

        System.out.println("Points:");
        Point[] points = new Point[]{
                new Point2D(0, 1), new Point2D(1, 0),
                new Point2D(0, 0), new Point2D(1, 1),
                new Point2D(0, 0), new Point2D(0.3, 0.3),
                new Point2D(1,1)
        };
        i = 0;
        for (Point pt: points) {
            System.out.println(++i + ": " + pt);
        }

        System.out.println("\n a)\nOrientated Lines:");
        OrientatedLine2D[] lines = new OrientatedLine2D[]{
                new OrientatedLine2D(points[0], points[0].subtract(points[1])),
                new OrientatedLine2D(points[2], points[2].subtract(points[3]))
        };

        i = 0;
        for (Line line: lines) {
            System.out.println(++i + ": " + line);
        }

        System.out.println("\n b)\nIntersection of the first and second line.");
        Point pt = lines[0].intersection(lines[1]);
        System.out.println(pt);

        System.out.println("\n c)\nOrientated Line where is the Point.");
        System.out.println("Point: " + points[6]);
        System.out.println("Line: " + lines[0]);
        System.out.println("Side: " + ((lines[0].getSide(points[6])) ? "left" : "right"));

        System.out.println("\n d)\nSegmented Lines where is the Point.");
        System.out.println("Segmented Lines:");
        SegmentedLine2D[] segmentedLines = new SegmentedLine2D[]{
                new SegmentedLine2D(points[0], points[1]),
                new SegmentedLine2D(points[4], points[5])
        };
        i = 0;
        for (SegmentedLine2D line: segmentedLines) {
            System.out.println(++i + ": " + line);
        }

        pt = segmentedLines[0].intersection(segmentedLines[1]);
        if (pt == null) {
            System.out.println("The two segmented lines aren't intersected.");
        } else {
            System.out.println("The two segmented lines are intersect at " + pt + ".");
        }
        */

        PApplet.main(new String[] { "de.farbtrommel.yagt.Chart" });

        /*
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
        */
    }
}
