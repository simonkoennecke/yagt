package de.farbtrommel.yagt.kdtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * kd-Tree for searching with a multi dimension filter.
 *  <code>
 *      DataSet dataSet = new DataSet();
 *      //Define Columns
 *      dataSet.addColumn("x", new Double(1f).getClass().toString());
 *      dataSet.addColumn("y", new Double(1f).getClass().toString());
 *
 *      //Add Row
 *      Entity entity = new Entity();
 *      entity.add("x", Math.random());
 *      entity.add("y", Math.random());
 *
 *      dataSet.addRow(entity);
 *
 *      KdTree kdTree = new KdTree(dataSet);
 *      kdTree.addFilter("x", new Range(0.1, 0.3));
 *
 *      // Contained all Values with x value between 0.1 and 0.3
 *      List<Entity> list = kdTree.search();
 *
 *  </code>
 */
public class KdTree {
    private Vertex mRoot;
    private List<Entity> mResultSet;
    private Entity mSearchEntity;
    private Entity mBestEntity;
    private Double mBestDist;
    private DistanceComparator mDistanceComparator = new DistanceComparator();
    private List<Range<?>> mQuery;

    public KdTree(DataSet set) {
        clearFilter();
        mRoot = new Vertex(set, 0);
    }

    public List<Entity> kNearestNeighbourSearch(Entity entity) {
        mResultSet = new ArrayList<Entity>();
        mSearchEntity = entity;
        mDistanceComparator.setOrigin(entity);
        searchHelperKNN(mRoot);

        mDistanceComparator.setOrigin(mBestEntity);
        Collections.sort(mResultSet, mDistanceComparator);
        return mResultSet;
    }

    private void setBestEntity(Entity entity) {
        mBestEntity = mRoot.getEntity();
        mBestDist = mDistanceComparator.distanceToOrigin(mBestEntity);
    }
    private void searchHelperKNN(Vertex vertex) {
        if (vertex == null || vertex.getEntity() == null) {
            return;
        }
        double[] dist = new double[]{
                mDistanceComparator.distanceToOrigin(vertex.getLowerVertex().getEntity()),
                mDistanceComparator.distanceToOrigin(vertex.getEqualVertex().getEntity()),
                mDistanceComparator.distanceToOrigin(vertex.getUpperVertex().getEntity())
        };
        boolean[] visitedBranches = new boolean[]{false, false, false};
        for (int i = 0; i < dist.length; i++) {
            if (!visitedBranches[i] && dist[i] < mBestDist) {
                Vertex newBestFit = vertex.getVertex(i);
                //change the best fit entity
                setBestEntity(newBestFit.getEntity());
                //Mark branch as viewed
                visitedBranches[i] = true;
                //Search for a better fit.
                searchHelper(newBestFit);
                //Start the loop again
                i = 0;
            }
        }
    }

    /**
     * Search all Entities that fit to the query.
     * @return List of Entities who fit to the query.
     */
    public List<Entity> search() {
        mResultSet = new ArrayList<Entity>();
        searchHelper(mRoot);
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
