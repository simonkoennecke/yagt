package de.farbtrommel.yagt.geometry;

import de.farbtrommel.yagt.geometry.abstraction.Point;

/**
 * GrahamScan
 */
public class GrahamScan {
    private Polygon mPolygon;

    public GrahamScan(Polygon polygon) {
        mPolygon = polygon;
        mPolygon.sortByPolarCoordinates();
        computeConvexHull();
    }

    private void computeConvexHull() {
        //http://de.wikipedia.org/wiki/Graham_Scan#Pseudocode
        //TODO: läuft noch nicht!!
        int i = 1;
        while (i < mPolygon.getAllPoints().size()) {
            if (determinant(
                    mPolygon.getPoint(mPolygon.getPredecessor(i)),
                    mPolygon.getPoint(mPolygon.getSuccessor(i)),
                    mPolygon.getPoint(i)) < 0) {
                i++;
            } else {
                mPolygon.remove(i);
                i--;
            }
        }
    }

    private double determinant(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) -
                    (c.getX() - a.getX()) * (b.getY() - a.getY());
    }

    public Polygon getPolygon() {
        return mPolygon;
    }
}
