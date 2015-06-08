package de.farbtrommel.yagt.kdtree;

import java.util.HashMap;
import java.util.List;

/**
 * Static Object to handle the dimension of the data set.
 * To make it easy every data set have the exact same dimension.
 */
public class Dimension {
    private static HashMap<String, Integer> mLabelToKey = new HashMap<String, Integer>();
    private static HashMap<Integer, String> mKeyToLabel = new HashMap<Integer, String>();
    private static HashMap<String, String> mLabelToDataType = new HashMap<String, String>();

    public Dimension() {

    }

    public static void add(String label, String type) {
        int key = mLabelToKey.size();
        mLabelToKey.put(label, key);
        mKeyToLabel.put(key, label);
        mLabelToDataType.put(label, type);
    }

    public static Integer getKey(String label) throws Exception {
        if (!mLabelToKey.containsKey(label)) {
            throw new Exception("Error Label need to defined!");
        }
        return mLabelToKey.get(label);
    }

    public static String getType(String label) {
        return mLabelToDataType.get(label);
    }

    public static Integer getNextKey(List<Integer> ignoreList, Integer i) {
        //when all dimension are equal
        if (mLabelToDataType.size() == Dimension.size()) {
            return i;
        }

        int next = (i+1) % mLabelToDataType.size();
        while (ignoreList.contains(next)) {
            next = ++next % mLabelToDataType.size();
        }
        return next;
    }

    public static int size() {
        return mLabelToKey.size();
    }

    public static String getLabel(int i) {
        return mKeyToLabel.get(i);
    }
}
