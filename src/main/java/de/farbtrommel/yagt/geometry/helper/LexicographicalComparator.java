package de.farbtrommel.yagt.geometry.helper;

import de.farbtrommel.yagt.geometry.abstraction.Point;

import java.util.Comparator;

public class LexicographicalComparator implements Comparator<Point> {

    
    public int compare(Point a, Point b) {
        if (a.getX() > b.getX()) {
            return 1;
        } else if (a.getX() == b.getX()) {
            return (a.getY() >= b.getY()) ? -1 : 1;
        }
        return -1;
    }
}
