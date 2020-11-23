package lab5;

public class StackArray<T> implements Stack<T>{

	private T[] stack;
	private int top;
	
	
	@SuppressWarnings("unchecked")
	public StackArray(int size) {
		stack = (T[]) new Object[size];
		top = -1;
	}
	
	@Override
	public void push(T newElement) {
		if(isFull()) {
			System.out.println("The stack is Full... no  can do");
			return;
		}
		top++;
		stack[top] = newElement;
	}

	@Override
	public T pop() {
		if(isEmpty()) return null;
		top--;
		return stack[top+1];
	}

	@Override
	public void clear() {
		top = -1; 
	}

	@Override
	public boolean isEmpty() {
		if(top == -1) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if( top == stack.length) return true;
		return false;
	}
	
	public String toString() {
		return stack.toString();
	}
	

}
