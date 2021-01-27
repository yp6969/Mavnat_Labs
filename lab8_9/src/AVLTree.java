
public class AVLTree {
	
	private AVLTreeNode root;
	
	public AVLTree(){
		root = null;		
	}
	
	/**
	 * check the balance between left and right
	 *
	 * @param root
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




	/*********************************************************************/

	/**
	 * insert node to the tree
	 * 
	 * @param root
	 * @param newElement
	 * @return AVL Tree
	 *
	 *
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

		/**
		 * checking the rotation
		 */
		if(BF_root >= 2 || BF_root <= -2)
			return rotate(root, BF_root);

		return root;
	}



	/**
	 *
	 * rotate functions
	 *
	 */
	private AVLTreeNode rotate(AVLTreeNode root, int BF_root){
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
		return null;
	}

	/**
	 *
	 * @param root
	 * @return
	 */
	private AVLTreeNode rotate_LR(AVLTreeNode root) {
				
		root.setLeft(rotate_RR(root.getLeft()));
		return rotate_LL(root);
	}
	
	private AVLTreeNode rotate_RL(AVLTreeNode root) {
		root.setRight(rotate_LL(root.getRight()));
		return rotate_RR(root);
	}

	/**
	 *
	 * @param root
	 * @return
	 */
	private AVLTreeNode rotate_LL(AVLTreeNode root) {
			
		AVLTreeNode return_val = root.getLeft();
		root.setLeft(return_val.getRight());
		return_val.setRight(root);

		/*  update the hights */
		root.setHeight(getHight(root));
		return_val.setHeight(getHight(return_val));
		return return_val;
	}

	/**
	 *
	 * @param root
	 * @return
	 */
	private AVLTreeNode rotate_RR(AVLTreeNode root) {
			
		AVLTreeNode return_val = root.getRight();
		root.setRight(return_val.getLeft());	
		return_val.setLeft(root);

		/*  update the hights */
		root.setHeight(getHight(root));
		return_val.setHeight(getHight(return_val));
		return return_val;
	}
	
	/**
	 * insert the key
	 * 
	 * @param newElement
	 */
	public void insert(int newElement){
		root = insert_rec(root, newElement);
	}
	/*********************************************************************/



	/**
	 *
	 * seaching for the key
	 *
	 * @param root
	 * @param searchKey
	 * @return
	 *
	 *
	 */

	public AVLTreeNode rec_retrieve(AVLTreeNode root , int searchKey){
		if (root == null) return root;
		if (root.getKey() == searchKey) return root;
		if (root.getKey() < searchKey) return rec_retrieve(root.getRight(), searchKey);
		else if (root.getKey() >= searchKey) return rec_retrieve(root.getLeft(), searchKey);
		return null;
	}

	public AVLTreeNode retrieve(int searchKey) {
		return rec_retrieve(root, searchKey);
	}



	/**
	 * clear all the Tree
	 */
	public void clear(){
		root = null;
	}


	/**
	 *
	 *
	 * @return true if empty else false
	 *
	 */

	public boolean isEmpty(){
		if(root == null) return true;
		return false;
	}
	
	public boolean isFull(){ return false;} 
	
	// (left,root,right)
	public String toString(){
		return rec_Inorder(root).toString();
	}




	/**
	 *
	 * Making inorder string from the Tree
	 * @param root
	 * @return
	 *
	 *
	 */
	private StringBuilder rec_Inorder(AVLTreeNode root) {

		StringBuilder ss = new StringBuilder();
		if (root == null)
			return ss.append("");
		if ( root.getLeft()== null && root.getRight() == null )
			return ss.append(String.valueOf(root.getKey())+ "(" + root.getHeight() + ") ");

		ss.append(rec_Inorder(root.getLeft()));
		ss.append(root.getKey() + "(" + root.getHeight() + ") ");
		ss.append(rec_Inorder(root.getRight()));
		return ss;
	}




//
//
//	public static int[] order(AVLTree t1, AVLTree t2){
//
//		if(t1 == null && t2 == null) {
//			return new int[0];
//		}
//	}
//
//	public static int[] inorder(AVLTreeNode root){
//		if(root == null) return null;
//
//		int[] a = inorder(root.getLeft());
//		int[] b = inorder(root.getRight());
//		return copy
//	}


}
