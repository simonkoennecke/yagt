package de.farbtrommel.yagt.geometry.abstraction;

import de.farbtrommel.yagt.Chart;

public interface Drawable {
    public void draw(Chart context);
    public void draw(Chart context, String label);
    public Point[] getExtrema();

    /*void draw(PApplet context);
    void draw(PApplet context, String label);
    void drawLine(PApplet context, Point pt);
    void drawAddVertex(PApplet context);
    */
}
