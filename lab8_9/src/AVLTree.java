
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
	 * @return balance factor NULL is -1
	 */
	private int balanceFactor(AVLTreeNode root){
		if(root.getLeft() == null && root.getRight() == null) { return 0; }
		if(root.getLeft() == null) {
			return -1 - root.getRight().getHeight();
		}
		if(root.getRight() == null) {
			return root.getLeft().getHeight() + 1 ;
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
		int BF_root = balanceFactor(root);

		// rotate LL
		if( BF_root == 2  &&  balanceFactor(root.getLeft()) >=0 ) {
			return rotate_LL(root);
		}
		// rotate LR
		else if( BF_root == 2  &&  balanceFactor(root.getLeft()) == -1 ) {
			return rotate_LR(root);
		}
		
		// rotate RR
		else if( BF_root == -2  &&  balanceFactor(root.getRight()) <= 0 ) {
			return rotate_RR(root);
		}
		// rotate RL
		else if( BF_root == -2  &&  balanceFactor(root.getRight()) == 1 ) {
			return rotate_RL(root);
		}
					
		return root;
	}
	
	
	
	private AVLTreeNode rotate_LR(AVLTreeNode root) {
				
		root.setLeft(rotate_RR(root.getLeft()));
		return rotate_LL(root);
	}
	
	private AVLTreeNode rotate_RL(AVLTreeNode root) {
		root.setRight(rotate_LL(root.getRight()));
		return rotate_RR(root);
	}
	
	
	private AVLTreeNode rotate_LL(AVLTreeNode root) {
			
		AVLTreeNode return_val = root.getLeft();
		root.setLeft(return_val.getRight());
		return_val.setRight(root);
			
		return return_val;
	}
		
	private AVLTreeNode rotate_RR(AVLTreeNode root) {
			
		AVLTreeNode return_val = root.getRight();
		root.setRight(return_val.getLeft());	
		return_val.setLeft(root);
		
		return return_val;
	}
	
	/**
	 * 
	 * @param newElement
	 */
	public void insert(int newElement){
		root = insert_rec(root, newElement);
	}


	public AVLTreeNode retrieve(int searchKey) {
		return rec_retrieve(root, searchKey);
	}

	public AVLTreeNode rec_retrieve(AVLTreeNode root , int searchKey){
		
		if (root == null)
			return root;
		if (root.getKey() == searchKey) {
			return root;
		}
		if (root.getKey() < searchKey) {
			return rec_retrieve(root.getRight(), searchKey);
		} else if (root.getKey() >= searchKey) {
			return rec_retrieve(root.getLeft(), searchKey);
		}
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
	
	// (left,root,right)
	public String toString(){
		return rec_Inorder(root).toString();
	}

	private StringBuilder rec_Inorder(AVLTreeNode root) {

		StringBuilder ss = new StringBuilder();
		if (root == null)
			return ss.append("");
		if ( root.getLeft()== null && root.getRight() == null )
			return ss.append(String.valueOf(root.getKey())+ " ");

		ss.append(rec_Inorder(root.getLeft()));
		ss.append(root.getKey() +" ");
		ss.append(rec_Inorder(root.getRight()));
		return ss;
	}

}
