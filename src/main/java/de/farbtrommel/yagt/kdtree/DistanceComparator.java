package de.farbtrommel.yagt.kdtree;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Entity> {
    private Entity mOrigin;



    public DistanceComparator() {

    }

    public DistanceComparator(Entity origin) {
        mOrigin = origin;
    }

    public void setOrigin(Entity origin) {
        mOrigin = origin;
    }

    private Double diff(Pair o1, Pair o2) {
        if (o1.mValue instanceof Double || o1.mValue instanceof Double) {
             return ((Double) o1.mValue) - ((Double) o2.mValue);
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
            if (skipDimension == i) {
                continue;
            }
            distanceVector[i] = diff(o.get(i), mOrigin.get(i));
        }
        Double sum = 0.0d;
        for (int i = 0; i < Dimension.size(); i++) {
            sum += distanceVector[i] * distanceVector[i];
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
