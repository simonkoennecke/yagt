package de.farbtrommel.yagt.geometry.helper;

import de.farbtrommel.yagt.geometry.abstraction.Point;

import java.util.Comparator;

public class PolarCoordinateComparator implements Comparator<Point> {
    private Point mCenter;

    public PolarCoordinateComparator(Point center) {
        mCenter = center;
    }
    @Override
    public int compare(Point a, Point b) {
        //http://stackoverflow.com/questions/6989100/sort-points-in-clockwise-order
        if (a.getX() - mCenter.getX() >= 0 && b.getX() - mCenter.getX() < 0)
            return -1;
        if (a.getX() - mCenter.getX() < 0 && b.getX() - mCenter.getX() >= 0)
            return 1;
        if (a.getX() - mCenter.getX() == 0 && b.getX() - mCenter.getX() == 0) {
            if (a.getY() - mCenter.getY() >= 0 || b.getY() - mCenter.getY() >= 0)
                return (a.getY() > b.getY()) ? -1 : 1;
            return (b.getY() > a.getY()) ? -1 : 1;
        }

        // compute the cross product of vectors (center -> a) x (center -> b)
        double det = (a.getX() - mCenter.getX()) * (b.getY() - mCenter.getY()) -
                (b.getX() - mCenter.getX()) * (a.getY() - mCenter.getY());
        if (det < 0)
            return -1;
        if (det > 0)
            return 1;

        // points a and b are on the same line from the center
        // check which point is closer to the center
        double d1 = (a.getX() - mCenter.getX()) * (a.getX() - mCenter.getX()) +
                (a.getY() - mCenter.getY()) * (a.getY() - mCenter.getY());
        double d2 = (b.getX() - mCenter.getX()) * (b.getX() - mCenter.getX()) +
                (b.getY() - mCenter.getY()) * (b.getY() - mCenter.getY());
        return (d1 > d2) ? -1 : 1;
    }
}
