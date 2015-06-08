package de.farbtrommel.yagt.kdtree.search;

import de.farbtrommel.yagt.kdtree.Entity;
import de.farbtrommel.yagt.kdtree.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leider etwas unvollständig aber für die Aufgabe auch nicht relevant.
 */
public class NearestNeighbourSearch {
    private Entity mSearchEntity;
    private Entity mBestEntity;
    private Double mBestDist;
    private DistanceComparator mDistanceComparator = new DistanceComparator();
    private List<Entity> mResultSet;

    /**
     * Find for the 'entity' the nearest Neighbour.
     * @param entity
     * @return Return all retrieved Entities sorted by the distance from best fit entity.
     */
    public List<Entity> kNearestNeighbourSearch(Vertex root, Entity entity) {
        mResultSet = new ArrayList<Entity>();
        mSearchEntity = entity;
        mDistanceComparator.setOrigin(entity);
        searchHelperKNN(root);

        mDistanceComparator.setOrigin(mBestEntity);
        Collections.sort(mResultSet, mDistanceComparator);
        return mResultSet;
    }

    /**
     * Set a new best fit Entity for the current search.
     * @param entity New best fit Entity
     */
    private void setBestEntity(Entity entity) {
        mBestEntity = entity;
        mBestDist = mDistanceComparator.distanceToOrigin(mBestEntity);
    }

    /**
     * Help knn search to retrieval the tree and select the nearest points.
     * The function compares all three (left, equal, right) branches to search parameter mSearchEntity,
     * the nearest vertex will be chosen for the further steps. When the recursive calls came back
     * to the procedure maybe with the new bestFitEntity are closer to the other branches, if so retrieval them to.
     * @param vertex
     */
    private void searchHelperKNN(Vertex vertex) {
        if (vertex == null || vertex.getEntity() == null) {
            return;
        }

        mResultSet.add(vertex.getEntity());

        //Set current to best entity, when dist to search point is better
        if (mBestDist > mDistanceComparator.distanceToOrigin(vertex.getEntity())) {
            setBestEntity(vertex.getEntity());
        }

        double[] dist = new double[]{
                mDistanceComparator.distanceToOrigin(vertex.getLowerVertex().getEntity()),
                mDistanceComparator.distanceToOrigin(vertex.getEqualVertex().getEntity()),
                mDistanceComparator.distanceToOrigin(vertex.getUpperVertex().getEntity())
        };

        int nextVisit = 0, lastVisit = -1;
        double bestDist = dist[0];
        for (int i = 1; i < dist.length; i++) {
            if (bestDist > dist[i]){
                lastVisit = nextVisit = i;
                bestDist = dist[i];
            }
        }

        Vertex newBestFit = vertex.getVertex(nextVisit);
        //change the best fit entity
        setBestEntity(newBestFit.getEntity());
        //Search for a better fit.
        searchHelperKNN(newBestFit);

        //Search in the other branches - when the distance is less than best fit point
        if (mBestDist > mDistanceComparator.distanceToOrigin(vertex.getEntity(), vertex.getDimension())) {
            bestDist = dist[0];
            for (int i = 1; i < dist.length; i++) {
                if (lastVisit != i && bestDist > dist[i]){
                    nextVisit = i;
                    bestDist = dist[i];
                }
            }
            //check we don't run the same branch
            if (lastVisit != nextVisit) {
                searchHelperKNN(vertex.getVertex(nextVisit));
            }
        }
    }
}
