package de.farbtrommel.yagt.geometry;

import de.farbtrommel.yagt.Chart;
import de.farbtrommel.yagt.geometry.abstraction.Drawable;
import de.farbtrommel.yagt.geometry.abstraction.Point;
import de.farbtrommel.yagt.geometry.helper.GrahamComparator;
import de.farbtrommel.yagt.geometry.helper.LexicographicalComparator;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Set implements Drawable {
    private List<Point> mList = new ArrayList<Point>();

    public Set() {

    }

    public Set(List<Point> list) {
        //Clone List
        for (Point pt: list) {
            mList.add(pt);
        }
    }

    public void addRandomPoints() {
        double x, y;
        for (int i = 0; i < 11; i++) {
            x = Math.random() * 12;
            y = Math.random() * 12;
            add(new Point2D(x, y));
        }
    }

    public List<Point> getAllPoints() {
        return mList;
    }

    public void add(Point pt) {
        mList.add(pt);
    }

    public void remove(Point pt) {
        mList.remove(pt);
    }

    public int getPredecessor (int i) {
        i -= 1;
        if (i == -1) {
            i = mList.size() - 1;
        }
        return i;
    }

    public int getSuccessor(int i) {
        i += 1;
        i %= mList.size();
        return i;
    }

    public Point get(int i) {
        return mList.get(i);
    }

    public void remove(int i) {
        if (i > 0 && i < mList.size()) {
            mList.remove(i);
        }
    }

    public Point getCenter() {
        Point center = new Point2D();
        for (Point pt : mList) {
            center = center.add(pt);
        }
        center = center.divide(mList.size());

        return center;
    }
    public Point[] getExtrema() {
        return getExtrema(mList);
    }

    public static Point[] getExtrema(List<Point> list) {
        Point[] extrema = new Point[]{new Point2D(Double.MAX_VALUE, Double.MAX_VALUE),
                new Point2D(Double.MIN_VALUE, Double.MIN_VALUE)};
        for (Point pt : list) {
            if (extrema[0].getY() > pt.getY()) {
                extrema[0].setY(pt.getY());
            } else if (extrema[1].getY() < pt.getY()) {
                extrema[1].setY(pt.getY());
            }

            if (extrema[0].getX() > pt.getX()) {
                extrema[0].setX(pt.getX());
            } else if (extrema[1].getX() < pt.getX()) {
                extrema[1].setX(pt.getX());
            }
        }

        return extrema;
    }

    public Point getMinYExtrema() {
        Point min = null;
        for (Point pt : mList) {
            if (min == null ||
                    min.getY() > pt.getY() ||
                    (min.getY() == pt.getY() && min.getX() > pt.getX())
                    ) {
                min = pt;
            }
        }

        return min;
    }

    public void sort(Comparator<Point> comparator) {
        Collections.sort(mList, comparator);
    }
    public void sortLexicographical() {
        sort(new LexicographicalComparator());
    }
    public void sortByPolarCoordinates() {
        Point center = getMinYExtrema();
        sort(new GrahamComparator(center));
    }

    public void draw(Chart context) {

        context.fill(0f, 0f, 255f, 255f);
        context.stroke(0f, 0f, 255f, 255f);
        int i = 0;
        for(Point pt: mList) {
            pt.draw(context, String.valueOf(i));
            i++;
        }

        context.fill(255f, 0f, 0f, 255f);
        context.stroke(255f, 0f, 0f, 255f);
        getCenter().draw(context);
    }

    public void draw(Chart context, String label) {
        draw(context);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Set(" + mList.size() + ":[");
        for (Point pt : mList) {
            str.append(pt);
            str.append(", ");
        }
        str.append("])");
        return str.toString();
    }
}
