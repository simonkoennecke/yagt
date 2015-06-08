package de.farbtrommel.yagt.kdtree.search;

import de.farbtrommel.yagt.kdtree.*;

import java.util.ArrayList;
import java.util.List;

public class OrthogonalSearch {
    private List<Entity> mResultSet;
    private List<Range<?>> mQuery;

    public OrthogonalSearch() {
        clearFilter();
    }

    /**
     * Search all Entities that fit to the query.
     * @return List of Entities who fit to the query.
     */
    public List<Entity> search(Vertex root) {
        mResultSet = new ArrayList<Entity>();
        searchHelper(root);
        return mResultSet;
    }

    /**
     * Walk through the tree and select the right entities.
     * @param vertex Current Vertex for the retrieval process.
     */
    public void searchHelper(Vertex vertex) {
        //The previous vertex was a leaf.
        if (vertex == null || vertex.getEntity() == null) {
            return;
        }

        Integer dim = vertex.getDimension();
        Range range = getRange(dim);
        Pair pair = vertex.getEntity().get(dim);

        if (isVertexInRange(vertex)) {
            mResultSet.add(vertex.getEntity());
        }

        //If no Range given, go to all three partitions
        int c = 0;
        if (range != null) {
            c = compareRange(range, pair);
        }

        //When Pair is in the Range of selected Dimension (dim) we need to visited all sub partitions.
        if (c == 0) {
            searchHelper(vertex.getLowerVertex());
            searchHelper(vertex.getEqualVertex());
            searchHelper(vertex.getUpperVertex());
            // When pair is lower than the range we only need to retrieval the left tree
        } else if (c < 0) {
            searchHelper(vertex.getLowerVertex());
            // When pair is higher than the range we only need to retrieval the right tree
        } else {
            searchHelper(vertex.getUpperVertex());
        }
    }

    /**
     * Is Pair in given Range?
     * @param range
     * @param pair
     * @return -1: under the range, 0: In Range, 1: over the range
     */
    private int compareRange(Range range, Pair pair) {
        if (range.start.compareTo(pair.mValue) > 0) {
            return -1;
        } else if (range.start.compareTo(pair.mValue) <= 0 &&
                range.end.compareTo(pair.mValue) >= 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * The function check if the vertex fulfill all filter parameters.
     * @param vertex
     * @return true: is in Range, false: isn't in Range
     */
    private boolean isVertexInRange(Vertex vertex) {
        boolean isInRange = true;
        //Check if all Dimension are suitable for query
        for (int i = 0; i < Dimension.size(); i++) {
            Range range = getRange(i);
            Pair pair = vertex.getEntity().get(i);
            //Range not in Query;
            if (range == null) {
                continue;
            }

            if (compareRange(range, pair) == 0) {
                isInRange &= true;
            } else {
                //isInRange &= false;
                return false;
            }
        }

        return isInRange;
    }

    /**
     * Get the Range of Dimensions i, if not in list return null.
     * @param i Number of Dimension
     * @return Range or null of the Dimension i.
     */
    public Range getRange(Integer i) {
        Range range = null;
        try {
            range = mQuery.get(i);
        } catch (Exception e) {
            //
        }
        return range;
    }
    public void clearFilter() {
        mQuery = new ArrayList<Range<?>>();
        for (int i = 0; i < Dimension.size(); i++) {
            mQuery.add(i, null);
        }
    }

    public void addFilter(String label, Range<?> range) throws Exception {
        mQuery.add(Dimension.getKey(label), range);
    }

    public List<Range<?>> getFilter() {
        return mQuery;
    }
}
