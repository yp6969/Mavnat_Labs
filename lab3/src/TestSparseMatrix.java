import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestSparseMatrix {

	public static void main(String[] args) {
		
		SparseMatrix mat = new SparseMatrix(4, 0);
		SparseMatrix mat1 = new SparseMatrix(7, 3);
		SparseMatrix mat2= new SparseMatrix(4, 1);
		
		try {
			mat.put(3, 3, 2);
			mat.put(1, 0, 7);
			mat.put(2, 2, 8);
			mat1.put(2, 3, 2);
			mat1.put(3, 5, 7);
			mat1.put(4, 2, 8);
			mat2.put(1, 0, 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mat.toString());
//		mat.transpose();
//		System.out.println(mat.toString());
//		try {
//			mat1.put(2, 3, 4);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(mat1.toString());
//		mat2.multByConstant(5);
		System.out.println(mat2.toString());
		
		try {
			SparseMatrix newmat = mat.add(mat2);
			System.out.println(newmat.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
