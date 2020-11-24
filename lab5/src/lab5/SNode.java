package lab5;

public class SNode<T> {
	
	
	private T element;		 // element in the list
	private SNode<T> next;  // reference to the next element
	
	public SNode(T element, SNode<T> next) {
			this.element = element;
			this.next = next;
	}
	public T getElement(){ 
		return this.element;
	}
	
	public void setElement (T newElem) { 
		this.element = newElem;
	}
	
	public SNode<T> getNext() {
		return this.next;
	}
	public void setNext (SNode<T> nextVal) {
		this.next = nextVal;
	}
}