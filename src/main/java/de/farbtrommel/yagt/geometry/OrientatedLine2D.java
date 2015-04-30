package de.farbtrommel.yagt.geometry;

import processing.core.PApplet;

/**
 * 2-Dimensional Line in Hesse normal form.
 */
public class OrientatedLine2D implements Line, Drawable{
    /**
     * mP = location vector
     * mQ = another vector on line
     * mR = direction vector
     * mN = normal vector
     */
    private Point mP, mQ, mR, mN;
    private double mD;

    /**
     *
     * @param p location vector
     * @param r direction vector
     */
    public OrientatedLine2D(Point p, Point r){
        mP = p;
        mR = r;
        mN = r.rotate90Degrees().normalize();
        mD = p.dotProduct(mN);
    }

    public Point intersection(OrientatedLine2D line) {
        // We need two points of each line.
        Point p1 = getLocationVector();
        Point p2 = getAnotherPointOnLine();
        Point p3 = line.getLocationVector();
        Point p4 = line.getAnotherPointOnLine();

        //Please see for the formula here:
        //http://en.wikipedia.org/wiki/Line%E2%80%93line_intersection#Given_two_points_on_each_line

        //When this is zero the both lines are parallel.
        if (((p1.getX() - p2.getX())*(p3.getY() - p4.getY())) - ((p1.getY() - p2.getY()) * (p3.getX() - p4.getX())) == 0) {
            return null;
        }

        double x, y, z;
        //Divider
        z = ((p1.getX() - p2.getX()) * (p3.getY() - p4.getY())) -
                ((p1.getY() - p2.getY()) * (p3.getX() - p4.getX()));

        x = (((p1.getX() * p2.getY()) - (p1.getY() * p2.getX())) * (p3.getX() - p4.getX())) -
                (p1.getX() - p2.getX()) * (p3.getX() * p4.getY() - p3.getY() * p4.getX());
        x /= z;
        y = (p1.getX() * p2.getY() - p1.getY() * p2.getX()) * (p3.getY() - p4.getY()) -
                (p1.getY() - p2.getY()) * (p3.getX() * p4.getY() - p3.getY() * p4.getX());
        y /= z;
        return new Point2D(x, y);
    }

    
    public Point intersection(Line line) {
        OrientatedLine2D l = new OrientatedLine2D(line.getLocationVector(),
                line.getLocationVector().subtract(line.getAnotherPointOnLine()));
        return intersection(l);
    }

    public Point getAnotherPointOnLine() {
        if (mQ == null) {
            mQ = mP.add(mR);
        }
        return mQ;
    }


    
    public Point getLocationVector() {
        return mP;
    }

    
    public Point getNormalVector() {
        return mN;
    }

    
    /**
     * Get Distance of the Point to the line.
     */
    public double getDistance(Point pt) {
        return Math.abs(mN.dotProduct(pt) - mD);
    }

    /**
     * Get the side of the point related to the line.
     * @param pt Where is this point?
     * @return true => left side, false => right side
     */
    public boolean getSide(Point pt) {
        double d = mN.dotProduct(pt) - mD;
        if (d > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "OrientatedLine2D(p: " + getLocationVector() +
                ", q: " + getAnotherPointOnLine() +
                ", r: " + mR +
                ", n: " + getNormalVector() + ")";
    }

    @Override
    public void draw(PApplet context) {
        //TODO: implement draw function
    }
}
