package geometry;

public class SegmentedLine2D {
    private Point mStart, mEnd;
    private OrientatedLine2D mLine;

    public SegmentedLine2D(Point start, Point end) {
        mStart = start;
        mEnd = end;
        mLine = new OrientatedLine2D(mStart, mStart.subtract(mEnd));
    }

    public Point intersection(SegmentedLine2D segment) {
        Point pt = segment.getLine().intersection(getLine());
        if (isInSegment(pt) && segment.isInSegment(pt)) {
            return pt;
        }

        return null;
    }

    public Point intersection(Line line) {
        Point pt = line.intersection(getLine());
        if (isInSegment(pt)) {
            return pt;
        }

        return null;
    }

    public boolean isInSegment(Point pt) {
        //distance(a,c) + distance(c,b) == distance(a,b)
        return (mStart.distance(pt) + pt.distance(mEnd)) == mStart.distance(mEnd);
    }

    public OrientatedLine2D getLine() {
        return mLine;
    }
}
