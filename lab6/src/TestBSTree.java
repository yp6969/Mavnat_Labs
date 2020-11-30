import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestBSTree {

    public static void main(String[] args) throws IOException {

        BSTree tree = new BSTree();
        InputStreamReader reader = new InputStreamReader(System.in);
        StreamTokenizer token = new StreamTokenizer(reader);

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
                    System.out.println(tree.retrieve(x));
                    break;
                }
                case "k" : {
                    System.out.println(tree.Preorder());
                    System.out.println(tree.Inorder());
                    System.out.println(tree.Postorder());
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
                case "h" : {
                    System.out.println(tree.height());
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
