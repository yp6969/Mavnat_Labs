
public class AVLTree {
	
	private AVLTreeNode root;
	
	public AVLTree(){
		root = null;		
	}
	
	/**
	 * check the balance between left and right
	 * 
	 * @param left
	 * @param right
	 * @return balance factor
	 */
	private int balanceFactor(AVLTreeNode root){
		if(root.getLeft() == null && root.getRight() == null) { return 0; }
		if(root.getLeft() == null) {
			return -root.getRight().getHeight();
		}
		if(root.getRight() == null) {
			return root.getLeft().getHeight();
		}
		return root.getLeft().getHeight() - root.getRight().getHeight();
	}
	
	/**
	 * calculate the hight of root
	 * @param root
	 * @return max hight of left and right
	 */
	private int getHight(AVLTreeNode root){
		if(root.getLeft() == null && root.getRight() == null) { return 0; }
		if(root.getLeft() == null) {
			return root.getRight().getHeight() + 1;
		}
		if(root.getRight() == null) {
			return root.getLeft().getHeight() + 1;
		}
		return Math.max(root.getLeft().getHeight(), root.getRight().getHeight()) + 1;
	}
	
	/**
	 * insert node to the tree
	 * 
	 * @param root
	 * @param newElement
	 * @return AVL Tree
	 */
	private AVLTreeNode insert_rec(AVLTreeNode root, int newElement){
		if(root == null){
			return new AVLTreeNode(newElement, 0, null, null);
		}
		if(root.getKey() > newElement) {
			root.setLeft( insert_rec(root.getLeft(), newElement));
			
		}
		else {
			root.setRight( insert_rec(root.getRight(), newElement));
		}

		root.setHeight(getHight(root));
		
		
		return null;
	}
	
	/**
	 * 
	 * @param newElement
	 */
	public void insert(int newElement){
		
	}
	
	public AVLTreeNode retrieve( int searchKey){
		return null;
	}
	
	public void clear(){
		root = null;
	}// Clear tree
	
	public boolean isEmpty(){
		if(root == null) return true;
		return false;
	}
	
	public boolean isFull(){ return false;} 
	
	public String toString(){
		return null;
	} // Output the tree structure in Inorder
	// Recursive partners of the public member methods --- Insert these methods here.
}
