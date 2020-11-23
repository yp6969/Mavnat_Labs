package lab5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class checkBalancedBrackets {
	
	static String openP = "{[(";
	static String closeP = "}])";
	
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer token = new StreamTokenizer(reader);		
		
		while( token.nextToken() == StreamTokenizer.TT_WORD ) {
			String s = (String)token.sval;
			System.out.println(checkBrackets(s));
		}		

	}
	
	public static boolean checkBrackets(String s) {
		StackArray<Character> stack = new StackArray<Character>(Stack.DEF_MAX_STACK_SIZE);
		for (int i = 0; i < s.length(); i++) {
			if(openP.indexOf(s.charAt(i)) != -1) {
				stack.push(s.charAt(i));
			}
			else {
				int idx = closeP.indexOf(s.charAt(i));
				if( idx != -1 ) {
					
				}
				
			}
		}
		return true;
	}

}
