import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestSListChar {

	public static void main(String[] args) throws IOException {
			
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		SLinkedList<Character> list = new SLinkedList<Character>();
		
		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
							
			switch ( token.sval.toLowerCase() ) { 
				
				
				case "ADD" : {
					token.nextToken();
					char x = (char)token.nval;
					list.insert(x);
					break;
					
				}
				
				case "Del" : {
					list.remove();
					break;
				}	
				
				case "Mv x" : {
					token.nextToken();
					char x = (char)token.nval;
					list.replace(x);
					break;
				}			
			
				case "Cur" : {
					System.out.println(list.getCursor());
					break;
				}			
				case "N" : {
					list.gotoNext();
					break;
				}
				case "P" : {
					list.gotoPrior();
					break;
				}
				case "B" : {
					list.gotoBeginning();
					break;
				}
				case "End" : {
					list.gotoEnd();
					break;
				}
				case "E" : {
					System.out.println(list.isEmpty());
					break;
				}
				case "C" : {
					list.clear();
					break;
				}
				case "Print" : {
					System.out.println(list.toString());
					break;
				}
				case "Q" : {
					System.out.println("Bye");
					break;
				}
				default : {
					System.out.println("invalid input");
					break;
				}
			}
		}
	}	
}
