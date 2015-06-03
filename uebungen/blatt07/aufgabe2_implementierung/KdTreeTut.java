import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class KdTreeTut {
	private ArrayList<CityNode> cityList = new ArrayList<CityNode>(100000);
	private static String cityFile = "/home/felix/Dropbox/Uni/Algorithmische_Geometrie/yagt/uebungen/blatt07/orte_deutschland.txt";
	private static String worldFile = "/home/felix/Dropbox/Uni/Algorithmische_Geometrie/yagt/uebungen/blatt07/orte_weltweit.txt";
	
	
	public static void main(String[] args){
		KdTreeTut ktt = new KdTreeTut();
		ktt.loadCities(KdTreeTut.cityFile);
		CityNode root = ktt.buildKdTree();
	
		for(int i = 0; i < 10; i++){
			System.out.println(root.getName() + " :" + root.getCountry());
			root = (CityNode)root.getLeftChild();
		}
	}
	
	//return Root-Node
	public CityNode buildKdTree(){
		//Clone cityList for build operations:
		ArrayList<CityNode> buildList = (ArrayList<CityNode> )cityList.clone();
		Collections.sort(buildList);
		
		//Create List for storing nodes on layer n:
		ArrayList<CityNode> layerN = new ArrayList<CityNode>(100000);
		
		//Create List for storing sublists for each node on layer n:
		ArrayList<ArrayList<CityNode>> layerNLists = new ArrayList<ArrayList<CityNode>>();
		
		//Initialize with root node:
		CityNode rootNode = buildList.get(buildList.size()/2);
		layerN.add(rootNode);
		layerNLists.add(new ArrayList<CityNode>(buildList.subList(0, buildList.size()/2)));
		layerNLists.add(new ArrayList<CityNode>(buildList.subList(buildList.size()/2 + 1, buildList.size())));
		
		int k = 0;
		int nodesOnLayerN;
		while((nodesOnLayerN = layerN.size()) > 0){
			CityNode.compareWithLongitude = !CityNode.compareWithLongitude;

			for(int i = 0; i < nodesOnLayerN; i++){
				//Get corresponding node lists and sort:
				ArrayList<CityNode> leftList = layerNLists.get(i*2);
				ArrayList<CityNode> rightList = layerNLists.get(i*2+1);
				Collections.sort(leftList);
				Collections.sort(rightList);
				
				//
				CityNode leftNode = leftList.get(leftList.size()/2);
				CityNode rightNode = rightList.get(rightList.size()/2);
				
				//Update Parent-Child-Relations:
				layerN.get(i).setLeftChild(leftNode);
				layerN.get(i).setRightChild(rightNode);
				
				//Update layerN:
				if(leftNode != null){
					if(leftList.size() > 2){
						layerNLists.add(new ArrayList<CityNode>(leftList.subList(0, leftList.size()/2)));
						layerNLists.add(new ArrayList<CityNode>(leftList.subList(leftList.size()/2+1, leftList.size())));
						layerN.add(leftNode);
					}else 
					if(leftList.size() == 2){
						if(CityNode.compareWithLongitude){
							if(leftList.get(0).getLongitude() > leftNode.getLongitude())
								leftNode.setRightChild(leftList.get(0));
							else
								leftNode.setLeftChild(leftList.get(0));
						}else{
							if(leftList.get(0).getLatitude() > leftNode.getLatitude())
								leftNode.setRightChild(leftList.get(0));
							else
								leftNode.setLeftChild(leftList.get(0));
						}
					}
				}
				
				if(rightNode != null){
					if(rightList.size() > 2){
						layerNLists.add(new ArrayList<CityNode>(rightList.subList(0, rightList.size()/2)));
						layerNLists.add(new ArrayList<CityNode>(rightList.subList(rightList.size()/2+1, rightList.size())));
						layerN.add(rightNode);
					}else 
					if(rightList.size() == 2){
						if(CityNode.compareWithLongitude){
							if(rightList.get(0).getLongitude() > rightNode.getLongitude())
								rightNode.setRightChild(rightList.get(0));
							else
								rightNode.setRightChild(rightList.get(0));
						}else{
							if(rightList.get(0).getLatitude() > rightNode.getLatitude())
								rightNode.setRightChild(rightList.get(0));
							else
								rightNode.setRightChild(rightList.get(0));
						}
					}
				}
			}

			
			//alte Knoten/Listen von Layer n-1 entfernen:
			for(int i = 0; i < nodesOnLayerN; i++){
				layerN.remove(0);
				layerNLists.remove(0);
				layerNLists.remove(0);
			}
		}
		
		return rootNode;
	}
	
	public void loadCities(String cityFile){
		try {
			BufferedReader br = new BufferedReader( new InputStreamReader(
                    new FileInputStream(new File(cityFile)), "ISO-8859-1"));
			String line;
			while((line = br.readLine()) != null){
				String[] s = line.split("\t");
					cityList.add(new CityNode(s[2], s[0], Double.parseDouble(s[5]), Double.parseDouble(s[4])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<CityNode> getCities(){
		return this.cityList;
	}
}
