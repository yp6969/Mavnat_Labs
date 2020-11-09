import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestDiagMatrix {

	public static void main(String[] args) throws IOException {
		Matrix mat = new DiagonalMatrix(4);
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		System.out.print("Enter the tasks ( end with quit)  : ");
		
		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
						
			
			switch ( token.sval.toLowerCase() ) { 
			
			
				case "put" : {
					token.nextToken();
					int i = (int)token.nval;
					token.nextToken();
					int j = (int)token.nval;
					token.nextToken();
					int x = (int)token.nval;
					mat.put(i,j,x);
					break;
					
				}
				
				case "Get" : {
					token.nextToken();
					int i = (int)token.nval;
					token.nextToken();
					int j = (int)token.nval;
					System.out.println(mat.get(i, j));
					break;
				}	
				
				case "PrintM" : {
					System.out.println(mat.toString());
					break;
				}			
			
				case "MultConst C" : {
					token.nextToken();
					int c = (int)token.nval;
					mat.multByConstant(c);
					break;
				}			
				case "TransM" : {
					mat.transpose();
					break;
				}
				case "quit" : {
					return;
				}
				
				default : {
					System.out.println("invalid input");
					break;
				}
			}

		}
		
	}

}
