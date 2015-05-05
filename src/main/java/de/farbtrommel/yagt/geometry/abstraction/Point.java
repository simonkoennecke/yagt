package de.farbtrommel.yagt.geometry.abstraction;

import processing.core.PApplet;

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
    Point divide(Point pt);
    Point divide(double val);
    Point rotate90Degrees();
    Point rotate(double degree);
    double angle(Point pt);
    double dotProduct(Point pt);
    double norm();
    double distance(Point pt);
    void draw(PApplet context);
    void draw(PApplet context, String label);
    void drawLine(PApplet context, Point pt);
    void drawAddVertex(PApplet context);
}
