package de.farbtrommel.yagt.kdtree;

import java.util.List;

public class Vertex {
    /**
     * Tree with lower values as mEntity[mDimension].
     */
    private Vertex mVertexLower = null;
    /**
     * Tree with equal values as mEntity[mDimension].
     */
    private Vertex mVertexEqual = null;
    /**
     * Tree with higher values as mEntity[mDimension].
     */
    private Vertex mVertexUpper = null;
    /**
     * The entity of the vertex.
     */
    private Entity mEntity = null;
    /**
     * The used dimension of the level of the tree.
     */
    private Integer mDimension = null;
    /**
     * To prevent to create a now (k-1)d-Tree.
     * Therefore, all Dimension who are not imported for the subtree will be stored in that list.
     */
    private List<Integer> mIgnoredDimension = null;

    /**
     * Create a kd-tree based on the input.
     * @param set Data Set to create the (sub-)tree of kd-tree
     * @param dimension The dimension of the current level of tree.
     */
    public Vertex(DataSet set, Integer dimension) {
        //termination condition
        if (set.size() == 0) {
            return;
        }
        mDimension = dimension;
        mIgnoredDimension = set.getIgnoredDimension();
        mEntity = set.getMedian(mDimension);

        //Building subtree
        DataSet[] splitDataSet = set.split(dimension);
        /*
        System.out.printf("Split Data Set (%d, %d, %d) %n",
                splitDataSet[0].size(),
                splitDataSet[1].size(),
                splitDataSet[2].size()
                );
        */
        /** TODO: nextDimension kann irgendwann kein wert zurück lieferen,
         * da mIgnoredDimension alle Dimensionen umfässt
         * Warum?!?!
         */

        Integer nextDimension = Dimension.getNextKey(mIgnoredDimension, dimension);
        if (splitDataSet[0].size() != 0) {
            mVertexLower = new Vertex(splitDataSet[0],
                    nextDimension);
        }
        if (splitDataSet[1].size() != 0) {
            mVertexEqual = new Vertex(splitDataSet[1],
                    nextDimension);
        }
        if (splitDataSet[2].size() != 0) {
            mVertexUpper = new Vertex(splitDataSet[2],
                    nextDimension);
        }
    }

    public String toString() {
        if (mEntity == null) {
            return "Entity(null)";
        }
        return "Entity(" + mEntity.toString() + ")";
    }

    public Integer getDimension() {
        return mDimension;
    }

    public Entity getEntity() {
        return mEntity;
    }

    public Vertex getVertex(int i) {
        if (i == 0) {
            return mVertexLower;
        } else if (i == 1) {
            return mVertexEqual;
        } else {
            return mVertexUpper;
        }
    }

    public Vertex getLowerVertex() {
        return mVertexLower;
    }
    public Vertex getEqualVertex() {
        return mVertexEqual;
    }
    public Vertex getUpperVertex() {
        return mVertexUpper;
    }
}
