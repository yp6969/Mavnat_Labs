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
			int idx_o = openP.indexOf(s.charAt(i));
			int idx_c = closeP.indexOf(s.charAt(i));
			if (idx_o == -1 && idx_c == -1) continue;
			else if (idx_o != -1) stack.push(s.charAt(i));
			else {
				char top = stack.pop();
				int topId = openP.indexOf(top);
				if (idx_c != -1 && idx_c == topId) continue;
				else stack.push(top);
			}
		}
		return stack.getTop() == -1;
	}

}
