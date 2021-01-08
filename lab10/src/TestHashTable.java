import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestHashTable {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        StreamTokenizer token = new StreamTokenizer(reader);
        HashTable table = new HashTable();

        System.out.println("Enter your task");
        while( token.nextToken() == StreamTokenizer.TT_WORD ) {

            switch ( token.sval.toLowerCase() ) {

                case "add" : {
                    System.out.println("Enter family , name , id , age , avg ");
                    token.nextToken();
                    String family = (String)token.sval;
                    token.nextToken();
                    String name = (String)token.sval;
                    token.nextToken();
                    int id = (int)token.nval;
                    token.nextToken();
                    int age = (int)token.nval;
                    token.nextToken();
                    double avg = (double)token.nval;

                    HashTableData data = new HashTableData(family, name, id, age, avg);
                    table.insert(data);
                    break;

                }

                case "del" : {
                    System.out.println("Enter family , name , id , age , avg ");
                    token.nextToken();
                    String family = (String)token.sval;
                    token.nextToken();
                    String name = (String)token.sval;
                    token.nextToken();
                    int id = (int)token.nval;
                    token.nextToken();
                    int age = (int)token.nval;
                    token.nextToken();
                    double avg = (double)token.nval;
                    HashTableData data = new HashTableData(family, name, id, age, avg);
                    table.remove(data);
                    break;
                }

                case "find" : {
                    System.out.println("Enter family , name , id , age , avg ");
                    token.nextToken();
                    String family = (String)token.sval;
                    token.nextToken();
                    String name = (String)token.sval;
                    token.nextToken();
                    int id = (int)token.nval;
                    token.nextToken();
                    int age = (int)token.nval;
                    token.nextToken();
                    double avg = (double)token.nval;
                    HashTableData data = new HashTableData(family, name, id, age, avg);
                    table.retrieve(data);
                    break;
                }
                case "e" : {
                    System.out.println(table.isEmpty());
                    break;
                }
                case "c" : {
                    table.clear();
                    break;
                }
                case "print" : {
                    System.out.println(table.toString());
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
