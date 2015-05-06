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
    	
    	if(a.getY() == 0 || b.getY() == 0){
    		if(a.getY() != 0 || b.getY() != 0){ //XOR
    			if(a.getY() == 0){
    				return a.getX() < 0 ? 1 : -1;
    			}else{
    				return b.getX() < 0 ? -1 : 1;
    			}
    		}else{ //Both == 0
    			return (a.getX() > b.getX()) ? 1 : -1;
    		}
    	}

    	return (a.getX() / a.getY()) >= (b.getX() / b.getY()) ? -1 : 1;
    }
}
