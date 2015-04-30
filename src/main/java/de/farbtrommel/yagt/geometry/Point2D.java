package de.farbtrommel.yagt.geometry;

import processing.core.PApplet;

public class Point2D implements Point, Drawable {
    private double mX, mY;

    Point2D(){

    }
    Point2D(Point pt){
        setPoint(pt);
    }
    public Point2D(double x, double y){
        setPoint(x, y);
    }

    @Override
    public void setPoint(double x, double y) {
        mX = x;
        mY = y;
    }

    @Override
    public void setPoint(Point pt) {
        mX = pt.getX();
        mY = pt.getY();
    }

    @Override
    public double getX() {
        return mX;
    }

    @Override
    public double getY() {
        return mY;
    }

    @Override
    public Point normalize() {
        double norm = norm();
        mX /= norm;
        mY /= norm;
        return this;
    }

    @Override
    public Point subtract(Point pt) {
        return new Point2D(getX() - pt.getX(), getY() - pt.getY());
    }

    @Override
    public Point add(Point pt) {
        return new Point2D(getX() + pt.getX(), getY() + pt.getY());
    }

    @Override
    public Point add(double val) {
        mX += val;
        mY += val;
        return this;
    }

    @Override
    public Point multiply(Point pt) {
        return new Point2D(getX() * pt.getX(), getY() * pt.getY());
    }

    @Override
    public Point multiply(double val) {
        return new Point2D(getX() * val, getY() * val);
    }

    @Override
    public Point rotate90Degrees() {
        return new Point2D(getY(), -getX());
    }

    @Override
    /**
     * @return Return Angle in Degree.
     */
    public double angle(Point pt) {
        return Math.toDegrees(Math.acos(dotProduct(pt)/(norm() * pt.norm())));
    }

    @Override
    public Point rotate(double degree) {
        double rad = Math.toRadians(degree);
        return new Point2D( getX() * Math.cos(rad) - getY() * Math.sin(rad),
                            getX() * Math.sin(rad) + getY() * Math.cos(rad));
    }

    @Override
    public double dotProduct(Point pt) {
        return getX()*pt.getX()+getY()*pt.getY();
    }

    @Override
    public double norm() {
        return Math.sqrt(getX()*getX()+getY()*getY());
    }

    @Override
    public double distance(Point pt) {
        return Math.sqrt(Math.pow(getX() - pt.getX(), 2) + Math.pow(getY() - pt.getY(), 2));
    }

    @Override
    public String toString(){
        return "Pt2D(x: " + getX() + ", y: " + getY()+ ")";
    }

    @Override
    public void draw(PApplet context) {
        context.point((float) getX(), (float) getY());
    }
}
