import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestSparseMatrix {

	public static void main(String[] args) {
		
		SparseMatrix mat = new SparseMatrix(4, 1);
		SparseMatrix mat1 = new SparseMatrix(7, 3);
		SparseMatrix mat2= new SparseMatrix(4, 2);
		
		try {
			mat.put(3, 3, 6);
			mat.put(1, 0, 7);
			mat.put(2, 2, 8);
			mat1.put(2, 3, 2);
			mat1.put(3, 5, 7);
			mat1.put(4, 2, 8);
			mat2.put(1, 0, 4);
			mat2.put(2, 2, 5);
			mat2.put(3, 1, 6);


		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("print  mat");
		System.out.println(mat.toString());
		System.out.println("executing the method mat.transpose() , and than print again");
		mat.transpose();
		System.out.println(mat.toString());
		
		System.out.println("\nprint  mat1");
		System.out.println(mat1.toString());

		try {
			mat1.put(2, 3, 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("executing the method mat1.put(2, 3, 4) , and than print again");
		System.out.println(mat1.toString());
		
		System.out.println("\nprint  mat2");
		System.out.println(mat2.toString());

		System.out.println("executing the method mat2.multByConstant(5) , and than print again ");
		mat2.multByConstant(5);
		System.out.println(mat2.toString());
		
		System.out.println("executing the method mat.add(mat2) , and than print again \n");
		try {
			SparseMatrix newmat = mat.add(mat2);
			System.out.println(newmat.toString());
			
			System.out.println("executing the method mat.sub(mat2) , and than print again \n");

			newmat = mat.sub(mat2);
			System.out.println(newmat.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
