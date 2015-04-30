package de.farbtrommel.yagt.geometry;

import processing.core.PApplet;

import java.util.ArrayList;

//http://www.seas.gwu.edu/~simhaweb/alg/lectures/module1/module1.html

public class Polygon implements Drawable{
    private ArrayList<Point> mList;
    private ArrayList<ArrayList<Integer>> mAntipodal;
    private int mMaxPt = -1, mMinPt = -1;
    private int[] mMaxAntipodal;

    public Polygon() {
        mList = new ArrayList<Point>();
    }

    public Polygon(ArrayList<Point> list) {
        mList = list;
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

    public Point getPoint(int index) {
        return mList.get(index);
    }

    private int[] findExtrema() {
        Point mMin, mMax;
        mMin = mMax = mList.get(0);
        for (int i = 1; i < mList.size(); i++) {
            if (mMin.getY() > mList.get(i).getY()) {
                mMinPt = i;
                mMin = mList.get(i);
                continue;
            }

            if (mMax.getY() < mList.get(i).getY()) {
                mMaxPt = i;
                mMax = mList.get(i);
                continue;
            }
        }
        return new int[]{mMinPt, mMaxPt};
    }

    private void initAntiPodalList() {
        mAntipodal = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < mList.size(); i++) {
            mAntipodal.add(new ArrayList<Integer>());
        }
    }
    private void addAntiPodal(int i, int j) {
        mAntipodal.get(i).add(j);
        mAntipodal.get(j).add(i);
    }

    public void calcAntipodal() {
        initAntiPodalList();
        findExtrema();

        int i = mMaxPt, j = mMinPt, cnt = 0;
        Point[] vec = new Point[]{
                new Point2D(1, 0),
                new Point2D(-1, 0),
                getPoint(getSuccessor(i)).subtract(getPoint(i)),
                getPoint(getSuccessor(j)).subtract(getPoint(j))
        };
        double[] angle = new double[]{
                vec[2].angle(vec[0]),
                vec[3].angle(vec[1])
        };

        do {
            //System.out.printf("%d: top(%d; %.1f), bottom(%d; %.3f)%n", cnt, i, angle[0], j, angle[1]);

            //On which Edge flash the caliper first?
            if (angle[0] > angle[1]) {
                //Lower Bound flash first
                j = getSuccessor(j);
                vec[1] = vec[3];
                vec[0] = vec[3].multiply(-1);
                vec[3] = getPoint(getSuccessor(j)).subtract(getPoint(j));
            } else {
                //Upper Bound flash first
                i = getSuccessor(i);
                vec[0] = vec[2];
                vec[1] = vec[2].multiply(-1);
                vec[2] = getPoint(getSuccessor(i)).subtract(getPoint(i));
            }
            addAntiPodal(i, j);

            angle[0] = vec[2].angle(vec[0]);
            angle[1] = vec[3].angle(vec[1]);
        } while (i != mMinPt || j != mMaxPt);
    }

    public String getAntipodalPairs() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < mAntipodal.size(); i++) {
            str.append(i + ": ");
            for (int j = 0; j < mAntipodal.get(i).size(); j++) {
                str.append(mAntipodal.get(i).get(j) + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }
    /**
     * ATTENTION: The Method calcAntipodal need to run first!!!
     * @return get diameter of a convex polygon.
     */
    public double getDiameter(){
        double max = -1, tmp;
        for (int i = 0; i < mAntipodal.size(); i++) {
            for (int j = 0; j < mAntipodal.get(i).size(); j++) {
                tmp = getPoint(i).distance(getPoint(mAntipodal.get(i).get(j)));
                if (max < tmp) {
                    max = tmp;
                    mMaxAntipodal = new int[]{i, mAntipodal.get(i).get(j)};
                }
            }
        }
        return max;
    }

    @Override
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
        for(Point pt: mList) {
            pt.draw(context);
        }

        calcAntipodal();
        double max = getDiameter();
        context.fill(255f, 0f, 0f, 255f);
        context.stroke(255f, 0f, 0f, 255f);
        for(Point pt: mList) {
            getPoint(mMaxAntipodal[0]).drawLine(context, getPoint(mMaxAntipodal[1]));
            getPoint(mMaxAntipodal[0]).draw(context);
            getPoint(mMaxAntipodal[1]).draw(context);
        }

    }
}
