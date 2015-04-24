import geometry.*;

public class Main {
    public static void main(String[] args){
        Point[] points = new Point[]{
                new Point2D(0, 1), new Point2D(1, 0),
                new Point2D(0, 0), new Point2D(1, 1)
        };
        for (Point pt: points) {
            System.out.println(pt);
        }

        Line[] lines = new Line[]{
                new OrientatedLine2D(points[0], points[0].subtract(points[1])),
                new OrientatedLine2D(points[2], points[2].subtract(points[3]))
        };
        for (Line line: lines) {
            System.out.println(line);
        }
        Point pt = lines[0].intersection(lines[1]);
        System.out.println(pt);
    }
}
