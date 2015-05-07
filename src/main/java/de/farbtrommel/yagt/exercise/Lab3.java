package de.farbtrommel.yagt.exercise;

import de.farbtrommel.yagt.Chart;
import de.farbtrommel.yagt.WindowListener;
import de.farbtrommel.yagt.geometry.GrahamScan;
import de.farbtrommel.yagt.geometry.Point2D;
import de.farbtrommel.yagt.geometry.Set;

import java.awt.*;

public class Lab3 extends Frame {
    private final Chart mChartUnsorted = new Chart();
    private final Chart mChartSorted = new Chart();
    private final Chart mChartConvex = new Chart();

    public Lab3() {
        super("Lab 3");
        setSize(Chart.SCREEN_WIDTH * 3, Chart.SCREEN_HEIGHT + 200);                            // Fenstergröße einstellen
        addWindowListener(new WindowListener()); // (notwendig, damit das Fenster geschlossen werden kann)
        setVisible(true);                            // Fenster (inkl. Inhalt) sichtbar machen

        setLayout(new GridLayout(1,3));
        add(mChartUnsorted);
        add(mChartSorted);
        add(mChartConvex);

        Set set = new Set();
        set.addRandomPoints();
        /*
        set.add(new Point2D(1, 3));
        set.add(new Point2D(2, 3));
        set.add(new Point2D(3, 3));
        set.add(new Point2D(2, 5));
        set.add(new Point2D(6, 15));
        */
        //set.add(new Point2D(-25, 15));
        //set.add(new Point2D(-5, 3));

        Set set2 = new Set(set.getAllPoints());
        System.out.println(set);
        mChartUnsorted.add(set);
        set2.sortByPolarCoordinates();
        //set2.sortLexicographical();
        mChartSorted.add(set2);
        Set set3 = new Set(set2.getAllPoints());
        try {
            GrahamScan grahamScan = new GrahamScan(set3);
            mChartConvex.add(grahamScan.getPolygon());
        } catch (Exception e) {

        }

        // important to call this whenever embedding a PApplet.
        // It ensures that the animation thread is started and
        // that other internal variables are properly set.
        mChartUnsorted.init();
        mChartSorted.init();
        mChartConvex.init();
    }

    public static void main(String[] args) {
        new Lab3();
    }
}
