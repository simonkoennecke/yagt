package de.farbtrommel.yagt.exercise;

import de.farbtrommel.yagt.kdtree.*;
import de.farbtrommel.yagt.kdtree.search.OrthogonalSearch;
import de.farbtrommel.yagt.kdtree.search.Range;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

public class Lab7 {
    public static void main(String[] args) {
        //simpleExample();
        notSoSimpleExample();
    }

    public static void notSoSimpleExample() {
        try {
            DataSet dataSet = new DataSet();

            //Define Columns
            //dataSet.addColumn("Country", new String());
            dataSet.addColumn("City", new String());
            //dataSet.addColumn("Region", new Integer(1));
            dataSet.addColumn("Latitude", new Double(0));
            dataSet.addColumn("Longitude", new Double(0));

            Reader in = new FileReader("orte_deutschland.txt");

            final CSVParser parser = new CSVParser(in, CSVFormat.RFC4180.newFormat('\t').withHeader());
            int i=0;
            for (final CSVRecord record : parser) {
                Entity entity = new Entity();
                //System.out.println(record.toString());

                //entity.add("Country", record.get("Country"));
                entity.add("City", record.get("City"));
                //entity.add("Region", new Integer(record.get("Region")));
                entity.add("Latitude", new Double(record.get("Latitude")));
                entity.add("Longitude", new Double(record.get("Longitude")));

                dataSet.addRow(entity);
                //if(i++ == 350000) {
                    //break;
                //}
            }

            System.out.println(dataSet);
            System.out.println();

            System.out.println("Creating kd-Tree: ");
            KdTree kdTree = new KdTree(dataSet);
            System.out.println("Finished the initialization of kd-Tree...");

            System.out.println("Query: ");
            OrthogonalSearch orthogonalSearch = new OrthogonalSearch();
            orthogonalSearch.addFilter("City", new Range<String>("w", "z"));
            orthogonalSearch.addFilter("Latitude", new Range<Double>(52.4d, 53d));
            orthogonalSearch.addFilter("Longitude", new Range<Double>(12.45, 13.4));
            printFilter(orthogonalSearch);

            System.out.println("Result: ");
            List<Entity> list = orthogonalSearch.search(kdTree.getRootVertex());
            printResults(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void simpleExample() {
        try {
            DataSet dataSet = new DataSet();

            //Define Columns
            dataSet.addColumn("x", new Double(1f));
            dataSet.addColumn("y", new Double(1f));

            //Add Rows
            for (int i = 0; i < 22; i++) {
                Entity entity = new Entity();

                entity.add("x", Math.random());
                entity.add("y", Math.random());

                dataSet.addRow(entity);
            }
            dataSet.sort(0);
            System.out.println(dataSet);
            System.out.println();


            //Create kd-Tree
            KdTree kdTree = new KdTree(dataSet);

            System.out.println("Query: ");
            OrthogonalSearch orthogonalSearch = new OrthogonalSearch();
            orthogonalSearch.addFilter("x", new Range(dataSet.get(3).get(0).mValue,
                    dataSet.get(6).get(0).mValue));
            printFilter(orthogonalSearch);

            System.out.println("Result: ");
            List<Entity> list = orthogonalSearch.search(kdTree.getRootVertex());
            printResults(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFilter(OrthogonalSearch orthogonalSearch) {
        for (int i = 0; i < Dimension.size(); i++) {
            Range range = orthogonalSearch.getRange(i);
            System.out.print(Dimension.getLabel(i) + ": ");
            System.out.println(range);
        }
        System.out.println();

    }
    private static void printResults(List<Entity> list) {
        if (list.size() == 0) {
            System.out.println("No Results.");
        }
        for (Entity entity: list) {
            System.out.println(entity);
        }
    }
}
