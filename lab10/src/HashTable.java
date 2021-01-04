public class HashTable {

    private static final int DEF_MAX_HASH_SIZE = 10;                    // Default maximum hash table size
    private SLinkedList <HashTableData> [] hashArray;                   // Array containing the lists of keys
    private int hashSize;
                                                                        // ———The following are Method Headers ONLY ——— //
                                                                        // each of these methods needs to be fully implemented
                                                                        // Constructors and helper method setup


    public HashTable (){                                                // Constructor: default size
        this(DEF_MAX_HASH_SIZE);

    }

    public HashTable ( int maxNumber ){                                 // Constructor: specific size
        hashArray = new SLinkedList[maxNumber];
        hashSize = maxNumber;
    }




    /**
     *
     * @param key
     * @return
     */

    int HashFunction ( int key ) {
        if (key <= 0) throw new RuntimeException("key <= 0");
        return key % hashSize;
    }



    /**
     *
     * @param key
     * @return
     */

    int HashFunction ( String key ){
        if(key == null) throw new RuntimeException("key == null");
        int code = 0;
        for(int i=0 ; i < key.length() ; i++){
            code += (int)key.charAt(i);
        }
        return HashFunction(code);
    }




    /**
     * @param searchElem
     * @return true if the element founded else false
     */
    public boolean retrieve ( HashTableData searchElem){
        if(searchElem == null) throw new RuntimeException("searchElem == null");
        if(isEmpty()) return false;

        int code = HashFunction(searchElem.getKey());

        SLinkedList<HashTableData> head = hashArray[code];
        while ( head.getCursor() != null ){
            if(head.getCursor().equals(searchElem)){
                return true;
            }
            if(head.gotoNext() == false) break;
        }
        return false;
    }



    /**
     *
     * @param newElem
     * @return
     */
    public boolean insert ( HashTableData newElem){
        if(newElem == null) throw new RuntimeException("newElem == null");
        if(isFull()) return false;

        int code = HashFunction(newElem.getKey());
        hashArray[code].insert(newElem);
        return true;
    }



    /**
     *
     * @param remElem
     * @return
     */
    public boolean remove ( HashTableData remElem){
        if(remElem == null) throw new RuntimeException("remElem == null");
        if(isEmpty()) return false;

        int code = HashFunction(remElem.getKey());
        hashArray[code].insert(remElem);
        return true;
    }



    /**
     * clear the table
     */
    public void clear (){
        hashArray = null;
    }



    /**
     *
     * @return true if is empty
     */
    public boolean isEmpty (){
        if(hashArray == null) return true;
        return false;
    }



    /**
     *
     * @return true if is Full
     */
    public boolean isFull(){ return false;}



    /**
     *
     * @return the Srting Structure of the table
     */
    public String toString(){
        return null;
    }
}