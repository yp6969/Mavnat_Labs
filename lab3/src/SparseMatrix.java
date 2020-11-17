
public class SparseMatrix implements Matrix{
	
	private int size;
	private double defaultValue;
	private boolean transpose = false;
	private double constant = 1 ;
	private SLinkedList<SparseMatrixEntry> matrix;
	
	
	public SparseMatrix(int size, double defaultValue) {
		this.size = size;
		this.defaultValue = defaultValue;
		matrix = new SLinkedList<SparseMatrixEntry>();
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	public boolean isTranspose() { return transpose;}

	@Override
	public double get(int i, int j) throws Exception {
		if(i >=size || j >=size || i < 0 || j < 0) throw new Exception("i ,j not good ");
		if(!matrix.gotoBeginning()) throw new Exception("the list is empty");
		if(isTranspose()) i = i ^ j ^ (j = i);
		do {
			SparseMatrixEntry current = matrix.getCursor();
			if(current.getI() == i && current.getJ() == j) {
				return current.getValue()*constant;
			}
		}while(matrix.gotoNext());
		return defaultValue*constant;
	}

	@Override
	public void put(int i, int j, double x) throws Exception {
		if(i >=size || j >=size || i < 0 || j < 0) throw new Exception("i ,j not good ");
		if(isTranspose()) i = i ^ j ^ (j = i);
		matrix.gotoBeginning();
		SparseMatrixEntry current = matrix.getCursor();
		while(current != null && matrix.gotoNext()) {
			if(current.getI() == i && current.getJ() == j) {
				matrix.gotoPrior();
				matrix.replace(new SparseMatrixEntry(x/constant, i, j));
				return;
			}
			
			current = matrix.getCursor();
		}
		matrix.insert(new SparseMatrixEntry(x/constant, i, j));
	}

	@Override
	public void transpose() {
		transpose = !transpose;
	}

	@Override
	public void multByConstant(int c) {
		constant *= c;
	}
	
	/*
	 * O(size of the linked list)
	 */
	public SparseMatrix add(SparseMatrix mat) throws Exception {
		if(size != mat.size && size == 0) throw new Exception("not the same size");
		SparseMatrix newMat = new SparseMatrix(mat.getSize() , defaultValue+mat.defaultValue);
		matrix.gotoBeginning();
		mat.matrix.gotoBeginning();


		do{
			if(matrix.getCursor() == null) break;
			int i = matrix.getCursor().getI();
			int j = matrix.getCursor().getJ();
			newMat.put(i,j,get(i,j));
		}while(matrix.gotoNext());
		
		do{
			if(mat.matrix.getCursor() == null) break;
			int i = mat.matrix.getCursor().getI();
			int j = mat.matrix.getCursor().getJ();
			double old_value = newMat.get(i, j);
			newMat.put(i, j, mat.get(i, j) + old_value);
		}while(mat.matrix.gotoNext());
		return newMat;
	}
	
	public String toString() {
		StringBuilder ss =  new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				try {
					ss.append(get(i,j) + " ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ss.append('\n');
		}
		return ss.toString();
	}
	
}
