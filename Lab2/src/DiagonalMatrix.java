import java.util.Arrays;

public class DiagonalMatrix implements Matrix{

	private double[] matrix;
	private int size;
	private int constant = 1;
	
	public DiagonalMatrix() {
		this(MAX_SIZE);
	}
	
	public DiagonalMatrix(int size) {
		this.size = size;
		matrix = new double[2*size-1];
		matrix[0] = 6;
		matrix[1] = 5;
		matrix[2] = 3;
		matrix[3] = 4;
		matrix[4] = 2;
		matrix[5] = 7;
		matrix[6] = 1;
	}
	
	@Override
	public int getSize() { return size; }

	@Override
	public double get(int i, int j) {
		if(i < 0 || j < 0 || i > size || j > size) throw new IndexOutOfBoundsException();
		return matrix[i+j]*constant;
	}

	@Override
	public void put(int i, int j, double x) {
		if(i < 0 || j < 0 || i > size || j > size) throw new IndexOutOfBoundsException();
		matrix[i+j] = x/constant;
	}

	@Override
	public void transpose() {
		return;
	}

	@Override
	public void multByConstant(int c) {
		constant*=c;
	}

	@Override
	public String toString() {
		StringBuilder ss = new StringBuilder();
		for (int i=0; i<size ; i++) {
			for (int j = 0; j < size; j++) {
				ss.append(get(i, j) + "\t");
			}
			ss.append("\n");
		}
		return ss.toString();
	}
	
	

}
