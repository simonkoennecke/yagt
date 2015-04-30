package de.farbtrommel.yagt.geometry;

import de.farbtrommel.yagt.Chart;

public class DrawSettings {
    private Point2D mMin = new Point2D(-10, -10),
            mMax = new Point2D(20, 20),
            mMove = new Point2D(10, 10);

    private double mXDelta, mYDelta;

    public DrawSettings() {
        mXDelta = Chart.SCREEN_WIDTH / (mMax.getX() - mMin.getX());
        mYDelta = Chart.SCREEN_HEIGHT / (mMax.getY() - mMin.getY());
    }

    public float getX(Point pt) {
        return (float) ((pt.getX() + mMove.getX()) * mXDelta);
    }

    public float getY(Point pt) {
        return (float) ((pt.getY() + mMove.getY()) * mYDelta);
    }

    public void setMin(Point2D pt) {
        mMin = pt;
    }

    public void setMax(Point2D pt) {
        mMax = pt;
    }
}
