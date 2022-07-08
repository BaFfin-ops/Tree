import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        NodeTree tree = new NodeTree();
        Scanner in = new Scanner(System.in);
        String path = "file.txt";
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            int a = in.nextInt();
            tree.insert(a);
        }
        tree.printT();
        int b = in.nextInt();
        tree.delete(b);
        tree.printT();
        int c = in.nextInt();
        Node found = tree.find(c);
        found.print();
        int d = in.nextInt();
        tree.insert(d);
        tree.printT();
    }
}
