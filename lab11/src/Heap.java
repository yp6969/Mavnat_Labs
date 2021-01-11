public class Heap {


    private static final int DEF_MAX_HEAP_SIZE = 10;                            // Default maximum heap size
    private int size;                                                           // Actual number of elements in the heap
    private HeapData [] element;                                               // Array containing the heap elements

// Constructors and helper method setup

    public Heap(){                                                              // Constructor: default size
        this(DEF_MAX_HEAP_SIZE);
    }

    public Heap(int maxNumber){                                                 // Constructor: specific size
        if(maxNumber <= 0) maxNumber = DEF_MAX_HEAP_SIZE;
        size = 1;
        element = new HeapData[maxNumber];
        element[0] = new HeapData();

    }

    // Heap manipulation methods

    /*
        Insert element
        To implement, you can write and use Heapify help
        method. Be sure you make only one swap between
        the elements!
     */


    public void insert( HeapData newElement){
        if(newElement == null) throw new RuntimeException("new Element Is NUll");
        if(isFull()) throw new RuntimeException("The Heap is Full");
        int current = size;

        while( newElement.getPreority() < element[current/2].getPreority() ){
            element[current] = element[current/2];
            current /= 2;
        }
        element[current] = newElement;
        size++;
    }


    public HeapData removeMin(){                                                // Remove min priority element
        if(isEmpty()) throw new RuntimeException("The Heap is Empty");
        HeapData lastElement = element[size-1];
        HeapData minElem = element[1];
        int current = 1;

        while(current*2 <= size-1){
            int minIndex = getMinIndex(current*2);
            element[current] = element[minIndex];
            current = minIndex;
        }

        if(current*2 > size-1){
            element[current] = lastElement;
        }
        size--;
        return minElem;
    }


    private int getMinIndex(int a){                                               // return the index of the minimum preority
        if(a+1 >= size) return a;
        if (element[a].getPreority() <= element[a+1].getPreority()) return a;
        return a+1;
    }


    public void clear() {                                                         // Clear heap: Make it efficient!!
        element = new HeapData[element.length];
        element[0] = new HeapData();
        size = 1;
    }

                                                                                    // Heap status methods

    public boolean isEmpty(){
        return size <= 1;
    }
    public boolean isFull(){
        return size >= element.length;
    }

                                                                                    // Output the heap structure
    public String toString(){
        if (isEmpty()) return "Empty Heap";

        StringBuilder ss = new StringBuilder("[ ");
        for (int i=1 ; i < size ; i++){
            ss.append("("+ element[i].getPreority() + "," + i +") , ");
        }
        ss.append("]");
        return ss.toString();
    }
}