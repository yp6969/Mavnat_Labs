import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestSListInt {

	public static void main(String[] args) throws IOException {
			
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		SLinkedList<Integer> list = new SLinkedList<Integer>();
		System.out.println("Enter your task");
		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
							
			switch ( token.sval.toLowerCase() ) {
				
				case "add" : {
					token.nextToken();
					int x = (int)token.nval;
					list.insert(x);
					break;
					
				}
				
				case "del" : {
					list.remove();
					break;
				}	
				
				case "mv x" : {
					token.nextToken();
					int x = (int)token.nval;
					list.replace(x);
					break;
				}			
			
				case "cur" : {
					System.out.println(list.getCursor());
					break;
				}			
				case "n" : {
					list.gotoNext();
					break;
				}
				case "p" : {
					list.gotoPrior();
					break;
				}
				case "b" : {
					list.gotoBeginning();
					break;
				}
				case "end" : {
					list.gotoEnd();
					break;
				}
				case "e" : {
					System.out.println(list.isEmpty());
					break;
				}
				case "c" : {
					list.clear();
					break;
				}
				case "print" : {
					System.out.println(list.toString());
					break;
				}
				case "q" : {
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
