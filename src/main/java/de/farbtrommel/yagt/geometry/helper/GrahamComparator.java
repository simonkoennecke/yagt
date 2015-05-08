package de.farbtrommel.yagt.geometry.helper;

import de.farbtrommel.yagt.geometry.abstraction.Point;

import java.util.Comparator;

public class GrahamComparator implements Comparator<Point> {
    private Point mCenter;

    public GrahamComparator(Point center) {
        mCenter = center;
    }
   
    public int compare(Point a, Point b) {
    	//Let 'center' be the new origin:
    	a = a.subtract(mCenter);
    	b = b.subtract(mCenter);
    	
    	// mind. 1 y-Koordinate == 0:
    	if (a.getY() == 0 || b.getY() == 0) {
    		if (a.getY() != 0 || b.getY() != 0) { //XOR
    			//da mCenter "linkestes/unterstes" Element, Y==0 nur auf x > 0 möglich.
    			return (a.getY() == 0) ? -1 : 1;
    		} 
    		//Both == 0
    		return (a.getX() > b.getX()) ? 1 : -1;
    	}

    	// y-Koordinate in beiden Fällen != 0:
    	double d1 = a.getX() / a.getY(), d2 = b.getX() / b.getY();
    	
    	if (d1 == d2) {
    		return a.getX() * a.getX() + a.getY() * a.getY() < b.getX() * b.getX() + b.getY() * b.getY() ? -1 : 1;
    	}
        //return (int) (delta * -1);
        return (d1 < d2) ? 1 : -1;

    }
}
