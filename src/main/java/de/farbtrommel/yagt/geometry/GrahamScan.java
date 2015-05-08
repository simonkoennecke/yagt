package de.farbtrommel.yagt.geometry;

import de.farbtrommel.yagt.geometry.abstraction.Point;
import de.farbtrommel.yagt.geometry.helper.GrahamComparator;
import de.farbtrommel.yagt.geometry.helper.PolarCoordinateComparator;

/**
 * GrahamScan
 */
public class GrahamScan {
    private Set mSet;

    public GrahamScan(Set set) {
        mSet = set;
        mSet.sort(new GrahamComparator(set.getMinYExtrema()));
        computeConvexHull();
    }

    /**
     * Source: http://de.wikipedia.org/wiki/Graham_Scan#Pseudocode
     */
    private void computeConvexHull() {
        int i = 1;
        while (i < mSet.getAllPoints().size()) {
            if (determinant(
                    mSet.get(mSet.getPredecessor(i)),
                    mSet.get(mSet.getSuccessor(i)),
                    mSet.get(i)) < 0) {
                i++;
            } else {
                mSet.remove(i);
                i--;
            }
        }
    }

    /**
     * @return AB zu C: 0 = collinear, 0 < right, 0 > left
     */
    private static double determinant(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY()) -
                    (c.getX() - a.getX()) * (b.getY() - a.getY());
    }

    public Polygon getPolygon() {
        return new Polygon(mSet.getAllPoints());
    }
}
