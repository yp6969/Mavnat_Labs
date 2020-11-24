package lab5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestAStack {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		StackArray<Integer> stack = new StackArray<Integer>(Stack.DEF_MAX_STACK_SIZE);
		
		
		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
			
			switch ( token.sval.toLowerCase() ) {
				
				case "push" : {
					token.nextToken();
					int x = (int)token.nval;
					stack.push(new Integer(x));
					break;
					
				}
				
				case "pop" : {
					System.out.println(stack.pop());
					break;
				}	
				
				case "p" : {
					System.out.println(stack.toString());
					break;
				}			
			
				case "f" : {
					System.out.println(stack.isFull());
					break;
				}			
				case "e" : {
					System.out.println(stack.isEmpty());
					break;
				}
				case "c" : {
					stack.clear();
					break;
				}
				case "q" : {
					System.out.println("Bye");
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
