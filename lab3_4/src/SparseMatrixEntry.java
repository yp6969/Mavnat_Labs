
public class SparseMatrixEntry{
	private double value; // Sparse Matrix element
	private int i; // Index i
	private int j; // Index j
	public SparseMatrixEntry(double val, int i, int j) { 
		this.value = val;
		this.i =i;
		this.j =j;
	}
	public int getI() { return i; } //
	public void setI(int i) { this.i =i;}
	public int getJ() { return j; }
	public void setJ(int j) { this.j = j;}
	public double getValue() { return value;}
	public void setValue(double newVal) { this.value = newVal;}
	
}