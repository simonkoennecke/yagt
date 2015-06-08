package de.farbtrommel.yagt.kdtree.search;

import de.farbtrommel.yagt.kdtree.Dimension;
import de.farbtrommel.yagt.kdtree.Entity;
import de.farbtrommel.yagt.kdtree.Pair;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * Comparator for knn-search on the kd-tree.
 * The need by a multi dimension data set with different types for each dimension is
 * to create a measurement to achieve a comparability of the entities.
 */
public class DistanceComparator implements Comparator<Entity> {
    private Entity mOrigin;

    public DistanceComparator() {

    }

    public void setOrigin(Entity origin) {
        mOrigin = origin;
    }

    private Double diff(Pair o1, Pair o2) {
        if (o1.mValue instanceof Double) {
            return ((Double) o1.mValue) - ((Double) o2.mValue);
        } else if (o1.mValue instanceof Integer) {
             return (double) ((Integer) o1.mValue) - ((Integer) o2.mValue);
        } else if (o1.mValue instanceof String) {
            CharSequence[] charAry = new CharSequence[]{
                    java.nio.CharBuffer.wrap(((String) o1.mValue).toCharArray()),
                    java.nio.CharBuffer.wrap(((String) o2.mValue).toCharArray())
            };
            return (double) StringUtils.getLevenshteinDistance(charAry[0], charAry[1]);
        }
        System.out.println("Das darf nicht passieren!!");
        return Double.NaN;
    }

    public Double distanceToOrigin(Entity o, int skipDimension) {
        Double[] distanceVector = new Double[Dimension.size()];
        for (int i = 0; i < Dimension.size(); i++) {
            //Skip dimension to check if other branch can be of interested
            if (skipDimension == i) {
                distanceVector[i] = Double.NaN;
                continue;
            }

            //How to handle not given dimension on the search entity?
            try {
                distanceVector[i] = diff(o.get(i), mOrigin.get(i));
            } catch (Exception e) {
                distanceVector[i] = Double.POSITIVE_INFINITY;
            }
        }

        Double sum = 0.0d;
        for (int i = 0; i < Dimension.size(); i++) {
            if (distanceVector[i] != Double.POSITIVE_INFINITY &&
                distanceVector[i] != Double.NaN) {
                sum += distanceVector[i] * distanceVector[i];
            }
        }

        return sum;
    }

    public Double distanceToOrigin(Entity o) {
        return distanceToOrigin(o, -1);
    }

    @Override
    public int compare(Entity o1, Entity o2) {
        return (int) Math.round(distanceToOrigin(o1) - distanceToOrigin(o2));
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
