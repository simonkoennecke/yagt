package de.farbtrommel.yagt.kdtree;

import java.util.ArrayList;

public class Entity extends ArrayList<Pair>{
    private Dimension sDimension = new Dimension();

    public void add(String label, Comparable value) throws Exception {
        add(sDimension.getKey(label), new Pair(label, value));
    }

    public boolean valid() {
        return size() == Dimension.size();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            str.append(this.get(i));
            if (i < (this.size() - 1)) {
                str.append(", ");
            }
        }
        return str.toString();
    }
}
