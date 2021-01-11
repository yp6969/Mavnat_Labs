
public class TestHeap {

	public static void main(String[] args) {
		
		// create new heap
		Heap heap = new Heap(20);
		 
		// insert to heap
		heap.insert(new HeapData(7));
		heap.insert(new HeapData(34));
		heap.insert(new HeapData(3));
		heap.insert(new HeapData(9));
		heap.insert(new HeapData(87));
		heap.insert(new HeapData(564));
		heap.insert(new HeapData(23));
		heap.insert(new HeapData(563));
		heap.insert(new HeapData(88));
		heap.insert(new HeapData(1));
		heap.insert(new HeapData(123));
		heap.insert(new HeapData(-4));
		heap.insert(new HeapData(56));
		heap.insert(new HeapData(-23));
		heap.insert(new HeapData(11));
		heap.insert(new HeapData(88));
		heap.insert(new HeapData(0));

		
		// print heap
		System.out.println("print :\n"+heap);
		
		
		// remove min
        System.out.println("remove the root " );
		heap.removeMin();
		
		// print heap
		System.out.println("print :\n"+heap);
		
		// is full ?
        System.out.println(heap.isFull());

        // clear heap
		System.out.println("clear heap ");
		heap.clear();
        
		// print heap
		System.out.println("print :\n"+heap);
		
		// is empty?
		System.out.println(heap.isEmpty());

        System.out.println("Bye");
        
	}

}
