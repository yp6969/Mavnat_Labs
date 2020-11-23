
public class StackList<T> implements Stack<T>{
	
	private SNode<T> top; // Top Of Stack: Reference to top of stack
	private SLinkedList <T> listOfStackElements; 
	

	public StackList(int size) {
		listOfStackElements = new SLinkedList<T>();
	}
	
	@Override
	public void push(T newElement) {
		
		listOfStackElements.gotoEnd();
		listOfStackElements.insert(newElement);
	}

	
	@Override
	public T pop() {
				
		if (listOfStackElements.isEmpty()) return null;
		
		listOfStackElements.gotoEnd();
		T tmp = listOfStackElements.getCursor();
		listOfStackElements.remove();

		return tmp;		
	}

	@Override
	public void clear() {
		listOfStackElements.clear();
		top = null;
	}

	@Override
	public boolean isEmpty() {
		return listOfStackElements.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	@Override
	public String toString() {
		return listOfStackElements.toString();
	}

}
