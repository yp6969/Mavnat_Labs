import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestAVLTree {

	public static void main(String[] args) throws IOException {
		
		AVLTree tree = new AVLTree();
        InputStreamReader reader = new InputStreamReader(System.in);
        StreamTokenizer token = new StreamTokenizer(new FileReader("tetsTree.txt"));

        while( token.nextToken() == StreamTokenizer.TT_WORD ) {


            switch ( token.sval.toLowerCase() ) {

                case "add" : {
                    token.nextToken();
                    int x = (int)token.nval;
                    tree.insert(x);
                    break;
                }

                case "find" : {
                    token.nextToken();
                    int x = (int)token.nval;
                    System.out.println("Find the number: "+tree.retrieve(x).getKey());
                    break;
                }
                case "k" : {
                    System.out.println("print Inorder:\n"+tree);
                    break;
                }

                case "e" : {
                    System.out.println(tree.isEmpty());
                    break;
                }

                case "f" : {
                    System.out.println(tree.isFull());
                    break;
                }
                case "c" : {
                    tree.clear();
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
