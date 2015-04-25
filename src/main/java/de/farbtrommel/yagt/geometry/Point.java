package de.farbtrommel.yagt.geometry;

public interface Point {
    void setPoint(double x, double y);
    void setPoint(Point pt);
    double getX();
    double getY();
    Point normalize();
    Point subtract(Point pt);
    Point add(Point pt);
    Point add(double val);
    Point multiply(Point pt);
    Point multiply(double val);
    Point rotate90Degrees();
    double dotProduct(Point pt);
    double norm();
    double distance(Point pt);
}
