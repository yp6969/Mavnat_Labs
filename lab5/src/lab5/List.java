package lab5;


public interface List<T> {
		
	public void insert ( T newElement );
	public void remove();
	public void replace ( T newElement );
	public void clear();
	public boolean isEmpty (); 
	public boolean gotoBeginning();
	public boolean gotoEnd();
	public boolean gotoNext(); 
	public boolean gotoPrior(); 
	public T getCursor();

}

