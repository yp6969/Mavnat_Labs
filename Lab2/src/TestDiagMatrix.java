import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestDiagMatrix {

	public static void main(String[] args) {
		Matrix mat = new DiagonalMatrix(4);
		//1
		
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
				
				case "curr" : {
					
					System.out.println(list.getCursor());			
					break;
				}	
				
				case "next" : {

					System.out.println(list.goToNext());
					break;
				}			
			
				case "prev" : {
					System.out.println(list.goToNext());
					break;
				}			
				
				case "start" : {
					System.out.println(list.goToBeginning());
					break;
				}
				
				case "end" : {
					System.out.println(list.goToEnd());
					break;
				}	
				
				case "empty" : {
					System.out.println(list.isEmpty());
					break;
				}	
				
				case "full" : {
					System.out.println(list.isFull());
					break;
				}	
				
				case "clear" : {
					list.clear();
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
