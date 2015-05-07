package de.farbtrommel.yagt.geometry.abstraction;

import de.farbtrommel.yagt.Chart;

public interface Point extends Drawable{
    void setPoint(double x, double y);
    void setPoint(Point pt);
    void setX(double x);
    void setY(double y);
    double getX();
    double getY();
    Point normalize();
    Point subtract(Point pt);
    Point add(Point pt);
    Point add(double val);
    Point multiply(Point pt);
    Point multiply(double val);
    Point divide(Point pt);
    Point divide(double val);
    Point rotate90Degrees();
    Point rotate(double degree);
    double angle(Point pt);
    double dotProduct(Point pt);
    double norm();
    double distance(Point pt);
    void drawLine(Chart context, Point pt);
    void drawAddVertex(Chart context);
}
