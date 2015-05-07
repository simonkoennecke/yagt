package de.farbtrommel.yagt.geometry;

import de.farbtrommel.yagt.geometry.abstraction.Point;
import de.farbtrommel.yagt.geometry.helper.GrahamComparator;
import de.farbtrommel.yagt.geometry.helper.LexicographicalComparator;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Set {
    private List<Point> mList;

    public Set() {
        mList = new ArrayList<Point>();
    }

    public Set(List<Point> list) {
        mList = list;
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

    public Point get(int i) {
        return mList.get(i);
    }

    public void remove(int i) {
        mList.remove(i);
    }

    public Point getCenter() {
        Point center = new Point2D();
        for (Point pt : mList) {
            center = center.add(pt);
        }
        center = center.divide(mList.size());

        return center;
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

    public void draw(PApplet context) {
        context.beginShape();
        context.fill(200f, 80f);
        context.stroke(200f, 80f);
        for(Point pt: mList) {
            pt.drawAddVertex(context);
        }
        context.endShape(context.CLOSE);


        context.fill(0f, 0f, 255f, 255f);
        context.stroke(0f, 0f, 255f, 255f);
        int i = 0;
        for(Point pt: mList) {
            pt.draw(context, String.valueOf(i) + ": " + pt);
            i++;
        }

        context.fill(255f, 0f, 0f, 255f);
        context.stroke(255f, 0f, 0f, 255f);
        getCenter().draw(context);
    }
}
