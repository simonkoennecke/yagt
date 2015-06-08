package de.farbtrommel.yagt.kdtree;

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

    public KdTree(DataSet set) {
        mRoot = new Vertex(set, 0);
    }

    public Vertex getRootVertex() {
        return mRoot;
    }
}
