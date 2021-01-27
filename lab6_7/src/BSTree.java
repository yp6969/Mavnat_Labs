public class BSTree{

    private BSTreeNode root;

    public BSTree (){
        root = null;
    }

    public void insert ( int newKey ){
        root = rec_insert(root , newKey);
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
    
    
    public int height (){
        return rec_height(root);
    }
    
    //(left,root,right)
    public String Inorder(){
        return rec_Inorder(root).toString();      
    }
    
    //(root,left,right)
	public String Preorder(){
	    return  rec_Preorder(root).toString();
	}
	
	//(left,right,root)
    public String Postorder(){
        return rec_Postorder(root).toString();
    }
    
    
    //******************************************************************************
    //******************************************************************************
	// Recursive partners of the public member methods --- Insert these methods here.
    //******************************************************************************
    //******************************************************************************


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
    
    private int rec_height(BSTreeNode root){
        if (root == null) return 0;
        if (root.isLeaf()) return 1;
        int left = rec_height(root.getLeft());
        int right = rec_height(root.getRight());
        return left >= right ? left+1 : right + 1;
    }
    
    
    //******************************************************************************
    // Print tree methods
    //******************************************************************************

    private StringBuilder rec_Inorder(BSTreeNode root){
    	
    	StringBuilder ss = new StringBuilder();    	
        if (root == null) return ss.append("");
        if( root.isLeaf() ) return ss.append(String.valueOf(root.getKey()));
        
        ss.append(rec_Inorder(root.getLeft()));
        ss.append(root.getKey());
        ss.append(rec_Inorder(root.getRight()));
        return ss;
    }
    

    private StringBuilder rec_Preorder(BSTreeNode root){
    	
    	StringBuilder ss = new StringBuilder();    	
        if (root == null) return ss.append("");
        if( root.isLeaf() ) return ss.append(String.valueOf(root.getKey()));
        
        ss.append(root.getKey());
        ss.append(rec_Preorder(root.getLeft()));
        ss.append(rec_Preorder(root.getRight()));
        return ss;

    }
    
    
    private StringBuilder rec_Postorder(BSTreeNode root){
    	
    	StringBuilder ss = new StringBuilder();    	
        if (root == null) return ss.append("");
        if( root.isLeaf() ) return ss.append(String.valueOf(root.getKey()));
        
        ss.append(rec_Postorder(root.getLeft()));
        ss.append(rec_Postorder(root.getRight()));
        ss.append(root.getKey());
        return ss;
    }
} 