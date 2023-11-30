import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Search {

public static void main(String[] args) {
    if (args.length != 2) {
        System.out.println("ERROR: Expecting 2 arguments, first path, second word");
    }
    search(args[0], args[1]);
}

private static void search(String path, String word) {
    try {
        File f = new File(path); 
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] words = line.split(" ");
            for (String curWord : words) {
                if (curWord.equals(word)) {
                    System.out.println(line);
                    break;
                }
            }
        }
    } catch (FileNotFoundException notFound) {
        System.out.println("ERROR: path not found");
        notFound.printStackTrace();
    }
    }
}