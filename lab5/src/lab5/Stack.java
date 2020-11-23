/**
 * 
 */
package lab5;

/**
 * @author yair Pinhas
 *
 */
public interface Stack<T> {
	public static final int DEF_MAX_STACK_SIZE = 10;
	
	public void push(T newElement);
	public T pop();
	public void clear();
	public boolean isEmpty();
	public boolean isFull();
	
}
