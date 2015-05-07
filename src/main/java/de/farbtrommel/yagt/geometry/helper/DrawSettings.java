package de.farbtrommel.yagt.geometry.helper;

import de.farbtrommel.yagt.Chart;
import de.farbtrommel.yagt.geometry.Point2D;
import de.farbtrommel.yagt.geometry.abstraction.Point;

public class DrawSettings {
    private Point mMin = new Point2D(-20, -20),
            mMax = new Point2D(20, 20),
            mMove = new Point2D(20, 20);

    private double mXDelta, mYDelta, mYMax;

    public DrawSettings() {

    }

    private void computeDelta() {
        mXDelta = Chart.SCREEN_WIDTH / (mMax.getX() + mMin.getX());
        mYDelta = Chart.SCREEN_HEIGHT / (mMax.getY() + mMin.getY());
        mYMax = mMax.getY();
    }

    public float getX(Point pt) {
        return (float) ((pt.getX() + mMove.getX()) * mXDelta);
    }

    public float getY(Point pt) {
        return (float) ((pt.getY() * -1 + mYMax + mMove.getY()) * mYDelta);
    }

    public void setMin(Point pt) {
        mMin = pt;
        computeDelta();
    }

    public void setMax(Point pt) {
        mMax = pt;
        computeDelta();
    }

    public void setMove(Point pt) {
        mMove = pt;
    }

    public String toString() {
        return "Min: " + mMin + ", Max: " + mMax + ", Mid: " + mMove;
    }
}
