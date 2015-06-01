package de.farbtrommel.yagt.kdtree;

public class Pair<E extends Comparable> implements Comparable<E>{
    public String mKey;
    public E mValue;

    public Pair(String key, E value){
        mKey = key;
        mValue = value;
    }

    @Override
    public int compareTo(E o) {
        return mValue.compareTo(o);
    }

    public String toString() {
        return String.format("Pair(k: %s, v: %s)", mKey, mValue);
    }


}
