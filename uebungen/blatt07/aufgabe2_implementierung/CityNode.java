
public class CityNode implements KdTreeNode, Comparable<CityNode>{
	private String name, country;
	private double longitude, latitude;
	private KdTreeNode parent = null, leftChild = null, rightChild = null;
	
	public static boolean compareWithLongitude = true;
	
	public CityNode(String name, String country, double longitude, double latitude) {
		this.name = name;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public KdTreeNode getParent() {
		return parent;
	}

	@Override
	public KdTreeNode getLeftChild() {
		return leftChild;
	}

	@Override
	public KdTreeNode getRightChild() {
		return rightChild;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public void setParent(KdTreeNode parent) {
		this.parent = parent;
	}

	@Override
	public void setLeftChild(KdTreeNode leftChild) {
		this.leftChild = leftChild;
		leftChild.setParent(this);
	}

	@Override
	public void setRightChild(KdTreeNode rightChild) {
		this.rightChild = rightChild;
		rightChild.setParent(this);
	}

	@Override
	public int compareTo(CityNode arg0) {
		if(compareWithLongitude){
			if(this.longitude > arg0.getLongitude())
				return 1;
			else
			if(this.longitude == arg0.getLongitude())
				return 0;
			else
				return -1;
		}else{
			if(this.latitude > arg0.getLatitude())
				return 1;
			else
			if(this.latitude == arg0.getLatitude())
				return 0;
			else
				return -1;
		}
	}

}
