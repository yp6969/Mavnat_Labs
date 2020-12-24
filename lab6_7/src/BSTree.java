public class BSTree {

	private BSTreeNode root;

	// *****************************************************************************
	// *****************************************************************************
	// *****************************************************************************
	// lab7
	
	
	public void delete(int newKey) {
		rec_delete(root, newKey);
	}

	public BSTreeNode findMin() {
		return rec_findMin(root);
	}

	public BSTreeNode findMax() {
		return rec_findMax(root);
	}

	public BSTreeNode findParent(int key) {
		return rec_findParent(root, key);
	}
	
	
	
	// implementation delete method
	
	private BSTreeNode rec_delete(BSTreeNode root, int newKey) {

		if ( root == null)
			return null;

		// find the correct node
		if (root.getKey() > newKey) {
			root.setLeft ( rec_delete(root.getLeft(), newKey) );
			return root;
			
		}
		 if (root.getKey() < newKey) {
			root.setRight ( rec_delete(root.getRight(), newKey) );
			return root;
		}
		
		
		// case 1 : if the node is a leaf
		
		if (root.isLeaf() && root.getKey() == newKey) {
			return root = null;
		}

		// case 2 : if the node has exactly 1 child

		if (root.getRight() == null && root.getLeft() != null)
			return root.getLeft();

		if (root.getLeft() == null && root.getRight() != null)
			return root.getRight();

		
		// case 3 : if the node has 2 children
		else {
			
			BSTreeNode max = rec_findMax(root.getLeft());
			root.setKey( max.getKey() );
			root.setLeft(  rec_delete(root.getLeft(), max.getKey())  );
		}	
		return root;
	}


	private BSTreeNode rec_findMin(BSTreeNode root) {

		if (root == null)
			return root;
		if (root.getLeft() == null)
			return root;
		return rec_findMin(root.getLeft());
	}

	private BSTreeNode rec_findMax(BSTreeNode root) {

		if (root == null)
			return root;
		if (root.getRight() == null)
			return root;
		return rec_findMax(root.getRight());
	}

	private BSTreeNode rec_findParent(BSTreeNode root, int key) {

		if (root == null || root.getKey() == key)
			return null;

		if (root.getLeft() != null && root.getLeft().getKey() == key)
			return root;
		else if (root.getRight() != null && root.getRight().getKey() == key)
			return root;

		if (root.getKey() < key) {
			return rec_findParent(root.getRight(), key);
		} else if (root.getKey() >= key) {
			return rec_findParent(root.getLeft(), key);
		}
		return null;
	}

	// *****************************************************************************
	// *****************************************************************************
	// *****************************************************************************

	public BSTree() {
		root = null;
	}

	public void insert(int newKey) {
		root = rec_insert(root, newKey);
	}

	public BSTreeNode retrieve(int searchKey) {
		return rec_retrieve(root, searchKey);
	}

	public void clear() {
		root = null;
	}// Clear tree

	// Binary search tree status methods
	public boolean isEmpty() {
		return root == null;
	}

	public boolean isFull() {
		return false;
	}

	public int height() {
		return rec_height(root);
	}

	// (left,root,right)
	public String Inorder() {
		return rec_Inorder(root).toString();
	}

	// (root,left,right)
	public String Preorder() {
		return rec_Preorder(root).toString();
	}

	// (left,right,root)
	public String Postorder() {
		return rec_Postorder(root).toString();
	}

	// ******************************************************************************
	// ******************************************************************************
	// Recursive partners of the public member methods --- Insert these methods
	// here.
	// ******************************************************************************
	// ******************************************************************************

	private BSTreeNode rec_insert(BSTreeNode root, int newKey) {
		if (root == null) {
			return new BSTreeNode(newKey);
		} else if (newKey < root.getKey()) {
			root.setLeft(rec_insert(root.getLeft(), newKey));
		} else if (newKey > root.getKey()) {
			root.setRight(rec_insert(root.getRight(), newKey));
		}
		return root;
	}

	private BSTreeNode rec_retrieve(BSTreeNode root, int searchKey) {
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

	private int rec_height(BSTreeNode root) {
		if (root == null)
			return 0;
		if (root.isLeaf())
			return 1;
		int left = rec_height(root.getLeft());
		int right = rec_height(root.getRight());
		return left >= right ? left + 1 : right + 1;
	}

	// ******************************************************************************
	// Print tree methods
	// ******************************************************************************

	private StringBuilder rec_Inorder(BSTreeNode root) {

		StringBuilder ss = new StringBuilder();
		if (root == null)
			return ss.append("");
		if (root.isLeaf())
			return ss.append(String.valueOf(root.getKey()));

		ss.append(rec_Inorder(root.getLeft()));
		ss.append(root.getKey());
		ss.append(rec_Inorder(root.getRight()));
		return ss;
	}

	private StringBuilder rec_Preorder(BSTreeNode root) {

		StringBuilder ss = new StringBuilder();
		if (root == null)
			return ss.append("");
		if (root.isLeaf())
			return ss.append(String.valueOf(root.getKey()));

		ss.append(root.getKey());
		ss.append(rec_Preorder(root.getLeft()));
		ss.append(rec_Preorder(root.getRight()));
		return ss;

	}

	private StringBuilder rec_Postorder(BSTreeNode root) {

		StringBuilder ss = new StringBuilder();
		if (root == null)
			return ss.append("");
		if (root.isLeaf())
			return ss.append(String.valueOf(root.getKey()));

		ss.append(rec_Postorder(root.getLeft()));
		ss.append(rec_Postorder(root.getRight()));
		ss.append(root.getKey());
		return ss;
	}
}