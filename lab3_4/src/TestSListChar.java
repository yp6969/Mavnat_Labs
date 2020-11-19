import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestSListChar {

	public static void main(String[] args) throws IOException {
			
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);
		SLinkedList<Character> list = new SLinkedList<Character>();
		System.out.println("Enter your task");

		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
							
				switch ( token.sval.toLowerCase() ) {
				
				case "add" : {
					token.nextToken();
					String x = (String)token.sval;
					list.insert(x.charAt(0));
					break;
					
				}
				
				case "del" : {
					list.remove();
					break;
				}	
				
				case "mv x" : {
					token.nextToken();
					String x = (String)token.sval;
					list.replace(x.charAt(0));
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
