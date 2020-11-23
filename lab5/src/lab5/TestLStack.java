import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestLStack {

	public static void main(String[] args) throws IOException{
		
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		StackList<Integer> Stack_l = new StackList<Integer>(0);
		System.out.println("Enter your task");

		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
							
				switch ( token.sval.toLowerCase() ) {
				
				case "push" : {
					token.nextToken();
					int x = (int)token.nval;
					Stack_l.push(x);
					break;					
				}	
				
				case "pop" : {
					Stack_l.pop();
					break;
				}	
				
				case "p" : {
					System.out.println( Stack_l.toString() );
					break;
				}			
			
				case "f" : {
					System.out.println(Stack_l.isFull());
					break;
				}			
				case "e" : {
					System.out.println(Stack_l.isEmpty());
					break;
				}
				case "c" : {
					Stack_l.clear();
					break;
				}
				case "q" : {
					System.out.println("Bey Bey");
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
