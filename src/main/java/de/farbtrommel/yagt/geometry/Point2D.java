package de.farbtrommel.yagt.geometry;

import de.farbtrommel.yagt.geometry.abstraction.Point;
import de.farbtrommel.yagt.geometry.helper.DrawSettings;
import processing.core.PApplet;

public class Point2D implements Point {
    private double mX, mY;

    private final static DrawSettings mDrawSettings = new DrawSettings();
    private final static Point2D mCenter = new Point2D();

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
        //mX -= pt.getX();
        //mY -= pt.getY();
        return new Point2D(getX() - pt.getX(), getY() - pt.getY());
    }

    public Point add(Point pt) {
        //mX += pt.getX();
        //mY += pt.getY();
        return new Point2D(getX() + pt.getX(), getY() + pt.getY());
    }

    public Point add(double val) {
        //mX += val;
        //mY += val;
        return new Point2D(getX() * val, getY() * val);
    }

    public Point multiply(Point pt) {
        //mX *= pt.getX();
        //mY *= pt.getY();
        return new Point2D(getX() * pt.getX(), getY() * pt.getY());
    }

    public Point multiply(double val) {
        //mX *= val;
        //mY *= val;
        return new Point2D(getX() * val, getY() * val);
    }

    public Point divide(Point pt) {
        //mX /= pt.getX();
        //mY /= pt.getY();
        return new Point2D(getX() / pt.getX(), getY() / pt.getY());
    }

    public Point divide(double val) {
        //mX /= val;
        //mY /= val;
        return new Point2D(getX() / val, getY() / val);
    }

    public Point rotate90Degrees() {
        //double x = getX(),y = getY();
        //mX = y;
        //mY = -x;
        return new Point2D(getY(), -getX());
    }

    public Point rotate(double degree) {
        double rad = Math.toDegrees(degree);
        //double x = getX(),y = getY();
        //mX = x * Math.cos(rad) - y * Math.sin(rad);
        //mY = x * Math.sin(rad) + y * Math.cos(rad);
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

    public void draw(PApplet context) {
        context.ellipse(mDrawSettings.getX(this), mDrawSettings.getY(this), 10, 10);
    }

    public void draw(PApplet context, String label) {
        context.text(label, mDrawSettings.getX(this) - 5 , mDrawSettings.getY(this) - 10);
        draw(context);
    }

    public void drawAddVertex(PApplet context) {
        context.vertex(mDrawSettings.getX(this), mDrawSettings.getY(this));
    }
    public void drawLine(PApplet context, Point pt) {
        context.line(
                mDrawSettings.getX(this), mDrawSettings.getY(this),
                mDrawSettings.getX(pt), mDrawSettings.getY(pt)
                );
    }

}
