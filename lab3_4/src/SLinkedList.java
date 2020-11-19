

public class SLinkedList<T>  implements List<T> {
	
	private SNode<T> head ;
	private SNode<T> cursor;

	public SLinkedList() {
		head = null;
	    cursor = null;
	}
		
	@Override
	public void insert(T newElement) {		
		
		SNode<T> tmp = new SNode<T>(newElement, null);
		
		if ( isEmpty() ) {
			head = tmp;
			cursor = head;
		}
		else {			
			SNode<T> tmp2 = cursor.getNext();
			cursor.setNext(tmp);
			tmp.setNext(tmp2);
			cursor = tmp;
		}	
	}

	@Override
	public void remove() {
		
			if 	( isEmpty() ) return;
			
			SNode<T> tmp = cursor.getNext();
			gotoPrior();
			cursor.setNext(tmp);
			
			if (tmp  == null)
				cursor = head;
			else
				cursor = tmp;		
	}

	@Override
	public void replace(T newElement) {
		
		if 	( isEmpty() || newElement == null) return;
		cursor.setElement(newElement);
	}
	

	@Override
	public void clear() {
		head = cursor = null;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean gotoBeginning() {
		
		if 	( isEmpty() ) return false;
		cursor = head;
		return true;
	}

	@Override
	public boolean gotoEnd() {
		
		if 	( isEmpty() ) return false;
		
		SNode<T> tmp = head;

		while (tmp.getNext() != null) {
			tmp = tmp.getNext();			
		}	
		cursor = tmp;  
		return true;
	}
	
	public boolean hasNext() {
		if ( isEmpty() || cursor.getNext() == null) return false;
		return true;
	}

	@Override
	public boolean gotoNext() {
		
		if ( isEmpty() || cursor.getNext() == null) return false;
		
		cursor = cursor.getNext();
		return true;
	}

	@Override
	public boolean gotoPrior() {
		
		if 	( isEmpty() || head.getNext() == null) return false;
		
		SNode<T> tmp = head;

		while ( tmp.getNext() != cursor ) {
			tmp = tmp.getNext();
		}
		cursor = tmp;
		return true;
		
	}

	@Override
	public T getCursor() {
		if 	( isEmpty() ) return null;
		return cursor.getElement();
	}
	
	
	@Override
	public String toString () {
		
		StringBuilder str = new StringBuilder();
		str.append( "[ " ); 
		
		SNode<T> tmp = head;
		
		while (tmp != null) {
			str.append( tmp.getElement() +  ( ( tmp.getNext()!= null) ? " , " : " "  ) );  // the last value print without ',' 
			tmp = tmp.getNext();
		}
		str.append( " ]" ); 

		return str.toString();
	}

}
