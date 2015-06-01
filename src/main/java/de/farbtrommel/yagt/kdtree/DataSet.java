package de.farbtrommel.yagt.kdtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple Data Set Class for creating a kd-Tree.
 * ATTENTION: All DataSets are use the same Dimensions!!
 */
public class DataSet {
    private List<Entity> mDataTable = new ArrayList<Entity>();
    private List<Integer> mIgnoredDimension = new ArrayList<Integer>();

    public DataSet(List<Integer> ignoreDimension) {
        mIgnoredDimension = ignoreDimension;
    }

    public DataSet() {

    }

    /**
     * Split data set in three partition with the pivot element median.
     * @param dimension split data set based on the dimension number.
     * @return Return three data sets.
     *          0: all less then median[dimension]
     *          1: all equal then median[dimension]
     *          2: all higher then median[dimension]
     */
    public DataSet[] split(Integer dimension) {
        Entity median = getMedian(dimension);
        DataSet[] sets = new DataSet[]{
            new DataSet(mIgnoredDimension),
            new DataSet(mIgnoredDimension),
            new DataSet(mIgnoredDimension)
        };
        for (Entity entity: mDataTable) {
            if (entity.equals(median)) {
                continue;
            }
            int comp = median.get(dimension).compareTo(entity.get(dimension).mValue);
            if (comp < 0) {
                sets[0].addRow(entity);
            } else if (comp == 0) {
                sets[1].addRow(entity);
                sets[1].addIgnoreDimension(dimension);
            } else {
                sets[2].addRow(entity);
            }
        }
        return sets;
    }

    public void sort(final Integer dimension) {
        Collections.sort(mDataTable, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                return o1.get(dimension).compareTo(o2.get(dimension).mValue);
            }
        });
    }

    public void addColumn(String label, Object type) {
        Dimension.add(label, type.getClass().toString());
    }
    public void addColumn(String label, String type) {
        Dimension.add(label, type);
    }

    public void addRow(Entity entity) {
        mDataTable.add(entity);
    }

    public Entity getMedian(Integer dimension) {
        //Sorting to select the median
        //Maybe the median of medians algorithm could be better.
        sort(dimension);
        int median = mDataTable.size() / 2;
        return mDataTable.get(median);
    }

    public void addIgnoreDimension(Integer dimension) {
        mIgnoredDimension.add(dimension);
    }

    public List<Integer> getIgnoredDimension() {
        return mIgnoredDimension;
    }

    public int size() {
        return mDataTable.size();
    }

    public Entity get(Integer i) {
        return mDataTable.get(i);
    }

    /**
     * Is the data set valid? When all rows have the same dimension it is a valid data set.
     * @return
     */
    public boolean valid() {
        boolean valid = true;
        for (Entity entity: mDataTable) {
            valid &= entity.valid();
        }

        return valid;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < mDataTable.size(); i++) {
            str.append(mDataTable.get(i));
            if (i < (mDataTable.size() - 1)) {
                str.append(", \n");
            }
        }
        return str.toString();
    }
}
