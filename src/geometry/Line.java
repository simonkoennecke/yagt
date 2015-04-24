package geometry;

public interface Line {
    Point intersection(Line line);
    Point getLocationVector();
    Point getAnotherPointOnLine();
    Point getNormalVector();
    double getDistance(Point pt);
}
