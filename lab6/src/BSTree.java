public class BSTree{

    private BSTreeNode root;

    public BSTree (){
        root = null;
    }

    // Binary search tree manipulation methods
    private BSTreeNode rec_insert(BSTreeNode root, int newKey){
        if(root == null){
            return new BSTreeNode(newKey);
        }
        else if(newKey < root.getKey() ){
            root.setLeft(rec_insert(root.getLeft() , newKey));
        }
        else if(newKey > root.getKey()){
            root.setRight(rec_insert(root.getRight() , newKey));
        }
        return root;
    }

    public void insert ( int newKey ){
        root = rec_insert(root , newKey);
    }

    private BSTreeNode rec_retrieve (BSTreeNode root, int searchKey ){
        if (root == null) return root;
        if(root.getKey() == searchKey){
            return root;
        }
        if(root.getKey() < searchKey){
            return rec_retrieve(root.getRight(), searchKey);
        }
        else if(root.getKey() >= searchKey){
            return rec_retrieve(root.getLeft(), searchKey);
        }
        return null;
    }
    public BSTreeNode retrieve ( int searchKey ){
        return rec_retrieve(root, searchKey);
    }
    public void clear ( ){
        root = null;
    }// Clear tree

    // Binary search tree status methods
    public boolean isEmpty (){ return root == null;}
    public boolean isFull (){ return false;}

    // Print tree methods
    private StringBuilder rec_Postorder(BSTreeNode root){
        if (root == null) return new StringBuilder("");
        if( root.isLeaf() ) return new StringBuilder(String.valueOf(root.getKey()));
        StringBuilder ss = new StringBuilder();
        ss.append(rec_Postorder(root.getLeft()));
        ss.append(rec_Postorder(root.getRight()));
        ss.append(root.getKey());
        return ss;
    }

    public String Postorder(){
        if (isEmpty()) return null;
        StringBuilder ss = new StringBuilder();
        ss = rec_Postorder(root);
        return ss.toString();
    }

    private StringBuilder rec_Inorder(BSTreeNode root){
        if (root == null) return new StringBuilder("");
        if( root.isLeaf() ) return new StringBuilder(String.valueOf(root.getKey()));
        StringBuilder ss = new StringBuilder();
        ss.append(rec_Postorder(root.getLeft()));
        ss.append(root.getKey());
        ss.append(rec_Postorder(root.getRight()));
        return ss;
    }

    public String Inorder(){
        if (isEmpty()) return null;
        StringBuilder ss = new StringBuilder();
        ss = rec_Inorder(root);
        return ss.toString();
    }

    private StringBuilder rec_Preorder(BSTreeNode root){
        if (root == null) return new StringBuilder("");
        if( root.isLeaf() ) return new StringBuilder(String.valueOf(root.getKey()));
        StringBuilder ss = new StringBuilder();
        ss.append(root.getKey());
        ss.append(rec_Postorder(root.getLeft()));
        ss.append(rec_Postorder(root.getRight()));
        return ss;
    }
    public String Preorder(){
        if (isEmpty()) return null;
        StringBuilder ss = new StringBuilder();
        ss = rec_Preorder(root);
        return ss.toString();
    }

    private int rec_height(BSTreeNode root){
        if (root == null) return 0;
        if (root.isLeaf()) return 1;
        int left = rec_height(root.getLeft());
        int right = rec_height(root.getRight());
        return left >= right ? left+1 : right + 1;
    }
    public int height (){
        return rec_height(root);
    }
// Recursive partners of the public member methods --- Insert these methods here.
} // class BSTree