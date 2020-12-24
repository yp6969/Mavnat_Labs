
public class AVLTreeNode {
	
	private int key;
	private int height; // Height of the sub-tree
	private AVLTreeNode left, right;
	public AVLTreeNode (int elem, int height, AVLTreeNode leftPtr, AVLTreeNode rightPtr)
	{
		key = elem;
		this.height = height;
		this.left = left;
		this.right = right;
	}
	
	
	
	
	
	
	/**
	 * getters & setters
	 */
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public AVLTreeNode getLeft() {
		return left;
	}
	public void setLeft(AVLTreeNode left) {
		this.left = left;
	}
	public AVLTreeNode getRight() {
		return right;
	}
	public void setRight(AVLTreeNode right) {
		this.right = right;
	}
	
	
	

}
