package de.farbtrommel.yagt.kdtree.search;

/**
 * Simple Range object without getters.
 * @param <E>
 */
public class Range<E extends Comparable> {
    public E start;
    public E end;

    public Range(E _start, E _end) {
        start = _start;
        end = _end;
    }

    public String toString() {
        return String.format("Range(%s, %s)", start, end);
    }
}
