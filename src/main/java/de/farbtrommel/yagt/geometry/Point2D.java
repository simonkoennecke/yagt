package de.farbtrommel.yagt.geometry;

public class Point2D implements Point {
    private double mX, mY;

    Point2D(){

    }
    Point2D(Point pt){
        setPoint(pt);
    }
    public Point2D(double x, double y){
        setPoint(x, y);
    }

    public void setPoint(double x, double y) {
        mX = x;
        mY = y;
    }

    public void setPoint(Point pt) {
        mX = pt.getX();
        mY = pt.getY();
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }

    public Point normalize() {
        double norm = norm();
        mX /= norm;
        mY /= norm;
        return this;
    }

    public Point subtract(Point pt) {
        return new Point2D(getX() - pt.getX(), getY() - pt.getY());
    }

    public Point add(Point pt) {
        return new Point2D(getX() + pt.getX(), getY() + pt.getY());
    }

    public Point add(double val) {
        mX += val;
        mY += val;
        return this;
    }

    public Point multiply(Point pt) {
        return new Point2D(getX() * pt.getX(), getY() * pt.getY());
    }

    public Point multiply(double val) {
        return new Point2D(getX() * val, getY() * val);
    }

    public Point rotate90Degrees() {
        return new Point2D(getY(), -getX());
    }

    public Point rotate(double degree) {
        double rad = Math.toDegrees(degree);
        return new Point2D(
                getX() * Math.cos(rad) - getY() * Math.sin(rad),
                getX() * Math.sin(rad) + getY() * Math.cos(rad)
        );
    }

    public double angle(Point pt) {
        return Math.toDegrees(Math.acos(dotProduct(pt) / (norm() * pt.norm())));
    }

    public double dotProduct(Point pt) {
        return getX() * pt.getX() + getY() * pt.getY();
    }

    public double norm() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    public double distance(Point pt) {
        return Math.sqrt(Math.pow(getX() - pt.getX(), 2) + Math.pow(getY() - pt.getY(), 2));
    }

    public String toString(){
        return "Pt2D(x: " + getX() + ", y: " + getY()+ ")";
    }
}
