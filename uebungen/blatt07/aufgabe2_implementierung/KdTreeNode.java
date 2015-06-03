
public interface KdTreeNode {
	public KdTreeNode getParent();
	public KdTreeNode getLeftChild();
	public KdTreeNode getRightChild();
	public void setParent(KdTreeNode parent);
	public void setLeftChild(KdTreeNode leftChild);
	public void setRightChild(KdTreeNode rightChild);
}
